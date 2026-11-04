package codemind;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
public class Account {
    private final String customerId;
    private final String currency;
    private double balance;

}