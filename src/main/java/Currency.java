public abstract class Currency {
    protected double amount;

    public Currency(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public abstract String toString();

    public abstract Currency add(Currency other);

    public abstract Currency subtract(Currency other);

    public abstract Currency multiply(double factor);

    public abstract Currency divide(double divisor);
}