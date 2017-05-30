package com.heb.unit.model;

import java.util.List;
import java.util.stream.Stream;

/**
 * Parser
 *
 * @author l640395 Matthew Lalmansingh & s730825 Josh Smith
 * @since 5/30/2017
 */
public class Parser {
    private String delimeter;

    public Parser(String delimeter) {
        this.delimeter = delimeter;
    }

    public List<CheckoutRecord> getCheckoutRecords(Stream<String> stream) {
        return null;
    }

    private CheckoutRecord convertStringToRecord(String record) {
        return null;
    }
}
