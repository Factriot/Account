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
			String s = "�ܾ��� 0������ �۽��ϴ�.";
			if(b < -credit_limit){
				s = s+"\n�ѵ��� �Ѿ� ��� �Ұ��� �մϴ�.";
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
