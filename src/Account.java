public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    //Debit method to withdraw money from account
    public void debit(double amount){
        if(amount> balance){
            System.out.println("Debit amount exceeded balance.");

        }
        else{
            balance-=amount;
            System.out.println("Debit of $" + amount + " successful.");
        }
    }

    //Method to credit money into account
    public void credit(double amount){
        balance+=amount;
        System.out.println("Credit of $" + amount + " successful.");
    }
}


