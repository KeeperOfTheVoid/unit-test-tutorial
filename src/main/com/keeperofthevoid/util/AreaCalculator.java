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
     * @param width Width of square
     * @param height Height of square
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
     * Calculates area of square, given a shape
     * @param square Square shape
     * @return Area for square (Width: 2, Height: 2)
     */
    private Integer calculateAreaForSquare(Shape square) {
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
     * @param width Width of triangle
     * @param height Height of triangle
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
     * Calculates area of triangle, given a shape
     * @param triangle Triangle shape
     * @return Area of triangle (Width: 2, Height: 4)
     */
    private Double calculateAreaForTriangle(Shape triangle) {
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
     * @param width Radius of circle
     * @return Area of circle (Radius: 2)
     */
    public Double calculateAreaForCircle(Integer width) {
        Shape circle = new Shape();
        circle.setWidth(width);
        // Area is 12.566
        return Math.PI * Math.pow((double)circle.getWidth(), 2);
    }

    /**
     * Calculates area of circle, given a shape
     * @param circle Circle shape
     * @return Area of circle (Radius: 2)
     */
    private Double calculateAreaForCircle(Shape circle) {
        // Area is 12.566
        return Math.PI * Math.pow((double)circle.getWidth(), 2);
    }

    /**
     * Calculates if area of square is larger than the area of a circle
     * @param square Square shape
     * @param circle Circle shape
     * @return True if square is larger than circle
     */
    public Boolean isAreaLargerSquareCircle(Shape square, Shape circle) {
        Integer areaForSquare = this.calculateAreaForSquare(square);
        Double areaForCircle = this.calculateAreaForCircle(circle);
        return areaForSquare > areaForCircle;
    }

    /**
     * Calculates if area of square is larger than the area of a triangle
     * @param square Square shape
     * @param triangle Triangle shape
     * @return True if square is larger than triangle
     */
    public Boolean isAreaLargerSquareTriangle(Shape square, Shape triangle) {
        Integer areaForSquare = this.calculateAreaForSquare(square);
        Double areaForCircle = this.calculateAreaForTriangle(triangle);
        return areaForSquare > areaForCircle;
    }
}
