package codemind.test;

public class PaymentService {

    static final String CURRENCY = "USD";
    private double taxRate = 0.2;

    // Bug 1: reassigning a final variable
    public void setCurrency(String currency) {
        CURRENCY = currency;
    }

    // Bug 2: division by zero possible
    public double splitBill(double total, int people) {
        return total / people;
    }

    // Bug 3: method says it validates but always returns true
    public boolean validateAmount(double amount) {
        if (amount < 0) {
            System.out.println("Invalid amount");
        }
        return true;
    }

    // Bug 4: tax is applied twice
    public double calculateTotal(double amount) {
        double withTax = amount + (amount * taxRate);
        return withTax + (withTax * taxRate);
    }

    // Bug 5: dead code — condition can never be true
    public String getPaymentStatus(boolean isPaid) {
        if (isPaid == true && isPaid == false) {
            return "impossible";
        }
        return isPaid ? "paid" : "unpaid";
    }

    // Bug 6: null not handled
    public int getLength(String input) {
        return input.length();
    }
}