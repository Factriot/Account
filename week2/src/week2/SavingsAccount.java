package week2;

public class SavingsAccount extends Account{
	private double interest;
	private int time;
	private boolean check;
	
	public SavingsAccount(double b, double i){
		super(b);
		interest = i;
		time = 0;
		check = false;
	}
	
	@Override
	public double getWithdrawableAccount(){
		return getTime()<12?0.0:getBalance();
	}
	
	@Override
	public double passTime(int t){
		time += t;
		if(getTime() >= 12 && check == false){
			setBalance(getBalance()*Math.pow((1+interest), getTime()));
			check = true;
		}
		return getBalance();
	}
	
	public void passTime(){
		passTime(1);
	}
	
	private int getTime(){
		return time;
	}
	
	@Override
	public void debit(double money) throws SignException{
		if(getTime() < 12){
			throw new SignException("아직 출금할 수 없습니다.");
		} else if(money < 0){
			throw new SignException("음수입력!");
		}else if(getBalance()-money < 0){
			throw new SignException("Debit amount exceeded balance.");
		}else{
			setBalance(getBalance()-money);
		}
	}
	
	public String toString(){
		return String.format("SavingsAccount_Balance: %.2f", getBalance());
	}
	
	public double pTime(){
		setBalance(getBalance()*Math.pow((1+interest), time));
		return getBalance()*Math.pow((1+interest), time);
	}
	
	public double estimateValue(int month){
		time += month;
		setBalance(getBalance()*Math.pow((1+interest), time));
		return getBalance();
	}
	
	public double estimateValue(){
		return getBalance()*(1+interest);
	}
}
