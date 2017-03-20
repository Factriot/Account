import java.util.*;

public class AccountTest {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter money for account1: ");
		double money1 = sc.nextDouble();
		System.out.print("Enter money for account2: ");
		double money2 = sc.nextDouble();
		Account account1 = new Account(1);
		Account account2 = new Account(2);
		account1.Credit(money1);
		account2.Credit(money2);
		System.out.print("\nEnter withdrawal amount for account1: ");
		double d1 = sc.nextDouble();
		System.out.printf("subtracting $%4.2f from account1 balance\n", d1);
		if(account1.Debit(d1)){
			System.out.printf("Debit amount exceeded account1 balance\n");
		}
		account1.getBalance();
		account2.getBalance();
		System.out.print("\nEnter withdrawal amount for account2: ");
		double d2 = sc.nextDouble();
		System.out.printf("subtracting $%4.2f from account2 balance\n", d2);
		if(account2.Debit(d2)){
			System.out.printf("Debit amount exceeded account2 balance\n");
		}
		account1.getBalance();
		account2.getBalance();

	}
}
