import java.util.Scanner;
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Unable to withdraw.");
            return false;
        }
        balance -= amount;
        return true;
    }
}
public class ThirdTask{
    private BankAccount userAccount;

    public ThirdTask(BankAccount account) {
        this.userAccount = account;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                if (userAccount.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful. Remaining balance: $" + userAccount.getBalance());
                }
                break;
            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                userAccount.deposit(depositAmount);
                System.out.println("Deposit successful. Updated balance: $" + userAccount.getBalance());
                break;
            case 3:
                System.out.println("Current Balance: $" + userAccount.getBalance());
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }
public static void main(String[] args) {
   
    BankAccount userAccount = new BankAccount(1000);

   
    ThirdTask atm = new ThirdTask(userAccount);

    Scanner scanner = new Scanner(System.in);

    while (true) {
       
        atm.displayMenu();
        System.out.print("Enter your choice (1-4): ");
        int option = scanner.nextInt();
        atm.processOption(option);
    }
}
}
