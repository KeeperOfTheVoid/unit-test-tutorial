package com.heb.unit.model.impl;

import com.heb.unit.model.Die;

import java.util.Random;

/**
 * Die Implementation Class
 *
 * @author l640395 Matthew Lalmansingh
 * @since 1/31/2017
 */
public class DieImpl implements Die {
    private Random random;
    private int pips;

    DieImpl(Random random) {
        this(random, 1);
    }

    DieImpl(Random random, int pips) {
        this.random = random;
        this.pips = pips;
    }

    public int getPips() {
        return pips;
    }

    public Die roll() {
        return new DieImpl(random, random.nextInt(6) + 1);
    }
}

