import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DollarTest {

    @Test
    void testAdd() {
        Dollar dollar1 = new Dollar(10.0);
        Dollar dollar2 = new Dollar(20.0);
        Currency result = dollar1.add(dollar2);
        assertEquals(30.0, result.getAmount(), 0.001);
    }

    @Test
    void testSubtract() {
        Dollar dollar1 = new Dollar(20.0);
        Dollar dollar2 = new Dollar(10.0);
        Currency result = dollar1.subtract(dollar2);
        assertEquals(10.0, result.getAmount(), 0.001);
    }

    @Test
    void testMultiply() {
        Dollar dollar = new Dollar(10.0);
        Currency result = dollar.multiply(2.5);
        assertEquals(25.0, result.getAmount(), 0.001);
    }

    @Test
    void testDivide() {
        Dollar dollar = new Dollar(10.0);
        Currency result = dollar.divide(2.0);
        assertEquals(5.0, result.getAmount(), 0.001);
    }

    @Test
    void testDivideByZero() {
        Dollar dollar = new Dollar(10.0);
        assertThrows(IllegalArgumentException.class, () -> dollar.divide(0.0));
    }

    @Test
    void testToString() {
        Dollar dollar = new Dollar(10.5);
        assertEquals("$10.50", dollar.toString());
    }
}