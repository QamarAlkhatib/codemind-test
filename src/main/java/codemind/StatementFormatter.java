package codemind;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StatementFormatter {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public String header(String customerName, int count) {
        return String.format("Statement for " + customerName + ": %d items", count);
    }

    public String stamp() {
        return DATE_FORMAT.format(new Date());
    }

    public void saveToFile(String path, String content) throws IOException {
        FileWriter writer = new FileWriter(path);
        writer.write(content);
        writer.flush();
    }

    public String readableTotal(int totalCents) {
        return (totalCents / 100) + "." + String.format("%02d", Math.abs(totalCents % 100));
    }
}