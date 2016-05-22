package com.keeperofthevoid;

import com.keeperofthevoid.model.Shape;
import com.keeperofthevoid.util.AreaCalculator;

public class Main {

    public static void main(String[] args) {
        AreaCalculator areaCalculator = new AreaCalculator();

        Shape square = new Shape(2, 2);
        Shape circle = new Shape(2);
        Shape triangle = new Shape(2, 4);

        System.out.println("No parameters");
        System.out.println("Area for square: " + areaCalculator.calculateAreaForSquare());
        System.out.printf("Area for square: %.2f\n", areaCalculator.calculateAreaForTriangle());
        System.out.printf("Area for square: %.2f\n\n", areaCalculator.calculateAreaForCircle());

        System.out.println("With parameters");
        System.out.println("Area for square: " + areaCalculator.calculateAreaForSquare(2, 2));
        System.out.printf("Area for square: %.2f\n", areaCalculator.calculateAreaForTriangle(2, 4));
        System.out.printf("Area for square: %.2f\n\n", areaCalculator.calculateAreaForCircle(2));

        System.out.println("Boolean");
        System.out.println("Square > Circle: " + areaCalculator.isAreaLargerSquareCircle(square, circle));
        System.out.println("Square > Triangle: " + areaCalculator.isAreaLargerSquareTriangle(square, triangle));
    }
}
