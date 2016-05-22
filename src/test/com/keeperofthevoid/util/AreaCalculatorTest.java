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

    private Integer width;
    private Integer height;

    @Before
    public void setUp() {
        areaCalculator = new AreaCalculator();

        this.width = 2;
        this.height = 4;
    }

    @Test
    public void testCalculateAreaForSquare() {
        assertNotNull(areaCalculator.calculateAreaForSquare());
        assertEquals(areaCalculator.calculateAreaForSquare(), (Integer) 4);
    }

    @Test
    public void testCalculateAreaForSquareWithParameters() {
        assertNotNull(areaCalculator.calculateAreaForSquare(width,height));
        assertEquals(areaCalculator.calculateAreaForSquare(width,height), (Integer) 4);
    }

    @Test
    public void testCalculateAreaForTriangle() {
        assertNotNull(areaCalculator.calculateAreaForTriangle());
        assertEquals(areaCalculator.calculateAreaForTriangle(), (Double) 4.0);
    }

    @Test
    public void testCalculateAreaForTriangleWithParameters() {
        assertNotNull(areaCalculator.calculateAreaForTriangle(width, height));
        assertEquals(areaCalculator.calculateAreaForTriangle(width,height), (Double) 4.0);
    }

    @Test
    public void testCalculateAreaForCircle() {
        assertNotNull(areaCalculator.calculateAreaForCircle());
        assertEquals(areaCalculator.calculateAreaForCircle(), 12.566, 0.001);
    }

    @Test
    public void testCalculateAreaForCircleWithParameters() {
        assertNotNull(areaCalculator.calculateAreaForCircle(width));
        assertEquals(areaCalculator.calculateAreaForCircle(width), 12.566, 0.001);
    }
}
