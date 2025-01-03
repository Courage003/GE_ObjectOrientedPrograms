import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Stock class to represent a single stock
class Stock{
    String name;
    int numShares;
    double sharePrice;

    //Constructor to initialize Stock details

    public Stock(String name, int numShares, double sharePrice) {
        this.name = name;
        this.numShares = numShares;
        this.sharePrice = sharePrice;
    }

    //Method to calculate the value of stock
    double calculateStockValue(){
        return numShares*sharePrice;
    }

    // Override the toString method to print stock details in a friendly format
    @Override
    public String toString() {
        return "Stock Name: " + name + ", Number of Shares: " + numShares +
                ", Share Price: $" + sharePrice + ", Total Value: $" + calculateStockValue();
    }
}

//StockPortfolio Class to manage a collection of stocks
class StockPortfolio{
    private final List<Stock> stocks = new ArrayList<>();

    //Method to add a new stock to the portfolio
    void addStock(String name, int numShares, double sharePrice){
        stocks.add(new Stock(name, numShares, sharePrice));
    }

    // Method to calculate the total value of all stocks in the portfolio
    double calculateTotalValue() {
        double totalValue = 0;
        for (Stock stock : stocks) {
            totalValue += stock.calculateStockValue();
        }
        return totalValue;
    }

    // Method to display the stock report, including total portfolio value
    void displayStockReport() {
        System.out.println("\nStock Report:");
        for (Stock stock : stocks) {
            System.out.println(stock);
        }
        System.out.println("Total Portfolio Value: $" + calculateTotalValue());
    }
}

public class StockAccountManagement {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        StockPortfolio portfolio= new StockPortfolio();

        System.out.println("Enter the number of stocks you want to add: ");
        int n=sc.nextInt();
        sc.nextLine();

        //Loop to read stock details from user
        for(int i=0;i<n;i++){
            System.out.println("Enter details for stock " + (i+1));

            System.out.print("Enter Stock Name: ");
            String stockName= sc.nextLine();

            System.out.print("Enter number of shares: ");
            int numShares= sc.nextInt();

            System.out.print("Enter Share Price: ");
            double sharePrice= sc.nextDouble();
            sc.nextLine();

            //Add stock to Portfolio
            portfolio.addStock(stockName,numShares,sharePrice);

        }

        //Display stock report after all stocks entered
        portfolio.displayStockReport();
    }
}
