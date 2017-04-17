package week2;

public class Car implements Valuable{
	private String name;
	private double price;
	public Car(String name, double price){
		this.name = name;
		this.price = price;
	}
	
	public double estimateValue(int month){
		price *= 0.8;
		return price*Math.pow(0.99 , month);
	}
	
	public double estimateValue(){
		return price*0.8*0.99;
	}
	
	public String toString(){
		return String.format("car name: %s\n", name)+String.format("initial price: %.2f", price);
	}
}
