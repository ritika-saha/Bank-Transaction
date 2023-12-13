import java.util.HashMap;
public class Bank {
    private HashMap<Integer, Integer> accounts = new HashMap<>();

    public synchronized void deposit(int accountNumber, int amount) {
        int balance = accounts.getOrDefault(accountNumber, 0);
        balance += amount;
        accounts.put(accountNumber, balance);
        System.out.println("Deposited " + amount + " into account " + accountNumber + ". New balance: " + balance);
    }

    public synchronized void withdraw(int accountNumber, int amount) {
        if (accounts.containsKey(accountNumber)) {
            int balance = accounts.get(accountNumber);
            if (balance >= amount) {
                balance -= amount;
                accounts.put(accountNumber, balance);
                System.out.println("Withdrawn " + amount + " from account " + accountNumber + ". New balance: " + balance);
            } else {
                System.out.println("Insufficient funds for withdrawal from account " + accountNumber);
            }
        } else {
            System.out.println("Account " + accountNumber + " does not exist.");
        }
    }

    public synchronized int getBalance(int accountNumber) {
        return accounts.getOrDefault(accountNumber, 0);
    }
}
