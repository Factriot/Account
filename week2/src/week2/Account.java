package week2;
import java.util.*;

public abstract class Account implements Valuable{
	private double balance;
	
	public abstract double getWithdrawableAccount();
	public abstract double passTime(int t);
	
	public Account(double b){
		balance = b;
	}

	public void Credit(double m){
		balance += m;
	}
	
	public void debit(double amount) throws SignException{
		if(amount < 0){
			throw new SignException("음수입력!");
		}else if(balance-amount < 0){
			throw new SignException("Debit amount exceeded balance.");
			//System.out.println("Debit amount exceeded account balance");
		}else{
			setBalance(getBalance()-amount);
		}
	}
	
	public double getBalance(){
		return balance;
	}
	
	protected void setBalance(double b){
		balance = b;
	}
	
	public static double sumForAccount(ArrayList<Account> list){
		double sum = 0;
		for(Account account: list){
			sum += account.getBalance();
		}
		return sum;
	}
	
	public static void passTimeForList(ArrayList<Account> list, int month){
		for(Account account: list){
			account.passTime(month);
		}
	}
	
}