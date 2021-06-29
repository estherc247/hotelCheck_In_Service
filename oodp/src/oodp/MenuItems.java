package oodp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MenuItems {
	
	private String FoodName;
	private String FoodDesc;
	private String FoodRemarks;
	private double FoodPrice;
	
	/*List of default menu options for hotel guests*/
	public MenuItems() {
		/* 1. Chicken Tenders */
		this.FoodName = "Chicken Tenders";
		this.FoodDesc = "8 crispy and tender boneless chicken marinated with special seasoning.";
		this.FoodRemarks = "A perfect starter for a family of 4!";
		this.FoodPrice = 10.50;
		
		/* 2. Steak Set*/
		this.FoodName = "Steak Set (Chicken/Beef)";
		this.FoodDesc = "Juicy and rich in flavour! Meat that melts in your mouth by the first bite! Comes with freshly baked fries and baked beans.";
		this.FoodRemarks = "Fries can be replaced with mash potato."; /* take note */
		this.FoodPrice = 13.60;
		
		
		/* 3. Mango Pudding */
		this.FoodName = "Mango Pudding";
		this.FoodDesc = "Fresh mangoes used to produce a rich and a creamed textured pudding. Garnished with a variety of fresh fruits such as strawberries and kiwi.";
		this.FoodRemarks = "Extremely refreshing";
		this.FoodPrice = 4.30;
		
		/* 5. Blue Lagoon */
		this.FoodName = "Blue Lagoon";
		this.FoodDesc = "Tall, refreshing and bluer than the bluest Caribbean sky, flavoured with lime and mint! A drink perfect for the summer!";
		this.FoodRemarks = "Non Alcoholic";
		this.FoodPrice = 5.00;
		
	}


	public MenuItems(String foodName, String foodDesc, String foodRemarks, double foodPrice) {
		FoodName = foodName;
		FoodDesc = foodDesc;
		FoodRemarks = foodRemarks;
		FoodPrice = foodPrice;
	}
	public void setFoodName(String foodName) {this.FoodName= foodName; }
	public void setFoodDesc(String foodDesc) {this.FoodDesc= foodDesc; }
	public void setFoodRemarks(String foodRemarks) {this.FoodRemarks= foodRemarks; }
	public void setFoodPrice(double foodPrice) {this.FoodPrice= foodPrice; }
	
	public String getFoodName() {return FoodName;}
	public String getFoodDesc() {return FoodDesc;}
	public String getFoodRemarks() {return FoodRemarks;}
	public double getFoodPrice() {return FoodPrice;}
	
}