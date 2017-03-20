package week2;
import java.util.*;

public class CheckintAccountTest {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Account1 balance: ");
		double b1 = sc.nextDouble();
		System.out.print("Account2 balance: ");
		double b2 = sc.nextDouble();
		CheckingAccount a = new CheckingAccount(100, 100, 0.03, 0.05);
		CheckingAccount b = new CheckingAccount(100, 100, 0.03, 0.05);
	}

}
