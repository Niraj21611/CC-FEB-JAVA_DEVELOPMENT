import java.util.HashMap;
import java.util.Scanner;

public class UserMenu {
    Scanner userInput = new Scanner(System.in);
    HashMap<Integer, Integer> map = new HashMap<>();

    public void login(){
        int customerNumber;
        int pinNumber;

        while(true){
            System.out.print("\nEnter Your Customer Number: ");
            customerNumber = userInput.nextInt();
            if(map.containsKey(customerNumber)){
                System.out.print("Enter your pin: ");
                pinNumber = userInput.nextInt();
                if(map.get(customerNumber) == pinNumber){
                    UserAccount acc = new UserAccount(customerNumber, pinNumber);
                    accOption(acc);
                }else{
                    System.out.println("Wrong pin!");
                }
            }else{
                System.out.println("\nRecords Not Matched!");
                System.out.println("\nCreate New Account: ");
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.print("\nChoice: ");
                int choice = userInput.nextInt();
                switch (choice) {
                    case 1 -> create();
                    case 2 -> mainMenu();
                    default -> System.out.println("\nInvalid Option!");
                }
            }

        }
    }

    public void accOption(UserAccount acc){
        while(true){
            System.out.println("\nSelect The Account :");
            System.out.println("1. Current");
            System.out.println("2. Saving");
            System.out.println("3. Exit");
            System.out.print("\nChoice: ");
            int choice = userInput.nextInt();
            switch (choice) {
                case 1 -> currOptions(acc);
                case 2 -> savingOptions(acc);
                case 3 -> mainMenu();
                default -> System.out.println("\nInvalid Option");
            }
        }
    }

    public void currOptions(UserAccount acc){
        int check = 0;
        while (check != 1){
            System.out.println("\nWelcome to your Current Account!");
            System.out.println("1. View Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("\nChoice: ");
            int choice = userInput.nextInt();
            switch (choice) {
                case 1 -> System.out.println("Balance :- " + acc.currentAccBalance);
                case 2 -> acc.currentAccWithdraw();
                case 3 -> acc.currentAccDeposit();
                case 4 -> acc.transfer(1);
                case 5 -> check = 1;
                default -> System.out.println("\nInvalid Option!");
            }
        }
    }

    public void savingOptions(UserAccount acc){
        int check = 0;
        while (check != 1){
            System.out.println("\nWelcome to your Savings Account!");
            System.out.println("1. View Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("\nChoice: ");
            int choice = userInput.nextInt();
            switch (choice) {
                case 1 -> System.out.println("\nBalance :- " + acc.savingAccBalance);
                case 2 -> acc.savingAccWithdraw();
                case 3 -> acc.savingAccDeposit();
                case 4 -> acc.transfer(2);
                case 5 -> check = 1;
                default -> System.out.println("\nInvalid Option!");
            }
        }
    }

    public void create(){
        int check = 0;
        int customerNumber;
        int pinNumber;
        while(check != 1) {
            System.out.print("\nEnter Your Customer Number: ");
            customerNumber = userInput.nextInt();
            System.out.print("Enter your pin: ");
            pinNumber = userInput.nextInt();
            if(!map.containsKey(customerNumber)){
                map.put(customerNumber, pinNumber);
                check = 1;
            }
        }
        System.out.println("\nYour Account Has Been Created!");
        System.out.println("Login:-");
        login();
    }

    public void delete(){
        int customerNumber;
        System.out.print("\nEnter Customer Number: ");
        customerNumber = userInput.nextInt();
        if(map.containsKey(customerNumber)){
            map.remove(customerNumber);
            System.out.println("\nAccount Deleted Successfully!");
            mainMenu();
        }else {
            System.out.println("\nNo Records Matched!");
            mainMenu();
        }
    }

    public void mainMenu(){
        int check = 0;
        while(check != 1){
            System.out.println("\n1. Login Account");
            System.out.println("2. Create Account");
            System.out.println("3. Delete");
            System.out.println("4. Exit");
            System.out.print("\nChoice: ");
            int choice = userInput.nextInt();
            switch (choice) {
                case 1 -> {
                    login();
                    check = 1;
                }
                case 2 -> {
                    create();
                    check = 1;
                }

                case 3 -> {
                    delete();
                    check = 1;
                }

                case 4 -> {
                    System.out.println("\nThank you for visiting!");
                    System.exit(0);
                }

                default -> System.out.println("\nInvalid Option!");
            }
        }
    }
}


