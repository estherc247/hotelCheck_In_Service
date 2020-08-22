package oodp;


public class Human {
	private String name;
	private int age;
	private char gender;
	private String address;
	public Human() {
	
	}
	public Human(String name, int age, char gender, String address) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
	public void setName(String name) {this.name= name; }
	public void setAge(int age) {this.age = age;}
	public void setGender(char gender) {this.gender = gender;}
	public void setAddress(String address) {this.address = address;}
	
	public String getName() {return name;}
	public int getAge() {return age;}
	public char getGender() {return gender;}
	public String getAddress() {return address;}

}
