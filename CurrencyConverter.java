package internship_projects;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);       // Base
        exchangeRates.put("EUR", 0.91);
        exchangeRates.put("INR", 83.10);
        exchangeRates.put("JPY", 155.45);
        exchangeRates.put("GBP", 0.78);

        System.out.println("Available Currencies: USD, EUR, INR, JPY, GBP");

        System.out.print("Enter base currency: ");
        String baseCurrency = sc.next().toUpperCase();

        System.out.print("Enter target currency: ");
        String targetCurrency = sc.next().toUpperCase();

        if (!exchangeRates.containsKey(baseCurrency) || !exchangeRates.containsKey(targetCurrency)) {
            System.out.println("Invalid currency code entered.");
            return;
        }

        System.out.print("Enter amount in " + baseCurrency + ": ");
        double amount = sc.nextDouble();

        double baseToUSD = amount / exchangeRates.get(baseCurrency);
        double convertedAmount = baseToUSD * exchangeRates.get(targetCurrency);

        System.out.printf("Converted amount: %.2f %s\n", convertedAmount, targetCurrency);

        sc.close();
    }
}
