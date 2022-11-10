package application;

import java.util.Locale;
import java.util.Scanner;
import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter account data ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		Double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		Double withdrawLimit = sc.nextDouble();
		Account acc = new Account(number, holder, balance, withdrawLimit);
		System.out.println();
		System.out.println(acc);
		
		System.out.print("Enter amount to withdraw: ");
		try {
			acc.withdraw(sc.nextDouble());
			System.out.printf("New balance: $%.2f", acc.getBalance());
		}
		catch (DomainException e){
			System.out.println(e.getMessage());
		}
		sc.close();
	}

}
