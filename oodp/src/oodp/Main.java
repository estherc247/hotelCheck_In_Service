package oodp;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Main {
	static GuestMgr guestMgr = new GuestMgr();
	static RoomMgr roomMgr = new RoomMgr();
	static RoomServiceMgr rSMgr = new RoomServiceMgr();
	static Menu menu = new Menu();
	static PaymentMgr paymentMgr = new PaymentMgr();
	static ReservationMgr reserveMgr = new ReservationMgr();
	
	public static void main(String[] args) {

		System.out.println("Welcome to the Hotel System");
		System.out.println("----------------------------");
		boolean A = true;
		while(A) {
		System.out.println("Please Choose what you want to do");
		System.out.println("1. Guest Options: ");
		System.out.println("2. Menu Options:");
		System.out.println("3. Room Options:");
		System.out.println("4. Reservation Options");
		System.out.println("5. Payment Options:");
		System.out.println("6. Room Service Options:");
		System.out.println("7. Shut System down");
		System.out.println("\nChoice :");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		switch(choice){
			case 1: 
				while(true){
				System.out.println("\nWhat do you want to do with the guest:");
				System.out.println("1. Create Guest: ");
				System.out.println("2. Remove Guest: ");
				System.out.println("3. Display All Guest: ");
				System.out.println("4. Search Guest: ");
				System.out.println("5. Exit :");
				System.out.println("\nChoice :");
				int c = scan.nextInt();
				
					if(c == 1) {
						guestMgr.createGuest();
					}
					else if(c == 2) {
						guestMgr.removeGuest();
					}
					else if(c==3) {
						guestMgr.printGList();
					}
					else if(c==4) {
						guestMgr.searchGuest();
					}
					else if(c==5) {
						break;
					}
					else {
						System.out.println("Invalid option");
					}
					
				}
				break;				
			case 2:
				while(true) {
					System.out.println("\nWhat do you want to do with the Menu:");
					System.out.println("1. Create Menu Item: ");
					System.out.println("2. Remove Menu Item: ");
					System.out.println("3. Display All Menu Items: ");
					System.out.println("4. Edit Menu: ");
					System.out.println("5. Exit :");
					System.out.println("\nChoice :");
					int c = scan.nextInt();
					if(c == 1) {
						menu.createItem();
					}
					else if(c == 2) {
						menu.removeItem();
					}
					else if(c==3) {
						menu.printMenu();
					}
					else if(c==4) {
						menu.editMenuItem();
					}
					else if(c==5) {
						break;
					}
					else {
						System.out.println("Invalid option");
					}
				}
				
				break;
			case 3:
				while(true) {
					System.out.println("\nWhat do you want to do with the Room:");
					//System.out.println("1. Create a Room: ");
					System.out.println("1. Get a Room's Detail: ");
					System.out.println("2. Update a Room's Detail: ");
					System.out.println("3. Print Vacancy Report ");
					System.out.println("4. Print Status Report :");
					System.out.println("5. Exit :");
					System.out.println("\nChoice :");
					int c = scan.nextInt();

					/*if(c == 1) {
						roomMgr.createRoom();
					}*/
					if(c == 1) {
						roomMgr.getDetails();
					}
					else if(c==2) {
						roomMgr.updateDetails();
					}
					else if(c==3) {
						roomMgr.roomVacancyReport();
					}
					else if(c==4) {
						roomMgr.roomStatusReport();
					}
					else if(c==5) {
						break;
					}
					else {
						System.out.println("Invalid option");
					}
				}
				
				break;
			case 4:
				while(true) {
					System.out.println("\nWhat do you want to do with the Reservation:");
					System.out.println("1. Create a Reservation: ");
					System.out.println("2. Remove a Reservation: ");
					System.out.println("3. Display all reservations: ");
					System.out.println("4. Guest Check-in: ");
					System.out.println("5. Exit :");
					System.out.println("\nChoice :");
					int c = scan.nextInt();
					if(c == 1) {
						reserveMgr.createReserve();
					}
					else if(c == 2) {
						reserveMgr.removeReserve();
					}
					else if(c==3) {
						reserveMgr.printReserve();
					}
					else if(c==4) {
						reserveMgr.updateCheckInStatus();
					}
					else if(c==5) {
						break;
					}
					else {
						System.out.println("Invalid option");
					}
				}
				break;
			case 5:
				while(true) {
					System.out.println("\nWhat do you want to do with the Payment:");
					System.out.println("1. Create a payment: ");
					System.out.println("2. Print bill invoice: ");
					System.out.println("3. Update room status: ");
					System.out.println("4. Exit :");
					System.out.println("\nChoice :");
					int c = scan.nextInt();
					if(c == 1) {
						paymentMgr.createPayment();
					}
					else if(c == 2) {
						paymentMgr.printBill();
					}
					else if(c==3) {
						paymentMgr.updateRoomStatus();
					}
					else if(c==4) {
						break;
					}
					else {
						System.out.println("Invalid option");
					}
				}
				break;

			case 6:
				while(true) {
			          System.out.println("\nWhat do you want to do under Room Service:");
			          System.out.println("1. Create New Order: ");
			          System.out.println("2. Remove an Order Item: ");
			          System.out.println("3. Update order status to PREPARING: ");
			          System.out.println("4. Update order status to DELIVERED: ");
			          System.out.println("5. Exit :");
			          System.out.println("\nChoice :");
			          int c = scan.nextInt();
			          if(c == 1) {
			        	  int GID = 0;
			        	  System.out.println("Please enter your guest ID: ");
			        	  GID = scan.nextInt();
			            rSMgr.createOrder(GID);
			          }
			          else if(c == 2) {
			        	int OID = 0;
			        	System.out.println("What is the order ID you want to remove?");
			        	OID = scan.nextInt();
			            rSMgr.removeOrderItem(OID);
			          }
			          else if(c==3) {
			        	int OID = 0;
				        System.out.println("What is the order ID you want to remove?");
				        OID = scan.nextInt();
			            rSMgr.updateOrderstatusP(OID);
			          }
			          else if(c==4) {
			        	int OID = 0;
				        System.out.println("What is the order ID you want to remove?");
				        OID = scan.nextInt();
			            rSMgr.updateOrderstatusD(OID);
			          }
			          else if(c==5) {
			            break;
			          }
			          else {
			            System.out.println("Invalid option");
			          }
			        }
				break;
			case 7:
				System.out.println("----Thank you!----");
				A = false;
				break;
			}
		}
		
	}

}


