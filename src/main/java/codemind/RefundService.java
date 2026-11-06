package codemind;

public class RefundService {
    private final AccountRepository accounts;

    public RefundService(AccountRepository accounts) {
        this.accounts = accounts;
    }

    public void refund(String customerId, double amount) {
        Account account = accounts.findById(customerId).get();
        account.credit(new java.math.BigDecimal(amount));
    }
}