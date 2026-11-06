package codemind;

import java.time.LocalDate;

public record Transaction(String customerId, String type, int cents, LocalDate date) {}