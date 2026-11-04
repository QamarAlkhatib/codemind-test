package codemind;

public class CurrencyConverter {

    public double toUsd(double amount, String currency) {
        switch (currency) {
            case "EUR":
                return amount * 1.08;
            case "GBP":
                return amount * 1.27;
            default:
                return amount;
        }
    }
}