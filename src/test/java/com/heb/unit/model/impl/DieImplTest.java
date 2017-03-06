package com.heb.unit.model.impl;


import com.heb.unit.category.IntegrationTest;
import com.heb.unit.category.UnitTest;
import com.heb.unit.model.Die;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

import java.util.Random;

import static junit.framework.TestCase.fail;
import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Die Implementation Test
 *
 * @author l640395 Matthew Lalmansingh
 * @since 1/31/2017
 */
public class DieImplTest {
    @Test
    @Category(UnitTest.class)
    public void testDefaultIs1() {
        Random random = new Random() {
            @Override
            public int nextInt() {
                return 4;
            }
        }; //Dummy!

        Die die = new DieImpl(random);
        assertThat(die.getPips()).isEqualTo(1);
    }

    @Test
    @Category(UnitTest.class)
    public void testSimpleRollOf4() {
        // Stub
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return 3;
            }
        };

        Die die = new DieImpl(random);
        assertThat(die.roll().getPips()).isEqualTo(4);
    }

    @Test
    @Category(UnitTest.class)
    public void testSimpleRollOf4Twice() {
        // Stub
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return 3;
            }
        };

        Die die = new DieImpl(random);
        assertThat(die.roll().roll().getPips()).isEqualTo(4);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testIntegrationRoll() {
        Die die = new DieImpl(new Random());

        for (int i = 0; i < 1000000; i++) {
            assertThat(die.roll().getPips()).isGreaterThan(0).isLessThan(7);
        }
    }

    // Unit Test Tied to JIRA #
    @Test
    @Category(UnitTest.class)
    public void testBUG1004() {
        // Create mock
        Random random = createMock(Random.class);

        // Reherse
        //expect(random.nextInt(anyInt())).andReturn(4);
        expect(random.nextInt(6)).andReturn(4);

        // Rewind (EasyMock, not with mockito) - Should probably do this with EasyMock
        replay(random);

        // Run test
        Die die = new DieImpl(random); //Subject under test
        // assertThat(die.getPips()).isEqualTo(????) Just temp code
        assertThat(die.roll().getPips()).isGreaterThan(0).isLessThan(7);

        // Verify
        verify(random);
    }

    @Test
    @Category(UnitTest.class)
    public void testBUG1004WithZero() {
        Random random = createMock(Random.class);

        expect(random.nextInt(6)).andReturn(0);

        replay(random); //Marking mock to run

        Die die = new DieImpl(random);
        assertThat(die.roll().getPips()).isGreaterThan(0).isLessThan(7);

        verify(random);
    }

    @Test
    @Category(UnitTest.class)
    public void testBUG1004UsingMockito() {
        Random random = mock(Random.class);
        when(random.nextInt(6)).thenReturn(3);

        Die die = new DieImpl(random);
        assertThat(die.roll().getPips()).isGreaterThan(0).isLessThan(7);
    }

    @Test
    @Category(UnitTest.class)
    public void testRandomShouldNotBeNull() {
        try {
            new DieImpl(null);
            fail("This should not be here");
        } catch (NullPointerException ex) { // IllegalArgumentException
            assertThat(ex).hasMessage("Random cannot be null");
        }
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    @Category(UnitTest.class)
    public void testThatRandomIsNotNull() throws Exception {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage(DieImpl.RANDOM_IS_NULL);
        new DieImpl(null);
    }
}