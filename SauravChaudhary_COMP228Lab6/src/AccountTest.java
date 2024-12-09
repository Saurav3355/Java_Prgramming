import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(5000);


        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(account, true, 150));
        transactions.add(new Transaction(account, false, 2000));
        transactions.add(new Transaction(account, true, 2050));
        transactions.add(new Transaction(account, false, 3300));
        transactions.add(new Transaction(account, false, 2400));

        //execute transactions
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Execute each transaction
        for (Transaction transaction : transactions) {
            executorService.execute(transaction);
        }


        executorService.shutdown();


        while (!executorService.isTerminated()) {

        }


        System.out.println("Final Account Balance: $" + account.getBalance());
    }
}
