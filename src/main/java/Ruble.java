public class Ruble extends Currency {
    public Ruble(double amount) {
        super(amount);
    }

    @Override
    public String toString() {
        return String.format("%.2f", amount) + "р";
    }

    @Override
    public Currency add(Currency other) {
        if (other instanceof Ruble) {
            return new Ruble(this.amount + other.getAmount());
        } else {
            throw new IllegalArgumentException("Cannot add different currencies directly.");
        }
    }

    @Override
    public Currency subtract(Currency other) {
        if (other instanceof Ruble) {
            return new Ruble(this.amount - other.getAmount());
        } else {
            throw new IllegalArgumentException("Cannot subtract different currencies directly.");
        }
    }

    @Override
    public Currency multiply(double factor) {
        return new Ruble(this.amount * factor);
    }

    @Override
    public Currency divide(double divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return new Ruble(this.amount / divisor);
    }
}