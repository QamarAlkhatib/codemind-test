package codemind.test;

public class PaymentService {

    public double calculateTotal(double amount, double tax) {
        return amount + (amount * tax);
    }

    public boolean processPayment(double amount) {
        return !(amount <= 0);
    }
}
