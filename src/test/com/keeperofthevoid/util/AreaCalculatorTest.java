package com.keeperofthevoid.util;

import com.keeperofthevoid.model.Shape;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * AreaCalculatorTest
 *
 * @author KeeperOfTheVoid (Matthew Lalmansingh)
 */
public class AreaCalculatorTest {
    private AreaCalculator areaCalculator;

    private Shape square;
    private Shape triangle;
    private Shape circle;

    private Integer width;
    private Integer height;

    @Before
    public void setUp() {
        areaCalculator = new AreaCalculator();

        square = new Shape(2,2);
        triangle = new Shape(2,4);
        circle = new Shape(2);

        this.width = 2;
        this.height = 4;
    }

    @Test
    public void testCalculateAreaForSquare() {
        assertNotNull(areaCalculator.calculateAreaForSquare());
        assertEquals(areaCalculator.calculateAreaForSquare(), (Integer) 4);
    }

    /**
     * Unit tests test behavior, not parameters
     * However, you can test if certain exceptions are thrown
     */
    @Test(expected = NullPointerException.class)
    public void testCalculateAreaForSquareWithParameters() {
        assertNotNull(areaCalculator.calculateAreaForSquare(width,height));
        assertEquals(areaCalculator.calculateAreaForSquare(width,height), (Integer) 8);
        assertEquals(areaCalculator.calculateAreaForSquare(null,null), (Integer) 8);
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

    @Test
    public void testIsAreaLargerSquareCircle() {
        assertNotNull(areaCalculator.isAreaLargerSquareCircle(square, circle));
        assertFalse(areaCalculator.isAreaLargerSquareCircle(square, circle));
    }

    @Test
    public void testIsAreaLargerSquareTriangle() {
        assertNotNull(areaCalculator.isAreaLargerSquareCircle(square, triangle));
        assertFalse(areaCalculator.isAreaLargerSquareCircle(square, triangle));
    }
}
