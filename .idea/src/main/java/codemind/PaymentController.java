package codemind;

public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    public String handlePayment(String customerId, String amountText,
                                String currency, String cardNumber) {
        double amount = Double.parseDouble(amountText);
        boolean ok = service.pay(customerId, amount, currency, cardNumber);

        if (ok) {
            return "Payment of " + amount + " " + currency
                    + " accepted for card " + cardNumber;
        }
        return "Payment failed";
    }
}