package oodp;



import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Guest extends Human{
	private static final int ArrayList = 0;
	private static int guestNo;
	private String nationality;
	private String country;
	private int contactNo;
	private CreditCard cC;
	private Identity iD;
	public Guest() {
		}
	public Guest(String name, int age, char gender, String address,
			String nationality,String country, int contactNo, CreditCard cC, 
			Identity iD) 
	{	super(name,age,gender,address);
		this.nationality = nationality;
		this.country = country;
		this.contactNo = contactNo;
		this.setcC(cC);
		this.setiD(iD);
		guestNo++;
		
	}
	
	
	public void setContactNo(int contactNo) {this.contactNo= contactNo; }
	public void setCountry(String country) {this.country = country;}
	public void setNationality(String nationality) {this.nationality = nationality;}
			
	public int getContactNo() {return contactNo;}
	public String getCountry() {return country;}
	public String getNationality() {return nationality;}
	public int getGuestNo() {return guestNo;}
	public CreditCard getcC() {
		return cC;
	}
	public void setcC(CreditCard cC) {
		this.cC = cC;
	}
	public Identity getiD() {
		return iD;
	}
	public void setiD(Identity iD) {
		this.iD = iD;
	}
		
	
		

}
