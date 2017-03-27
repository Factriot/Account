package week2;

public abstract class Account {
	private double balance;
	
	public abstract double getWithdrawableAccount();
	public abstract double passTime(int t);
	
	public Account(double b){
		balance = b;
	}

	public void Credit(double m){
		balance += m;
	}
	
	public void debit(double m){
		if(balance-m < 0){
			//System.out.println("Debit amount exceeded account balance");
		}else{
			setBalance(getBalance()-m);
		}
	}
	
	public double getBalance(){
		return balance;
	}
	
	protected void setBalance(double b){
		balance = b;
	}

}