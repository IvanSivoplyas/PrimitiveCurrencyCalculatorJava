import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testEvaluateExpression() {
        CurrencyConverter converter = new CurrencyConverter();
        Calculator calculator = new Calculator();

        // Тест сложения рублей
        Currency result1 = calculator.evaluateExpression("100р + 200р", converter);
        assertEquals(300.0, result1.getAmount(), 0.001);

        // Тест конвертации долларов в рубли
        Currency result2 = calculator.evaluateExpression("toRubles($10)", converter);
        assertEquals(600.0, result2.getAmount(), 0.001); // При курсе 60

        // Тест сложения с конвертацией
        Currency result3 = calculator.evaluateExpression("toDollars(600р + toRubles($10))", converter);
        assertEquals(20.0, result3.getAmount(), 0.001); // При курсе 60
    }

    @Test
    void testInvalidExpression() {
        CurrencyConverter converter = new CurrencyConverter();
        Calculator calculator = new Calculator();

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.evaluateExpression("100р + $10", converter);
        });
    }
}