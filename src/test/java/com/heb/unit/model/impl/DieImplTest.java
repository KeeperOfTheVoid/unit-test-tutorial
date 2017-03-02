package com.heb.unit.model.impl;


import com.heb.unit.model.Die;
import org.junit.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Die Implementation Test
 *
 * @author l640395 Matthew Lalmansingh
 * @since 1/31/2017
 */
public class DieImplTest {
    @Test
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
    public void testIntegrationRoll() {
        Die die = new DieImpl(new Random());

        for (int i = 0; i < 1000000; i++) {
            assertThat(die.roll().getPips()).isGreaterThan(0).isLessThan(7);
        }
    }
}