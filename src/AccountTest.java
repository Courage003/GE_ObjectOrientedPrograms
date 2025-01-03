public class AccountTest {
    public static void main(String[] args){
        // Create an account with an initial balance of $500
        Account account = new Account(500);

        // Display the initial balance
        System.out.println("Initial Balance: $" + account.getBalance());

        // Test debit with an amount that is less than the balance
        account.debit(200); // Expected: Successful debit
        System.out.println("Balance after debit: $" + account.getBalance());

        // Test debit with an amount that exceeds the balance
        account.debit(600); // Expected: Debit amount exceeds account balance
        System.out.println("Balance after failed debit: $" + account.getBalance());

        // Test credit method
        account.credit(300); // Expected: Successful credit
        System.out.println("Balance after credit: $" + account.getBalance());

        // Test debit again with a valid amount
        account.debit(400); // Expected: Successful debit
        System.out.println("Balance after debit: $" + account.getBalance());
    }
}
