import java.util.Date;

public class CompanyShares {
    String stockSymbol;
    int numberOfShares;
    Date transactionDate;

    public CompanyShares(String stockSymbol, int numberOfShares, Date transactionDate) {
        this.stockSymbol = stockSymbol;
        this.numberOfShares = numberOfShares;
        this.transactionDate = transactionDate;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    //Update the number of shares for a particular stock
    public void updateShares(int shares){
        this.numberOfShares+=shares;
    }
}
