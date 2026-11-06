package codemind;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {

    private final List<Transaction> transactions = new ArrayList<>();

    public void save(Transaction t) {
        transactions.add(t);
    }

    public List<Transaction> findByCustomer(String customerId) {
        if (customerId == null || customerId.isBlank()) {
            throw new IllegalArgumentException("Customer id is required");
        }
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.customerId().equals(customerId)) {
                result.add(t);
            }
        }
        return result;
    }

    public List<Transaction> findAll() {
        return transactions;
    }
}