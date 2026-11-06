package codemind;

public class StatementController {

    private final StatementService service;
    private final StatementFormatter formatter = new StatementFormatter();

    public StatementController(StatementService service) {
        if (service == null) {
            throw new IllegalArgumentException("Service is required");
        }
        this.service = service;
    }

    public String getStatement(String customerId, String yearText, String monthText) {
        if (customerId == null || customerId.isBlank()) {
            return "Customer id is required";
        }
        try {
            int year = Integer.parseInt(yearText);
            int month = Integer.parseInt(monthText);
            StatementService.Statement s = service.build(customerId, year, month);
            return formatter.header(customerId, s.items().size())
                    + " total " + formatter.readableTotal(s.totalCents());
        } catch (Exception e) {
            return "Error: " + e.toString();
        }
    }
}