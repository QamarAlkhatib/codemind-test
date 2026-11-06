package codemind;

import java.util.ArrayList;
import java.util.List;

public class PaymentService {

    private final AccountRepository accounts;
    private final CurrencyConverter converter;
    private final List<String> auditLog = new ArrayList<>();

    public PaymentService(AccountRepository accounts, CurrencyConverter converter) {
        this.accounts = accounts;
        this.converter = converter;
    }

    public boolean pay(String customerId, double amount, String currency, String cardNumber) {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount");
        }

        double usd = converter.toUsd(amount, currency);
        Account account = accounts.findById(customerId);

        if (account.getBalance() < usd) {
            return false;
        }

        account.setBalance(account.getBalance() - usd);
        auditLog.add("Paid " + usd + " with card " + cardNumber);
        return true;
    }

    public void transfer(String fromId, String toId, double amount) {
        Account from = accounts.findById(fromId);
        Account to = accounts.findById(toId);

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
    }
}