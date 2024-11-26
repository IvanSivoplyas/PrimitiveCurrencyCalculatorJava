public class ExpressionEvaluator {
    private CurrencyConverter converter;

    public ExpressionEvaluator(CurrencyConverter converter) {
        this.converter = converter;
    }

    public Currency evaluate(Currency currency1, Currency currency2, String operation) {
        double totalValue;

        switch (operation) {
            case "+" -> totalValue = currency1.getValue() + currency2.getValue();
            case "-" -> totalValue = currency1.getValue() - currency2.getValue();
            case "*" -> totalValue = currency1.getValue() * currency2.getValue();
            case "/" -> {
                if (currency2.getValue() == 0) {
                    throw new IllegalArgumentException("Деление на ноль невозможно.");
                }
                totalValue = currency1.getValue() / currency2.getValue();
            }
            default -> throw new IllegalArgumentException("Неподдерживаемая операция: " + operation);
        }

        return new Ruble(totalValue);
    }

    public Currency convertTo(Dollar dollar) {
        return converter.convertToRubles(dollar);
    }

    public Currency convertTo(Ruble ruble) {
        return converter.convertToDollars(ruble);
    }

}
