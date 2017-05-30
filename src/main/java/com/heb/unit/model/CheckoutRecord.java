package com.heb.unit.model;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.MONTHS;

/**
 * CheckoutRecord
 *
 * @author l640395 Matthew Lalmansingh & s730825 Josh Smith
 * @since 5/30/2017
 */
public class CheckoutRecord {
    private String author;
    private String title;
    private LocalDate date;

    public CheckoutRecord(String author, String title, LocalDate date) {
        this.author = author;
        this.title = title;
        this.date = date;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int calculatePenalty(LocalDate now) {
        if (now.isBefore(this.date)) return 0;
        return (int) MONTHS.between(this.date, now) * 10;
    }
}
