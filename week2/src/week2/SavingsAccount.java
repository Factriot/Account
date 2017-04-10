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
	
	private int getTime(){
		return time;
	}
	
	@Override
	public void debit(double money) throws Exception{
		if(getTime() < 12){
			throw new Exception("아직 출금할 수 없습니다.");
		} else if(money < 0){
			throw new SignException("음수입력!");
		}else if(getBalance()-money < 0){
			throw new Exception("Debit amount exceeded balance.");
		}else{
			setBalance(getBalance()-money);
		}
	}
	
	public String toString(){
		return String.format("SavingsAccount_Balance: %.2f", getBalance());
	}
	
	public double pTime(int t){
		setBalance(getBalance()*Math.pow((1+interest), t));
		return getBalance()*Math.pow((1+interest), t);
	}
	
	public double estimateValue(int month){
		pTime(month);
		return getBalance();
	}
}
