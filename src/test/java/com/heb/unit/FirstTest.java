package com.heb.unit.model.impl;

import com.heb.unit.category.UnitTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * First Test 
 *
 * Initial test for Project Initialization
 *
 * @author l640395 Matthew Lalmansingh
 * @since 1/21/2018
 */
public class FirstTest {
    @Test
    @Category(value = UnitTest.class)
    public void testSomething() {
        assertThat(true).isEqualTo(true);
    }

}