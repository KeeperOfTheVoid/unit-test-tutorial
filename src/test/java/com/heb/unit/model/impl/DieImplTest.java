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
        Die die = new DieImpl();
        assertThat(die.getPips()).isEqualTo(1);
    }

    @Test
    public void testSimpleRollOf4() {
        // Stub
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return 4;
            }
        };

        Die die = new DieImpl(random);
        assertThat(die.roll().getPips()).isEqualTo(4);
    }
}