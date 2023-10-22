package com.andrewchokh.banksystem.console;

import com.andrewchokh.banksystem.entities.Account;
import com.andrewchokh.banksystem.entities.DebitCard;
import com.andrewchokh.banksystem.entities.Product;
import com.andrewchokh.banksystem.entities.User;
import com.andrewchokh.banksystem.entities.enums.Currency;

import java.util.ArrayList;
import java.util.List;

public class ItemGenerator {
    private static final List<User> users = new ArrayList<>();
    private static final List<Account> accounts = new ArrayList<>();
    private static final List<DebitCard> debitCards = new ArrayList<>();
    private static final List<Product> products = new ArrayList<>();

    public static void Generate() {
        users.add(new User("Іван", "Гончар"));
        users.add(new User("Світлана", "Килим"));
        users.add(new User("Сергій", "Ковач"));

        accounts.add(new Account(users.get(0), "ivan123", "0000"));
        accounts.add(new Account(users.get(1), "sergii1996", "123456"));
        accounts.get(0).getBalance().setUAHBalance(1000f);
        accounts.get(0).getBalance().setEURBalance(50f);
        accounts.get(0).getBalance().setUSDBalance(120f);
        accounts.get(1).getBalance().setUAHBalance(900f);
        accounts.get(1).getBalance().setEURBalance(40f);
        accounts.get(1).getBalance().setUSDBalance(90f);
        users.get(0).setUserAccount(accounts.get(0));
        users.get(2).setUserAccount(accounts.get(1));

        debitCards.add(new DebitCard(users.get(0), accounts.get(0), "5168755903995484", "09/24", "023"));
        debitCards.add(new DebitCard(users.get(1), null, "5168739854646231", "06/25", "631"));
        debitCards.add(new DebitCard(users.get(2), accounts.get(1), "5168549475200393", "10/24", "459"));
        users.get(0).AddCard(debitCards.get(0));
        users.get(1).AddCard(debitCards.get(1));
        users.get(2).AddCard(debitCards.get(2));

        products.add(new Product(10, "Шоколад", 56f, Currency.UAH));
        products.add(new Product(11, "Банан", 49f, Currency.UAH));
        products.add(new Product(12, "Рис", 59f, Currency.UAH));
        products.add(new Product(13, "Гречка", 69f, Currency.UAH));
        products.add(new Product(14, "Картопля", 9f, Currency.UAH));
        products.add(new Product(15, "Шоколад", 56f, Currency.UAH));
        products.add(new Product(16, "Снікерс", 0.8f, Currency.USD));
        products.add(new Product(17, "Кока-кола", 0.85f, Currency.USD));
        products.add(new Product(18, "Пітая", 7f, Currency.EUR));
        products.add(new Product(19, "Пластівці", 1f, Currency.EUR));
    }

    public static List<User> getUsers() {
        return users;
    }

    public static List<Account> getAccounts() {
        return accounts;
    }

    public static List<DebitCard> getDebitCards() {
        return debitCards;
    }

    public static List<Product> getProducts() {
        return products;
    }
}
