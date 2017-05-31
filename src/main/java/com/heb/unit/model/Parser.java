package com.heb.unit.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
        return stream.map(this::convertStringToRecord).collect(Collectors.toList());
    }

    private CheckoutRecord convertStringToRecord(String record) {
        String[] items = record.split(delimeter);
        if (items.length != 3)
            throw new IllegalArgumentException(
                    String.format("Invalid data could not split on: %s", delimeter));
        return new CheckoutRecord(items[0], items[1], LocalDate.parse(items[2]));
    }
}
