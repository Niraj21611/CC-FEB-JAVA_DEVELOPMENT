import java.util.Scanner;

public class UserAccount {

    Scanner sc = new Scanner(System.in);

    final int customerNumber;
    final int pinNumber;
    double currentAccBalance;
    double savingAccBalance;

    public UserAccount(int customerNumber, int pinNumber){
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
    }


    public void currentWithdraw(double amount){
        currentAccBalance = currentAccBalance - amount;
    }

    public void savingWithdraw(double amount){
        savingAccBalance = savingAccBalance - amount;
    }

    public void currentDeposit(double amount){
        currentAccBalance = currentAccBalance + amount;
    }

    public void savingDeposit(double amount){
        savingAccBalance = savingAccBalance + amount;
    }

    public void currentTransfer(double amount){
        currentAccBalance = currentAccBalance - amount;
        savingAccBalance = savingAccBalance + amount;
    }

    public void savingTransfer(double amount){
        savingAccBalance = savingAccBalance - amount;
        currentAccBalance = currentAccBalance + amount;
    }

    public void currentAccWithdraw(){
        int check = 0;
        double amount;
        while(check != 1){
            System.out.print("\nEnter Amount to be withdrawn: ");
            amount = sc.nextInt();
            if(amount >= 0 && currentAccBalance - amount >= 0){
                currentWithdraw(amount);
                System.out.println("Updated Balance: " + currentAccBalance + "/-");
                check = 1;
            }else{
                System.out.println("\nInvalid Amount!");
            }
        }
    }

    public void savingAccWithdraw(){
        int check = 0;
        double amount;
        while(check != 1){
            System.out.print("\nEnter Amount to be withdrawn: ");
            amount = sc.nextInt();
            if(amount >= 0 && savingAccBalance - amount >= 0){
                savingWithdraw(amount);
                System.out.println("Updated Balance: " + savingAccBalance + "/-");
                check = 1;
            }else{
                System.out.println("\nInvalid Amount!");
            }
        }
    }

    public void currentAccDeposit(){
        int check = 0;
        double amount;
        while(check != 1){
            System.out.print("\nEnter Amount To Deposit: ");
            amount = sc.nextInt();
            if(amount >= 0){
                currentDeposit(amount);
                System.out.println("Updated Balance: " + currentAccBalance + " /-");
                check = 1;
            }else{
                System.out.println("\nInvalid Amount!");
            }
        }
    }

    public void savingAccDeposit(){
        int check = 0;
        double amount;
        while(check != 1){
            System.out.print("\nEnter Amount To Deposit: ");
            amount = sc.nextInt();
            if(amount >= 0){
                savingDeposit(amount);
                System.out.println("Updated Balance: " + savingAccBalance + "/-");
                check = 1;
            }else{
                System.out.println("\nInvalid Amount!");
            }
        }
    }

    public void transfer(int transfer){
        while(true){
            if(transfer == 1){ // 1 ---> CURRENT ACCOUNT BEING SELECTED
                System.out.println("\nEnter your choice: ");
                System.out.println("1. Savings");
                System.out.println("2. Exit");
                System.out.print("\nChoice: ");
                int choice = sc.nextInt();
                switch (choice){
                    case 1:
                        System.out.print("\nEnter the amount to be transferred: ");
                        double amount = sc.nextInt();
                        if(amount >= 0 && currentAccBalance - amount >= 0) {
                            currentTransfer(amount);
                            System.out.println("Saving Account Balance: " + savingAccBalance + "/-");
                        }else{
                            System.out.println("\nInvalid Amount!");
                        }

                    case 2:
                        return;

                    default:
                        System.out.println("\nInvalid Option!");
                }
            }else if(transfer == 2){ // 2 ---> SAVINGS ACCOUNT BEING SELECTED
                System.out.println("\nEnter your choice: ");
                System.out.println("1.Current");
                System.out.println("2.Exit");
                System.out.print("\nChoice: ");
                int choice = sc.nextInt();
                switch (choice){
                    case 1:
                        System.out.print("\nEnter the amount to be transferred: ");
                        double amount = sc.nextInt();
                        if(amount >= 0 && savingAccBalance - amount >= 0) {
                            savingTransfer(amount);
                            System.out.println("Current Account Balance: " + currentAccBalance + "/-");
                        }else{
                            System.out.println("\nInvalid Amount!");
                        }

                    case 2:
                        return;

                    default:
                        System.out.println("\nInvalid Option!");
                }
            }
        }
    }
}
