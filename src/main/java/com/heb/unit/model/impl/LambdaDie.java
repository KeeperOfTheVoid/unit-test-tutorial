package com.heb.unit.model.impl;

import com.heb.unit.model.Die;

import java.util.function.Supplier;

/**
 * LambdaDie Class
 *
 * @author l640395 Matthew Lalmansingh
 * @since 3/2/2017
 */
public class LambdaDie implements Die {
    public LambdaDie(Supplier<Integer> supplier){}

    @Override
    public int getPips() {
        return 0;
    }

    @Override
    public Die roll() {
        return null;
    }
}
