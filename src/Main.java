import com.andrewchokh.banksystem.console.ItemGenerator;
import com.andrewchokh.banksystem.entities.Account;
import com.andrewchokh.banksystem.entities.DebitCard;
import com.andrewchokh.banksystem.entities.Product;
import com.andrewchokh.banksystem.entities.User;
import com.andrewchokh.banksystem.entities.enums.Currency;

import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int userChoice;
        User currentUser;

        ItemGenerator.Generate();

        var users = ItemGenerator.getUsers();
        var accounts = ItemGenerator.getAccounts();
        var debitCards = ItemGenerator.getDebitCards();
        var products = ItemGenerator.getProducts();

        // Getting user
        StringBuilder userSelect = new StringBuilder("Who are you?\n");
        for (int i = 0; i < users.size(); i++) {
            userSelect.append("%s. %s\n".formatted(i + 1, users.get(i).getFullName()));
        }

        System.out.println(userSelect);
        userChoice = in.nextInt();

        if (userChoice < 1 || userChoice > users.size()) return;

        currentUser = users.get(userChoice - 1);

        if (currentUser.getUserAccount() != null) {
            in.nextLine();

            System.out.println("Enter login");
            String login = in.nextLine();

            System.out.println("Enter password");
            String password = in.nextLine();

            currentUser.Authorize(login, password);

            if (!login.equals(currentUser.getUserAccount().getLogin()) ||
                    !password.equals(currentUser.getUserAccount().getPassword())) {
                return;
            }
        }

        while (true) {
            Product wantedProduct;
            int productAmount;
            float accountMoney;
            float totalPrice;

            DebitCard card;

            // Getting product
            StringBuilder productSelect = new StringBuilder("What do you want to buy?\n");
            for (int i = 0; i < products.size(); i++) {
                productSelect.append((i + 1)).append(". ").append(products.get(i).getName()).append("\n");
            }

            System.out.println(productSelect);
            userChoice = in.nextInt();

            if (userChoice < 1 || userChoice > products.size()) break;

            wantedProduct = products.get(userChoice - 1);

            System.out.println("How much product do you need?");
            userChoice = in.nextInt();

            if (userChoice < 1) break;

            productAmount = userChoice;

            // Getting card
            if (currentUser.getCards().size() > 1) {
                StringBuilder cardSelect = new StringBuilder("Select card\n");
                for (int i = 0; i < debitCards.size(); i++) {
                    cardSelect.append((i + 1)).append(". ").append(debitCards.get(i).getNumber()).append("\n");
                }

                System.out.println(productSelect);
                userChoice = in.nextInt();

                if (userChoice < 1 || userChoice > debitCards.size()) break;

                card = debitCards.get(userChoice - 1);
            }
            else if (currentUser.getCards().size() == 1) {
                card = debitCards.get(0);
            }
            else {
                System.out.println("You don't have a debit card!");
                return;
            }

            if (currentUser.getUserAccount() == null) {
                System.out.println("You don't have an account to do the payment!");
                return;
            }

            Account.Balance balance = currentUser.getUserAccount().getBalance();

            switch (wantedProduct.getCurrency()) {
                case UAH -> accountMoney = balance.getUAHBalance();
                case EUR -> accountMoney = balance.getEURBalance();
                case USD -> accountMoney = balance.getUSDBalance();
                default -> accountMoney = 0;
            }

            totalPrice = wantedProduct.getPrice() * productAmount;

            if (accountMoney < totalPrice) {
                System.out.println("You don't have enough money.");
                return;
            }

            switch (wantedProduct.getCurrency()) {
                case UAH -> card.withdrawBalance(totalPrice, Currency.UAH);
                case EUR -> card.withdrawBalance(totalPrice, Currency.EUR);
                case USD -> card.withdrawBalance(totalPrice, Currency.USD);
            }

            System.out.printf("%s [%s] - купив/ла %s (%d) %s %s %s. Залишилось на балансі - %s.\n",
                    currentUser.getFullName(), card.getNumber(),wantedProduct.getName(), productAmount, totalPrice,
                    wantedProduct.getCurrency().toString(), LocalDateTime.now(), accountMoney - totalPrice
            );
        }
    }
}