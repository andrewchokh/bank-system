package com.andrewchokh.banksystem.entities;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String firstName;
    private final String lastName;

    private Account userAccount;
    private List<DebitCard> cards;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userAccount = null;
        this.cards = new ArrayList<>();
    }

    User(String firstName, String lastName, Account userAccount, List<DebitCard> cards) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userAccount = userAccount;
        this.cards = cards;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getUserAccount() {
        return userAccount;
    }

    public List<DebitCard> getCards() {
        return cards;
    }

    public void CreateAccount(String login, String password) {
        userAccount = new Account(this, login, password);
    }

    public void AddCard(Account account, String number, String validUntilDate, String secretCode) {
        cards.add(new DebitCard(this, account, number, validUntilDate, secretCode));
    }

    public void Authorize(String login, String password) {
        if (userAccount == null) CreateAccount(login, password);

        if (userAccount.getLogin().equals(login) && userAccount.getPassword().equals(password)) {
            System.out.printf("""
                    Full Name: %s
                    Amount of cards: %s
                    Balance: 
                        UAH: %s
                        EUR: %s
                        USD: %s
                        
                    """,
                    firstName + " " + lastName, cards.size(), userAccount.getBalance().getUAHBalance(),
                    userAccount.getBalance().getEURBalance(), userAccount.getBalance().getUSDBalance());
        }
    }
}
