package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите курс BYN к EUR: ");
        double usdToEur = scanner.nextDouble();

        System.out.print("Введите курс BYN к USD: ");
        double usdToGbp = scanner.nextDouble();

        System.out.print("Введите курс BYN к PL: ");
        double usdToJpy = scanner.nextDouble();

        System.out.print("Введите курс BYN к RUB: ");
        double usdToCny = scanner.nextDouble();

        CurrencyConverter converter = new CurrencyConverter(usdToEur, usdToGbp, usdToJpy, usdToCny);

        System.out.print("Введите сумму в BYN: ");
        double byN = scanner.nextDouble();

        System.out.print("Введите валюту для конвертации (EUR, USD, PL, RUB): ");
        String currency = scanner.next().toUpperCase();

        double convertedAmount;
        switch (currency) {
            case "EUR":
                convertedAmount = converter.convertBynToEur(byN);
                break;
            case "USD":
                convertedAmount = converter.convertBynToUsd(byN);
                break;
            case "PL":
                convertedAmount = converter.convertBynToPl(byN);
                break;
            case "RUB":
                convertedAmount = converter.convertBynToRub(byN);
                break;
            default:
                System.out.println("Неизвестная валюта.");
                return;
        }

        System.out.printf("%.2f BYN = %.2f %s%n", byN, convertedAmount, currency);
        scanner.close();
        System.exit(0);
    }
}
