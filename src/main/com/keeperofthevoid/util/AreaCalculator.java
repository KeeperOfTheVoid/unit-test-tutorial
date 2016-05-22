package com.keeperofthevoid.util;

import com.keeperofthevoid.model.Shape;

/**
 * AreaCalculator
 *
 * Calculates areas for various shapes
 *
 * @author KeeperOfTheVoid (Matthew Lalmansingh)
 *
 * @since 5/20/16
 */
public class AreaCalculator {
    /**
     * Calculates area of square
     * @return Area for square (Width: 2, Height: 2)
     */
    public Integer calculateAreaForSquare() {
        Shape square = new Shape(2,2);
        // Area is 4
        return square.getWidth() * square.getHeight();
    }

    /**
     * Calculates area of square
     * @return Area for square (Width: 2, Height: 2)
     */
    public Integer calculateAreaForSquare(Integer width, Integer height) {
        Shape square = new Shape();
        square.setWidth(width);
        square.setHeight(height);
        // Area is 4
        return square.getWidth() * square.getHeight();
    }

    /**
     * Calculates area of triangle
     * @return Area of triangle (Width: 2, Height: 4)
     */
    public Double calculateAreaForTriangle() {
        Shape triangle = new Shape(2,4);
        // Area is 4
        return (triangle.getWidth() * triangle.getHeight())/2.0;
    }

    /**
     * Calculates area of triangle
     * @return Area of triangle (Width: 2, Height: 4)
     */
    public Double calculateAreaForTriangle(Integer width, Integer height) {
        Shape triangle = new Shape();
        triangle.setWidth(width);
        triangle.setHeight(height);
        // Area is 4
        return (triangle.getWidth() * triangle.getHeight())/2.0;
    }

    /**
     * Calculates area of circle
     * @return Area of circle (Radius: 2)
     */
    public Double calculateAreaForCircle() {
        Shape circle = new Shape(2);
        // Area is 12.566
        return Math.PI * Math.pow((double)circle.getWidth(), 2);
    }

    /**
     * Calculates area of circle
     * @return Area of circle (Radius: 2)
     */
    public Double calculateAreaForCircle(Integer width) {
        Shape circle = new Shape();
        circle.setWidth(width);
        // Area is 12.566
        return Math.PI * Math.pow((double)circle.getWidth(), 2);
    }
}
