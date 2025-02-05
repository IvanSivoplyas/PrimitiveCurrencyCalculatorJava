public class Dollar extends Currency {
    public Dollar(double amount) {
        super(amount);
    }

    @Override
    public String toString() {
        return "$" + String.format("%.2f", amount);
    }

    @Override
    public Currency add(Currency other) {
        if (other instanceof Dollar) {
            return new Dollar(this.amount + other.getAmount());
        } else {
            throw new IllegalArgumentException("Cannot add different currencies directly.");
        }
    }

    @Override
    public Currency subtract(Currency other) {
        if (other instanceof Dollar) {
            return new Dollar(this.amount - other.getAmount());
        } else {
            throw new IllegalArgumentException("Cannot subtract different currencies directly.");
        }
    }

    @Override
    public Currency multiply(double factor) {
        return new Dollar(this.amount * factor);
    }

    @Override
    public Currency divide(double divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return new Dollar(this.amount / divisor);
    }
}