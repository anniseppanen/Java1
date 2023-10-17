import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class BankProgram {
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Account> accountList = new ArrayList<Account>();
	public static void main(String[] args) {
		int choice = -1;
		while (choice != 0) {
			switch (choice) {
			case 1:
				listAccounts();
				break;
			case 2:
				addAccount();
				break;
			case 3:
				depositMoney();
				break;
			case 4:
				withdrawMoney();
				break;
			case 5:
				deleteAccount();
				break;
			}
			displayMenu();
			choice = Integer.parseInt(input.nextLine());
		}
		System.out.println("\nThe program ends now. Bye!");
		input.close();
	}
	private static void displayMenu() {
		String line = "-----------------------------------------------------"
				+ "---------------------------------------------------------------";
		System.out.println(line);
		System.out.print(" 0 = Quit | 1 = List accounts | 2 = Add an account | "
				+ "3 = Deposit money | 4 = Withdraw money | 5 = Delete an account \n");
		System.out.println(line);
		System.out.print("Enter your choice: ");
	}
	private static void listAccounts() {
		System.out.println("\n*** Account list ***\n");
		DecimalFormat twoDecimals = new DecimalFormat("0.00");
		for (Account account : accountList) {
			System.out.print("Number: " + account.getAccountNumber() + " | Balance: "
					+ twoDecimals.format(account.getBalance()) + " euros\n");
		}
	}
	private static void addAccount() {
		System.out.print("\n*** Add an account ***\n");
		Scanner input = new Scanner(System.in);
		System.out.print("Enter account number: ");
		String accountNumber = input.nextLine();
		Account newAccount = new Account(accountNumber);
		int flag = 0;
		for (Account account : accountList) {
			if (account.getAccountNumber().equals(newAccount.getAccountNumber())) {
				flag = 1;
			}
		}
		if (flag == 1) {
			System.out.println("\nAccount not created. Account " + newAccount.getAccountNumber() + " exists already!");
		} else {
			accountList.add(newAccount);
			System.out.println("\nAccount created successfully!");
		}
	}
	private static Account findAccount(String accountNumber) {
		for (Account account : accountList) {
			if (account.getAccountNumber().equals(accountNumber)) {
				return account;
			}
		}
		return null;
	}
	private static void depositMoney() {
		System.out.print("\n*** Deposit money to an account ***\n");
		Scanner input = new Scanner(System.in);
		System.out.print("Enter account number: ");
		String accountNumber = input.nextLine();
		System.out.print("Enter the amount to be deposited: ");
		double amount = Double.parseDouble(input.nextLine().replace(',', '.'));
		if(amount >= 0) {
			Account account = findAccount(accountNumber);
			account.deposit(amount);
			System.out.println("\nDeposit completed successfully!");
		} else {
			System.out.println("Cannot deposit a negative amount!");
		}

	}
	private static void withdrawMoney() {
		System.out.print("\n*** Withdraw money from an account ***\n");
		Scanner input = new Scanner(System.in);
		System.out.print("Enter account number: ");
		String accountNumber = input.nextLine();
		Account account = findAccount(accountNumber);
		if(account == null) {
			System.out.println("\nAccount "+accountNumber+" does not exist!");
		} else {
			System.out.print("Enter the amount to be withdrawn: ");
			double amount = Double.parseDouble(input.nextLine().replace(',', '.'));
			if(account.withdraw(amount) == true && amount >= 0) {
				System.out.println("\nWithdrawal completed successfully!");
			} else if(amount < 0) {
				System.out.println("\nCannot withdraw a negative amount!");
			} else {
				System.out.println("\nWithdrawal not completed. Available balance is too low.");
			}
		}
	}
	private static void deleteAccount() {
		System.out.print("\n*** Delete an account ***\n");
		Scanner input = new Scanner(System.in);
		System.out.print("Enter account number: ");
		String accountNumber = input.nextLine();
		int i = -1;
		int flag = 0;
		for (Account accountObject : accountList) {
			i++;
			if (accountObject.getAccountNumber().equals(accountNumber)) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			accountList.remove(i);
		}
		System.out.println("\nAccount deleted successcfully!");
	}
}
