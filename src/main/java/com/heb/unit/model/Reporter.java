package com.heb.unit.model;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Supplier;

/**
 * Reporter
 *
 * @author l640395 Matthew Lalmansingh & s730825 Josh Smith
 * @since 5/30/2017
 */
public class Reporter {
    private List<CheckoutRecord> asList;
    private Supplier<LocalDate> supplier;

    public Reporter(List<CheckoutRecord> asList, Supplier<LocalDate> supplier) {
        this.asList = asList;
        this.supplier = supplier;
    }

    public List<CheckoutRecord> reportViolators(int count) {
        return null;

    }

    public List<String> reportViolatorsAsString(int i) {
        return null;
    }
}
