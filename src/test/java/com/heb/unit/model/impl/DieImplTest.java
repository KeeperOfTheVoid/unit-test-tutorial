package com.heb.unit.model.impl;


import com.heb.unit.model.Die;
import org.junit.Test;

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
}