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
	public void debit(double money){
		if(getTime() < 12){
			System.out.println("아직 출금할 수 없습니다!");
		} else {
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
