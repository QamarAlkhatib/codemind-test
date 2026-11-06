package codemind;

import java.math.BigDecimal;

public class PaymentService {
    private final AccountRepository accounts;

    public PaymentService(AccountRepository accounts) {
        if (accounts == null) {
            throw new IllegalArgumentException("Repository is required");
        }
        this.accounts = accounts;
    }

    public synchronized void pay(String customerId, BigDecimal amount) {
        Account account = accounts.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Unknown account: " + customerId));
        account.debit(amount);
        accounts.save(account);
    }
}