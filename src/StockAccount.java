import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockAccount {
    private List<CompanyShares> sharesList;

    public StockAccount() {
        this.sharesList = new ArrayList<>();
    }

    //Method to buy stock shares
    public void buyStock(String stockSymbol, int numberofShares){
        Date transactionDate = new Date();
        CompanyShares existingShares = findShares(stockSymbol);

        if(existingShares!=null){
            //if shares exist, update number of shares
            existingShares.updateShares(numberofShares);
            System.out.println("Bought " + numberofShares + "shares of " + stockSymbol + "on "+ transactionDate);
        }

        else{
            //if no shares exist, create a new record
            CompanyShares newShares= new CompanyShares(stockSymbol, numberofShares, transactionDate);
            sharesList.add(newShares);
            System.out.println("Bought " + numberofShares + " shares of " + stockSymbol+ "on "+ transactionDate);
        }
    }

    // Method to sell stock shares
    public void sellStock(String stockSymbol, int numberOfShares) {
        Date transactionDate = new Date();
        CompanyShares existingShares = findShares(stockSymbol);

        if (existingShares != null && existingShares.getNumberOfShares() >= numberOfShares) {
            // If shares exist and sufficient shares are available for selling
            existingShares.updateShares(-numberOfShares);
            System.out.println("Sold " + numberOfShares + " shares of " + stockSymbol + " on " + transactionDate);
        } else if (existingShares != null) {
            System.out.println("Not enough shares to sell. Available: " + existingShares.getNumberOfShares());
        } else {
            // If no shares found for the given stock symbol
            System.out.println("No shares of " + stockSymbol + " found for sale.");
        }
    }

    // Method to find the shares of a given stock symbol
    private CompanyShares findShares(String stockSymbol) {
        for (CompanyShares companyShares : sharesList) {
            if (companyShares.getStockSymbol().equals(stockSymbol)) {
                return companyShares;
            }
        }
        return null;  // If no shares are found for the given stock symbol
    }

    // Method to display all stock holdings
    public void displayStockReport() {
        System.out.println("\nStock Portfolio Report:");
        for (CompanyShares companyShares : sharesList) {
            System.out.println("Stock Symbol: " + companyShares.getStockSymbol() +
                    ", Number of Shares: " + companyShares.getNumberOfShares() +
                    ", Transaction Date: " + companyShares.getTransactionDate());
        }
    }
}
