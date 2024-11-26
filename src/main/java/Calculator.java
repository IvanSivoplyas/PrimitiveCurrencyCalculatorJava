import java.util.Scanner;

public class Calculator{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();
        ExpressionEvaluator evaluator = new ExpressionEvaluator(converter);

        System.out.print("Введите сумму в долларах (например, 100.50): ");
        double dollarValue = scanner.nextDouble();
        Dollar dollar = new Dollar(dollarValue);

        System.out.print("Введите сумму в рублях (например, 5000): ");
        double rubleValue = scanner.nextDouble();
        Ruble ruble = new Ruble(rubleValue);

        System.out.print("Выберите операцию (+, -, *, /): ");
        String operation = scanner.next();

        Currency result = evaluator.evaluate(dollar, ruble, operation);
        System.out.println("Результат в рублях: " + result.format());

        // Конвертация по желанию
        System.out.print("Хотите конвертировать сумму в долларах в рубли? (да/нет): ");
        if (scanner.next().equalsIgnoreCase("да")) {
            Currency convertedDollar = evaluator.convertTo(dollar);
            System.out.println("Сумма в рублях: " + convertedDollar.format());
        }

        // Конвертация по желанию
        System.out.print("Хотите конвертировать сумму в рублях в доллары? (да/нет): ");
        if (scanner.next().equalsIgnoreCase("да")) {
            Currency convertedRuble = evaluator.convertTo(ruble);
            System.out.println("Сумма в долларах: " + convertedRuble.format());
        }

        scanner.close();
    }
}