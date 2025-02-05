import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите выражение (например, toDollars(737р + toRubles($85,4))):");
        String input = scanner.nextLine();

        try {
            Currency result = evaluateExpression(input, converter);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static Currency evaluateExpression(String expression, CurrencyConverter converter) {
        // Упрощенный парсинг выражения
        if (expression.startsWith("toDollars(")) {
            String rublesExpr = expression.substring(10, expression.length() - 1);
            Ruble rubles = (Ruble) evaluateExpression(rublesExpr, converter);
            return converter.toDollars(rubles);
        } else if (expression.startsWith("toRubles(")) {
            String dollarsExpr = expression.substring(9, expression.length() - 1);
            Dollar dollars = (Dollar) evaluateExpression(dollarsExpr, converter);
            return converter.toRubles(dollars);
        } else if (expression.contains("+")) {
            String[] parts = expression.split("\\+");
            Currency left = evaluateExpression(parts[0].trim(), converter);
            Currency right = evaluateExpression(parts[1].trim(), converter);
            return left.add(right);
        } else if (expression.contains("-")) {
            String[] parts = expression.split("-");
            Currency left = evaluateExpression(parts[0].trim(), converter);
            Currency right = evaluateExpression(parts[1].trim(), converter);
            return left.subtract(right);
        } else if (expression.contains("*")) {
            String[] parts = expression.split("\\*");
            Currency currency = evaluateExpression(parts[0].trim(), converter);
            double factor = Double.parseDouble(parts[1].trim());
            return currency.multiply(factor);
        } else if (expression.contains("/")) {
            String[] parts = expression.split("/");
            Currency currency = evaluateExpression(parts[0].trim(), converter);
            double divisor = Double.parseDouble(parts[1].trim());
            return currency.divide(divisor);
        } else if (expression.endsWith("р")) {
            double amount = Double.parseDouble(expression.substring(0, expression.length() - 1).replace(',', '.'));
            return new Ruble(amount);
        } else if (expression.startsWith("$")) {
            double amount = Double.parseDouble(expression.substring(1).replace(',', '.'));
            return new Dollar(amount);
        } else {
            throw new IllegalArgumentException("Неверный формат выражения: " + expression);
        }
    }
}