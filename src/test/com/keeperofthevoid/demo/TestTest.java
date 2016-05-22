package com.keeperofthevoid.demo;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestTest {
    String msg = "Hello World";

    @Test
    public void testPrintMessage() {
        assertEquals(msg, "Hello World");
    }
}