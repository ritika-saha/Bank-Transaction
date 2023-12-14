public class Customer extends Thread {
    private int customerId;
    private Bank bank;

    public Customer(Bank bank,int cId) {
        this.customerId = cId;
        this.bank = bank;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            int randomAmount = (int) (Math.random() * 100) + 1; // Random amount between 1 and 100
            if (i % 2 == 0) {
                bank.deposit(customerId, randomAmount);
            } else {
                bank.withdraw(customerId, randomAmount);
            }

            try {
                Thread.sleep(2000); // Simulating some processing time between transactions
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
