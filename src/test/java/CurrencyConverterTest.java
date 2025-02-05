import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CurrencyConverterTest {

    @Test
    void testToRubles() {
        CurrencyConverter converter = new CurrencyConverter();
        Dollar dollar = new Dollar(10.0);
        Ruble ruble = converter.toRubles(dollar);
        assertEquals(600.0, ruble.getAmount(), 0.001); // При курсе 60
    }

    @Test
    void testToDollars() {
        CurrencyConverter converter = new CurrencyConverter();
        Ruble ruble = new Ruble(600.0);
        Dollar dollar = converter.toDollars(ruble);
        assertEquals(10.0, dollar.getAmount(), 0.001); // При курсе 60
    }
}