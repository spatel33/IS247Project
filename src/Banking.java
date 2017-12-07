//IS247 Project
import java.util.Date;
import java.util.Scanner;


//This program is a banking app and will allow you to create an account, deposit, withdraw or see your account details


class Bank {
    //maximum and minimum number of accounts that an instance of Bank can hold
    final int max_limit = 20;
    final int min_limit = 1;
    //sets minimum balance of account
    final double min_bal = 100;
    //can hold total of 20 accounts
    //each has one of the following, i.e acct #3 is name[2], AccountNumber[2], etc.
    private String name[] = new String[20];
    private int AccountNumber[] = new int[20];
    private String AccountType[] = new String[20];
    private double BalanceAmount[] = new double[20];
    static int totRec = 0;

    //constructor
    //fills all arrays with empty data
    Bank() {
        for (int i = 0; i < max_limit; i++) {
            name[i] = "";
            AccountNumber[i] = 0;
            AccountType[i] = "";
            BalanceAmount[i] = 0.0;
        }
    }

    //TO  ADD NEW ACCOUNT
    public void newEntry() {
        boolean permit=true;

        if (totRec > max_limit) {
            System.out.println("\n\n\nSorry we cannot admit you in our bank...\n\n\n");
            permit = false;
        }

        if (permit)   //Allows to create new entry
        {
            totRec++;         // Incrementing Total Record
            System.out.println("\n\n\n----RECORDING NEW ENTRY----");
            try {
                AccountNumber[totRec] = totRec;    //Created  AutoNumber  to AccountNumber so no invalid id occurs
                System.out.println("Account Number :  " + AccountNumber[totRec]);

                Scanner input=new Scanner(System.in);
                System.out.print("Enter Name :  ");
                name[totRec] = input.nextLine();

                System.out.print("Enter Account Type : ");
                AccountType[totRec] = input.nextLine();

                do {
                    System.out.print("Enter Initial  Amount to be deposited : ");
                    BalanceAmount[totRec] = input.nextDouble();
                } while (BalanceAmount[totRec] < min_bal);      //Validation that minimun amount must be 100

                System.out.println("\n\n\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    //TO DISPLAY DETAILS OF YOUR ACCOUNT
    public void display() {
        int acno = 0;
        boolean valid = true;

        System.out.println("\n\n----DISPLAYING DETAILS OF CUSTOMER----\n");
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter Account number : ");
            acno = input.nextInt();
            if (acno < min_limit || acno > totRec)   //To check whether AccountNumber is valid or Not
            {
                System.out.println("\n\n\nInvalid Account Number \n\n");
                valid = false;
            }

            if (valid) {
                System.out.println("\n\nAccount Number : " + AccountNumber[acno]);
                System.out.println("Name : " + name[acno]);
                System.out.println("Account Type : " + AccountType[acno]);
                System.out.println("Balance Amount : " + BalanceAmount[acno] + "\n\n\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //TO DEPOSIT AN AMOUNT INTO YOUR ACCOUNT
    public void deposit() {
        double amt;
        int acno;
        boolean valid = true;
        System.out.println("\n\n\n----DEPOSIT AMOUNT----");

        try {
            //Reading deposit value
            Scanner input = new Scanner(System.in);

            System.out.print("Enter Account No : ");
            acno = input.nextInt();
            if (acno < min_limit || acno > totRec)   //To check whether AccountNumber is valid or Not
            {
                System.out.println("\n\n\nInvalid Account Number \n\n");
                valid = false;
            }

            if (valid) {
                System.out.print("Enter Amount you want to Deposit  : ");
                amt = input.nextDouble();

                BalanceAmount[acno] = BalanceAmount[acno] + amt;

                //Displaying Depsit Details
                System.out.println("\nAfter Updating...");
                System.out.println("Account Number :  " + acno);
                System.out.println("Balance Amount :  " + BalanceAmount[acno] + "\n\n\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //TO WITHDRAW A CERTAIN AMOUNT FROM YOUR ACCOUNT
    public void withdraw() {
        double amt, checkamt;
        int acno;
        boolean valid = true;
        System.out.println("\n\n\n----WITHDRAW AMOUNT----");

        try {
            //Reading deposit value
            Scanner input = new Scanner(System.in);
            System.out.print("Enter Account No : ");
            acno = input.nextInt();

            if (acno < min_limit || acno > totRec)   //To check whether AccountNumber is valid or Not
            {
                System.out.println("\n\n\nInvalid Account Number \n\n");
                valid = false;
            }

            if (valid) {
                System.out.println("Balance is : " + BalanceAmount[acno]);
                System.out.print("Enter Amount you want to withdraw  : ");

                amt = input.nextDouble();

                checkamt = BalanceAmount[acno] - amt;

                if (checkamt >= min_bal) {
                    BalanceAmount[acno] = checkamt;
                    //Displaying Depsit Details
                    System.out.println("\nAfter Updating...");
                    System.out.println("Account Number :  " + acno);
                    System.out.println("Balance Amount :  " + BalanceAmount[acno] + "\n\n\n");
                } else {
                    System.out.println("\n\nYou must maintain a minimum balance of $100\n\n\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


