public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("================================== WELCOME TO BANK ==============================");
        Bank bank = new Bank();

        int numberOfCust = 5;
        for (int i = 1; i <= numberOfCust; i++) {
            Customer customerObj = new Customer(bank, i);
            customerObj.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println("Final account balances:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Account " + i + ": " + bank.getBalance(i));
        }
    }
}
