package com.andrewchokh.banksystem.entities;

import com.andrewchokh.banksystem.entities.enums.Currency;

import java.util.ArrayList;

public class Account {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String login;
    private final String password;
    private final ArrayList<DebitCard> cards;

    Account(int id, String firstName, String lastName, String login, String password, ArrayList<DebitCard> cards) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.cards = cards;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<DebitCard> getCards() {
        return cards;
    }

    static class Balance {
        private int UAHBalance;
        private int EURBalance;
        private int USDBalance;

        Balance() {
            this.UAHBalance = 0;
            this.EURBalance = 0;
            this.USDBalance = 0;
        }

        public void setUAHBalance(int UAHBalance) {
            this.UAHBalance = UAHBalance;
        }

        public void setEURBalance(int EURBalance) {
            this.EURBalance = EURBalance;
        }

        public void setUSDBalance(int USDBalance) {
            this.USDBalance = USDBalance;
        }

        public int getUAHBalance() {
            return UAHBalance;
        }

        public int getEURBalance() {
            return EURBalance;
        }

        public int getUSDBalance() {
            return USDBalance;
        }
    }
}
