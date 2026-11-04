package codemind;

import codemind.dto.Account;

import java.util.HashMap;
import java.util.Map;

public class AccountRepository {

    private final Map<String, Account> accounts = new HashMap<>();

    public Account findById(String customerId) {
        return accounts.get(customerId);
    }

    public void save(Account account) {
        accounts.put(account.getCustomerId(), account);
    }
}