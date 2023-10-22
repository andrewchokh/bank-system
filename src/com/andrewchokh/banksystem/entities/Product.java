package com.andrewchokh.banksystem.entities;

import com.andrewchokh.banksystem.entities.enums.Currency;

public class Product {
    private final int id;
    private final String name;
    private final float price;
    private final Currency currency;

    public Product(int id, String name, float price, Currency currency) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }
}
