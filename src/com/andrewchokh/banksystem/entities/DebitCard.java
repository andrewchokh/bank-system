package com.andrewchokh.banksystem.entities;

import com.andrewchokh.banksystem.entities.enums.Currency;

public class DebitCard {
    private final User owner;
    private final Account account;
    private final String number;
    private final String validUntilDate;
    private final String secretCode;

    public DebitCard(User owner, Account account, String number, String validUntilDate, String secretCode) {
        this.owner = owner;
        this.account = account;
        this.number = number;
        this.validUntilDate = validUntilDate;
        this.secretCode = secretCode;
    }

    public User getOwner() {
        return owner;
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

    public Account getAccount() {
        return account;
    }

    public void replenishBalance(float amount, Currency currency) {
        if (amount <= 0) throw new RuntimeException("Amount must be natural number");

        Account.Balance balance = account.getBalance();

        switch (currency) {
            case UAH -> balance.setUAHBalance(balance.getUAHBalance() + amount);
            case EUR -> balance.setEURBalance(balance.getEURBalance() + amount);
            case USD -> balance.setUSDBalance(balance.getUSDBalance() + amount);
        }
    }

    public void withdrawBalance(float amount, Currency currency) {
        if (amount <= 0) throw new RuntimeException("Amount must be natural number");

        Account.Balance balance = account.getBalance();

        switch (currency) {
            case UAH -> balance.setUAHBalance(balance.getUAHBalance() - amount);
            case EUR -> balance.setEURBalance(balance.getEURBalance() - amount);
            case USD -> balance.setUSDBalance(balance.getUSDBalance() - amount);
        }
    }
}
