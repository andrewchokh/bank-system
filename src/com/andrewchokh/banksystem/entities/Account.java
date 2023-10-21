package com.andrewchokh.banksystem.entities;

import java.util.ArrayList;

public class Account {
    private final User owner;
    private final String login;
    private final String password;

    private final Balance balance;

    Account(User owner, String login, String password) {
        this.owner = owner;
        this.login = login;
        this.password = password;
        this.balance = new Balance();
    }


    public User getOwner() {
        return owner;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Balance getBalance() {
        return balance;
    }

    public static class Balance {
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
