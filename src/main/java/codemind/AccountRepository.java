package codemind;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class AccountRepository {
    private final Map<String, Account> accounts = new ConcurrentHashMap<>();

    public Optional<Account> findById(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Account id is required");
        }
        return Optional.ofNullable(accounts.get(id));
    }

    public void save(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account is required");
        }
        accounts.put(account.getId(), account);
    }
}