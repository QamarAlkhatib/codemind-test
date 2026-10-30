package codemind;

public class BillService {

    public double splitBill(double total, int people) {
        if (people < 1) {
            throw new IllegalArgumentException("At least one person is required");
        }
        return (total / people) * 1.1;
    }
}
