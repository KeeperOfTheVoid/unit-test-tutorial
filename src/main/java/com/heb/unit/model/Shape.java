package com.heb.unit.model;

/**
 * Shape class
 *
 * @author KeeperOfTheVoid (Matthew Lalmansingh)
 *
 * @since 5/20/16
 */
public class Shape {
    private int width;
    private int height;

    public Shape() {}

    public Shape(Integer width) {
        this.width = width;
    }

    public Shape(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
