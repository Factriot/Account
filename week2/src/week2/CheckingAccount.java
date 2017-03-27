package week2;
import java.math.*;

public class CheckingAccount extends Account{
	private double credit_limit;
	private double interest;
	private double loan_interest;
	
	public CheckingAccount(double b, double c, double i, double l){
		super(b);
		credit_limit = c;
		interest = i;
		loan_interest = l;
	}
	
	@Override
	public double getWithdrawableAccount(){
		double n = getBalance()+credit_limit;
		return n<=0?0.0:n;
	}
	
	@Override
	public double passTime(int t){
		if(getBalance() > 0){
			setBalance(getBalance()*Math.pow((1+interest), t));
			return getBalance()*Math.pow((1+interest), t);
		}
		setBalance(getBalance()*Math.pow((1+loan_interest), t));
		return getBalance();
	}
	
	public boolean isBankrupted(){
		return getBalance() < -credit_limit;
	}
	
	@Override
	public void debit(double m){
		setBalance(getBalance()-m);
	}
	
	public void nextMonth(){
		double b = (double) getBalance();
		if(b > 0){
			setBalance(b*(1+interest));
		}
		else if(b < 0){
			setBalance(b*(1+loan_interest));
		}
	}

}
