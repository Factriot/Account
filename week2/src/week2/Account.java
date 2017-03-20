package week2;

public class Account {
	private double balance;
	
	public Account(double b){
		balance = b;
	}

	public void Credit(double m){
		balance += m;
	}
	
	public String Debit(double m){
		if(balance-m < 0){
			return "Debit amount exceeded account balance\n";
		}else{
			balance -= m;
			return null;
		}
	}
	
	public double getBalance(){
		return balance;
	}
	
	protected void setBalance(double b){
		balance = b;
	}

}