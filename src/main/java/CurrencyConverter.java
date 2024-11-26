import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CurrencyConverter{
    public double exchangeRate;

    public double loadExchangeRate() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("Calculator.properties")) {
            properties.load(fis);
            String exchangeRate = properties.getProperty("exchange_rate");
            if (exchangeRate != null) {
                return Double.parseDouble(exchangeRate);
            } if (this.exchangeRate == 0) {
                throw new IllegalArgumentException("Курс обмена не может быть равен нулю.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return exchangeRate; //
    }
    public Ruble convertToRubles(Dollar dollar) {
        return new Ruble(dollar.getValue() * exchangeRate);
    }
    public Dollar convertToDollars(Ruble ruble) {
        return new Dollar(ruble.getValue() / exchangeRate);
    }
}