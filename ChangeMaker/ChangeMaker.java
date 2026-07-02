import java.util.Scanner;

public class ChangeMaker {
    public static void makeChange(double salesPrice, double amountTendered) {
        // Define denominations
        double[] denominations = {100, 50, 20, 10, 5, 1, 0.25, 0.1, 0.05, 0.01};
        String[] names = {"Hundred Dollar Bill", "Fifty Dollar Bill", "Twenty Dollar Bill",
                "Ten Dollar Bill", "Five Dollar Bill", "Dollar Bill", "Quarter", "Dime", "Nickel", "Penny"};

        double changeDue = amountTendered - salesPrice;
        System.out.printf("\nYour change is: $%.2f\n", changeDue);
        System.out.println("You will receive:");

        for (int i = 0; i < denominations.length; i++) {
            if (changeDue >= denominations[i]) {
                int count = (int) (changeDue / denominations[i]);
                System.out.printf("%d - %s%s\n", count, names[i], (count == 1) ? "" : "s");
                changeDue -= count * denominations[i];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to my Change Maker program");
        System.out.print("Enter the sales price (xx.xx): $");
        double salesPrice = scanner.nextDouble();
        System.out.print("Enter the amount tendered (xx.xx): $");
        double amountTendered = scanner.nextDouble();

        makeChange(salesPrice, amountTendered);
    }
}