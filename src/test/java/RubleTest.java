import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RubleTest {

    @Test
    void testAdd() {
        Ruble ruble1 = new Ruble(100.0);
        Ruble ruble2 = new Ruble(200.0);
        Currency result = ruble1.add(ruble2);
        assertEquals(300.0, result.getAmount(), 0.001);
    }

    @Test
    void testSubtract() {
        Ruble ruble1 = new Ruble(200.0);
        Ruble ruble2 = new Ruble(100.0);
        Currency result = ruble1.subtract(ruble2);
        assertEquals(100.0, result.getAmount(), 0.001);
    }

    @Test
    void testMultiply() {
        Ruble ruble = new Ruble(100.0);
        Currency result = ruble.multiply(2.5);
        assertEquals(250.0, result.getAmount(), 0.001);
    }

    @Test
    void testDivide() {
        Ruble ruble = new Ruble(100.0);
        Currency result = ruble.divide(2.0);
        assertEquals(50.0, result.getAmount(), 0.001);
    }

    @Test
    void testDivideByZero() {
        Ruble ruble = new Ruble(100.0);
        assertThrows(IllegalArgumentException.class, () -> ruble.divide(0.0));
    }

    @Test
    void testToString() {
        Ruble ruble = new Ruble(100.5);
        assertEquals("100.50р", ruble.toString());
    }
}