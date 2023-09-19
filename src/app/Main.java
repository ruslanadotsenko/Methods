package app;


import java.util.Locale;
import java.util.Scanner;

public class Main {
    static double amount;
    static double percentage;
    static double discountAmount;
    static double totalAmount;

    public static void main(String[] args) {
        getAmount();
        percentage = getDiscountPercentage(amount);
        discountAmount = getDiscountAmount(amount, percentage);
        totalAmount = getTotalAmount(amount, discountAmount);
        getOutput(amount, discountAmount, totalAmount);
    }

    private static void getAmount() {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);
        System.out.print("Enter your revenue in USD: ");
        amount = sc.nextDouble();
        sc.close();
    }

    private static double getDiscountPercentage(double amount) {
        if (amount < 0) {
            System.out.print("Wrong data.");
        } else if (amount > 0 && amount <= 5000) {
            percentage = 5;
        } else if (amount > 5000 && amount <= 10000) {
            percentage = 10;
        } else {
            percentage = 15;
        }
        return percentage;
    }

    private static double getDiscountAmount(double amount, double percentage) {
        return amount / 100 * percentage;
    }

    private static double getTotalAmount(double amount, double discountAmount) {
        return amount - discountAmount;
    }

    private static void getOutput(double amount, double discountAmount, double totalAmount) {
        System.out.printf("%nTotal amount of purchase: USD %.2f" + "%nThe discount amount: USD %.2f" + "%nTotal amount due: USD %.2f%n", amount, discountAmount, totalAmount);
    }
}