import java.util.Scanner;

public class StockAccountTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockAccount account = new StockAccount();

        // Adding some initial stock transactions
        account.buyStock("AAPL", 100);  // Buying 100 shares of Apple
        account.buyStock("GOOG", 50);   // Buying 50 shares of Google
        account.sellStock("AAPL", 30);  // Selling 30 shares of Apple

        // Display the current stock portfolio
        account.displayStockReport();

        // Interacting with the user
        while (true) {
            System.out.println("\nEnter your choice:");
            System.out.println("1. Buy Stock");
            System.out.println("2. Sell Stock");
            System.out.println("3. Display Portfolio");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Stock Symbol to Buy: ");
                    String buySymbol = scanner.nextLine();
                    System.out.print("Enter Number of Shares to Buy: ");
                    int buyShares = scanner.nextInt();
                    account.buyStock(buySymbol, buyShares);
                    break;

                case 2:
                    System.out.print("Enter Stock Symbol to Sell: ");
                    String sellSymbol = scanner.nextLine();
                    System.out.print("Enter Number of Shares to Sell: ");
                    int sellShares = scanner.nextInt();
                    account.sellStock(sellSymbol, sellShares);
                    break;

                case 3:
                    account.displayStockReport();
                    break;

                case 4:
                    System.out.println("Exiting program.");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

