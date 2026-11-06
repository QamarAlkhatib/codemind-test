package codemind;

import java.math.BigDecimal;

public class Account {
    private final String id;
    private BigDecimal balance;

    public Account(String id, BigDecimal balance) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Account id is required");
        }
        if (balance == null || balance.signum() < 0) {
            throw new IllegalArgumentException("Opening balance must be zero or more");
        }
        this.id = id;
        this.balance = balance;
    }

    public String getId() { return id; }
    public BigDecimal getBalance() { return balance; }

    public void debit(BigDecimal amount) {
        requirePositive(amount);
        if (balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance = balance.subtract(amount);
    }

    public void credit(BigDecimal amount) {
        requirePositive(amount);
        balance = balance.add(amount);
    }

    private static void requirePositive(BigDecimal amount) {
        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }
}