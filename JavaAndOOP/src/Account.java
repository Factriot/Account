
public class Account {
	private double money;
	private int i;
	
	public Account(int i){
		this.i=i;
	}
	
	public void Credit(double m){
		this.money += m;
	}
	
	public boolean Debit(double m){
		if(this.money-m < 0){
			return true;
		}else{
			this.money -= m;
			return false;
		}
	}
	
	public void getBalance(){
		System.out.printf("account%d balance: $%4.2f\n", i, money);
	}

}
