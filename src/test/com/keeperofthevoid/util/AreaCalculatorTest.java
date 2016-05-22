package com.keeperofthevoid.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * AreaCalculatorTest
 *
 * @author KeeperOfTheVoid (Matthew Lalmansingh)
 */
public class AreaCalculatorTest {
    private AreaCalculator areaCalculator;

    @Before
    public void setUp() {
        areaCalculator = new AreaCalculator();
    }

    @Test
    public void testCalculateAreaForSquare() {
        assertNotNull(areaCalculator.calculateAreaForSquare());
        assertEquals(areaCalculator.calculateAreaForSquare(), (Integer) 4);
    }

    @Test
    public void testCalculateAreaForTriangle() {
        assertNotNull(areaCalculator.calculateAreaForTriangle());
        assertEquals(areaCalculator.calculateAreaForTriangle(), (Double) 4.0);
    }

    @Test
    public void testCalculateAreaForCircle() {
        assertNotNull(areaCalculator.calculateAreaForCircle());
        assertEquals(areaCalculator.calculateAreaForCircle(), 12.566, 0.001);
    }
}
