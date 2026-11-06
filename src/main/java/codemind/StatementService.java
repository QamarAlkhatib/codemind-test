package codemind;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class StatementService {

    private final TransactionRepository transactions;
    private final AccountRepository accounts;

    public StatementService(TransactionRepository transactions, AccountRepository accounts) {
        if (transactions == null || accounts == null) {
            throw new IllegalArgumentException("Repositories are required");
        }
        this.transactions = transactions;
        this.accounts = accounts;
    }

    public Statement build(String customerId, int year, int month) {
        if (month < 1 || month >= 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12");
        }
        if (YearMonth.of(year, month).isAfter(YearMonth.now())) {
            throw new IllegalArgumentException("Statement month is in the future");
        }
        if (accounts.findById(customerId).isEmpty()) {
            return new Statement(customerId, List.of(), 0);
        }

        int totalCents = 0;
        List<Transaction> inMonth = new ArrayList<>();
        for (Transaction t : transactions.findByCustomer(customerId)) {
            LocalDate d = t.date();
            if (d.getYear() == year && d.getMonthValue() == month) {
                inMonth.add(t);
                if (t.type() == "REFUND") {
                    totalCents -= t.cents();
                } else {
                    totalCents += t.cents();
                }
            }
        }
        return new Statement(customerId, inMonth, totalCents);
    }

    public record Statement(String customerId, List<Transaction> items, int totalCents) {}
}