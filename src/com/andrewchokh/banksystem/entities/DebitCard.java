package com.andrewchokh.banksystem.entities;

import com.andrewchokh.banksystem.entities.enums.Currency;

public class DebitCard {
    private final int id;
    private final Account ownerAccount;
    private final String number;
    private final String validUntilDate;
    private final String secretCode;

    DebitCard(int id, Account ownerAccount, String number, String validUntilDate, String secretCode) {
        this.id = id;
        this.ownerAccount = ownerAccount;
        this.number = number;
        this.validUntilDate = validUntilDate;
        this.secretCode = secretCode;
    }

    public int getId() {
        return id;
    }

    public Account getOwnerAccount() {
        return ownerAccount;
    }

    public String getNumber() {
        return number;
    }

    public String getValidUntilDate() {
        return validUntilDate;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void replenishBalance(int amount, Currency currency) {

    }

    public void withdrawBalance(int amount, Currency currency) {

    }
}
