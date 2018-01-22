package com.heb.unit.util;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * AreaCalculatorTest
 *
 * @author KeeperOfTheVoid (Matthew Lalmansingh)
 */
public class AreaCalculatorTest {
    private AreaCalculator areaCalculator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

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
        Integer expected = 4;
        Integer actual = areaCalculator.calculateAreaForSquare();
        assertNotNull(areaCalculator.calculateAreaForSquare());
        assertEquals(expected, actual);
    }

    /**
     * Unit tests test behavior, not parameters
     * However, you can test if certain exceptions are thrown
     */
    @Test(expected = NullPointerException.class)
    public void testCalculateAreaForSquareWithParameters() {
        assertNotNull(areaCalculator.calculateAreaForSquare(width, height));
        assertEquals((Integer) 8, areaCalculator.calculateAreaForSquare(width, height));
        assertEquals((Integer) 8, areaCalculator.calculateAreaForSquare(null, null));
    }

    /**
     * Alternative method of testing exceptions
     */
    @Test
    public void testCalculateAreaForSquareWithNullParameters() {
        thrown.expect(NullPointerException.class);
        areaCalculator.calculateAreaForSquare(null, null);
    }

    @Test
    public void testCalculateAreaForTriangle() {
        assertNotNull(areaCalculator.calculateAreaForTriangle());
        assertEquals((Double) 4.0, areaCalculator.calculateAreaForTriangle());
    }

    @Test
    public void testCalculateAreaForTriangleWithParameters() {
        assertNotNull(areaCalculator.calculateAreaForTriangle(width, height));
        assertEquals((Double) 4.0, areaCalculator.calculateAreaForTriangle(width, height));
    }

    @Test
    public void testCalculateAreaForCircle() {
        assertNotNull(areaCalculator.calculateAreaForCircle());
        assertEquals(12.566, areaCalculator.calculateAreaForCircle(), 0.001);
    }

    @Test
    public void testCalculateAreaForCircleWithParameters() {
        assertNotNull(areaCalculator.calculateAreaForCircle(width));
        assertEquals(12.566, areaCalculator.calculateAreaForCircle(width), 0.001);
    }
}
