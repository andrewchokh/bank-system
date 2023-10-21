package com.andrewchokh.banksystem.entities.enums;

public enum Currency {
    UAH("UAH"),
    EUR("EUR"),
    USD("USD");

    private final String currency;

    Currency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return currency;
    }
}
