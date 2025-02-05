import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class CurrencyConverter {
    private double exchangeRate;

    public CurrencyConverter() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/calculator.properties")) {
            properties.load(fis);
            exchangeRate = Double.parseDouble(properties.getProperty("exchangeRate"));
        } catch (IOException e) {
            System.out.println("Файл конфигурации не найден! Используется значение по умолчанию.");
            exchangeRate = 97.74; // Значение по умолчанию
        }
    }

    public Ruble toRubles(Dollar dollar) {
        return new Ruble(dollar.getAmount() * exchangeRate);
    }

    public Dollar toDollars(Ruble ruble) {
        return new Dollar(ruble.getAmount() / exchangeRate);
    }
}