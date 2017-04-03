package week2;

public class Human implements Valuable{
	private String name;
	private int age;
	
	public Human(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String toString(){
		return "Human name: "+name+"\nregistered age: "+age;
	}
	
	public double estimateValue(int month){
		return Double.POSITIVE_INFINITY;
	}
}
