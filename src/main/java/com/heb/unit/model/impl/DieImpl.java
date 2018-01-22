package com.heb.unit.model.impl;

import com.heb.unit.model.Die;

import java.util.Objects;
import java.util.Random;

/**
 * Die Implementation Class
 *
 * @author l640395 Matthew Lalmansingh
 * @since 1/31/2017
 */
public class DieImpl implements Die {
    private static final int DEFAULT_PIPS = 1;
    protected static final String RANDOM_IS_NULL = "Random cannot be null";

    private final Random random;
    private final int pips;

    DieImpl(Random random) {
        this(random, DEFAULT_PIPS);
    }

    private DieImpl(Random random, int pips) {
        Objects.requireNonNull(random, RANDOM_IS_NULL);
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

