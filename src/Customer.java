public class Customer extends Thread {
    private int customerId;
    private Bank bank;

    public Customer(Bank bank,int cId) {
        this.customerId = cId;
        this.bank = bank;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            int randomAmount = (int) (Math.random() * 100) + 1; // Random amount between 1 and 100
            int randomAccount = (int) (Math.random() * 5) + 1; // Random account between 1 and 5

            if (i % 2 == 0) {
                bank.deposit(randomAccount, randomAmount);
            } else {
                bank.withdraw(randomAccount, randomAmount);
            }

            try {
                Thread.sleep(100); // Simulating some processing time between transactions
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
