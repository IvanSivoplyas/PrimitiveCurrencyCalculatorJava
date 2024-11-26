public class Dollar implements Currency {
    private double value;

    public Dollar(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public String format() {
        return String.format("$%.2f",value);
    }
}
