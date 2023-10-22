package com.andrewchokh.banksystem.entities;

public class Account {
    private final User owner;
    private final String login;
    private final String password;

    private final Balance balance;

    public Account(User owner, String login, String password) {
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
        private float UAHBalance;
        private float EURBalance;
        private float USDBalance;

        Balance() {
            this.UAHBalance = 0;
            this.EURBalance = 0;
            this.USDBalance = 0;
        }

        public void setUAHBalance(float UAHBalance) {
            this.UAHBalance = UAHBalance;
        }

        public void setEURBalance(float EURBalance) {
            this.EURBalance = EURBalance;
        }

        public void setUSDBalance(float USDBalance) {
            this.USDBalance = USDBalance;
        }

        public float getUAHBalance() {
            return UAHBalance;
        }

        public float getEURBalance() {
            return EURBalance;
        }

        public float getUSDBalance() {
            return USDBalance;
        }
    }
}
