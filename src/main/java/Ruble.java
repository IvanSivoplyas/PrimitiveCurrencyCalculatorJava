public class Ruble implements Currency {

    private double value;

    public Ruble(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public String format() {
        return String.format("%.2f₽",value);
    }
}
