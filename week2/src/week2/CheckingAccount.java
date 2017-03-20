package week2;

public class CheckingAccount extends Account{
	private double credit_limit;
	private double interest;
	private double loan_interest;
	
	CheckingAccount(double b, double c, double i, double l){
		super(b);
		credit_limit = c;
		interest = i;
		loan_interest = l;
	}
	
	@Override
	public String Debit(double m){
		double next = getBalance()-m;
		setBalance(next);
		double b = getBalance();
		if(b < 0){
			String s = "잔액이 0원보다 작습니다.";
			if(b < -credit_limit){
				s = s+"\n한도를 넘어 출금 불가능 합니다.";
				setBalance(getBalance()+m);
			}
			return s;
		}
		return null;
	}
	public void nextMonth(){
		double b = (double) getBalance();
		if(b > 0){
			setBalance(b*(1+interest));
		}
		else if(b < 0){
			setBalance(b*(1-loan_interest));
		}
	}

}
