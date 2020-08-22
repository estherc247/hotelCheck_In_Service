package oodp;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	static ArrayList<MenuItems> food = new ArrayList<MenuItems>();

	public static Menu instance;
	public Menu() {}
	public static Menu getInstance() {
		if(instance == null) {
			instance = new Menu();
		}
		return instance;}


	// CREATE NEW MENU ITEM//
	public void createItem(){

		Scanner scan = new Scanner(System.in);
		char end = 'Y';
		String FoodName;
		String FoodDesc;
		String FoodRemarks;
		double FoodPrice;

		while(end == 'Y') {
			System.out.print("\n Name: ");
			FoodName=scan.next();

			System.out.print("\n Description: ");
			FoodDesc=scan.next();

			System.out.print("\n Remarks: ");
			FoodRemarks=scan.next();

			System.out.print("\n Price: ");
			FoodPrice=scan.nextDouble();


			food.add(new MenuItems(FoodName, FoodDesc, FoodRemarks, FoodPrice));
			System.out.println("\nEnter Another Record? (Y/N)");
			String word = scan.next();
			word = word.toUpperCase();
			end= word.charAt(0);

		}

	}


	//REMOVE MENU ITEM//
	public void removeItem() {

		String removeFood;
		int index = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("\nEnter the name of the dish you wish to delete: ");
		removeFood = scan.next();
		for(int i=0;i<food.size();i++)
		{


			if(removeFood.toLowerCase().matches(food.get(i).getFoodName().toLowerCase())) {
				food.remove(food.get(index));
				System.out.println("\n" + food.get(i).getFoodName() + "has been successfully deleted!");
				break;
			}
			else {
				index++;
			}
		}

	}

	//PRINT MENU//
	public void printMenu() {

		System.out.println("-------------------------------");
		System.out.println("|         ~~ MENU ~~          |");
		System.out.println("-------------------------------");

		for(int i=0;i<food.size();i++)
		{

			System.out.println("Name: " + food.get(i).getFoodName());
			System.out.println("Description: " + food.get(i).getFoodDesc());
			System.out.println("Remarks: " + food.get(i).getFoodRemarks());
			System.out.println("Price: $" + food.get(i).getFoodPrice());
			System.out.println("-------------------------------");
		}
	}

	//EDIT MENU//
	public void editMenuItem() {
		System.out.println("\nWhat is the name of the item you want to edit?");
		String foodname;
		int c;
		Scanner scan = new Scanner(System.in);
		foodname = scan.next();
		for(int i=0;i<food.size();i++) {
			if(foodname.toLowerCase().matches(food.get(i).getFoodName())) {
				System.out.println("What do you want to edit?");
				System.out.println("1. Name");
				System.out.println("2. Description");
				System.out.println("3. Remarks");
				System.out.println("4. Price");
				System.out.println("5. Exit");
				c = scan.nextInt();
				while(true) {
					String end;
					if(c==1) {
						String newName;
						System.out.println("What is the new name?");
						newName = scan.next();
						food.get(i).setFoodName(newName);
					}
					else if(c==2) {
						String newDescription;
						System.out.println("What is the new description?");
						newDescription = scan.next();
						food.get(i).setFoodDesc(newDescription);
					}
					else if(c==3) {
						String newRemarks;
						System.out.println("What is the new Remarks?");
						newRemarks = scan.next();
						food.get(i).setFoodRemarks(newRemarks);
					}
					else if(c==4) {
						double newPrice;
						System.out.println("What is the new Price?");
						newPrice = scan.nextDouble();
						food.get(i).setFoodPrice(newPrice);
					}
					else {
						System.out.println("Invalid Option");
					}
					System.out.println("Press Y to change more option, any other key to exit: ");
					end = scan.next();
					if(end.toUpperCase().matches("Y") == false) {
						System.out.println("Item updated");
						break;
					}
				}
			}
		}
	}
}
