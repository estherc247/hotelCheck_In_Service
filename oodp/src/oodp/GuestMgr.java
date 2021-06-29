package oodp;



import java.util.ArrayList;
import java.util.Scanner;

public class GuestMgr {
	public static GuestMgr instance;
	public GuestMgr() {}
	public static GuestMgr getInstance() {
		if(instance == null) {
			instance = new GuestMgr();
		}
		return instance;
	}
	static ArrayList<Guest> guestList = new ArrayList<Guest>();
	public static void createGuest(){
		
		Scanner scan = new Scanner(System.in);
			char end = 'Y';
			String guestName;
			int guestAge;
			char guestGender;
			String guestAddress;
			String guestNationality;
			String guestCountry;
			int guestContact;
			long guestCCNo;
			String guestCardExpiry;
			int guestCCV;
			String guestIDType;
			String guestIDNo;
			
			while(end == 'Y') {
				 System.out.print("\nName: ");
				 guestName=scan.nextLine();

			     System.out.print("\nAge: ");
			     guestAge=scan.nextInt();

			     System.out.print("\nGender(f/m): ");
			     guestGender=scan.next().charAt(0);
			    				     
			     System.out.print("\nAddress: ");
			     guestAddress=scan.next();
			     
			     System.out.print("\nNationality: ");
			     guestNationality=scan.next();
			     
			     System.out.print("\nCountry: ");
			     guestCountry=scan.next();
			     
			     System.out.print("\nContact No: ");
			     guestContact=scan.nextInt();
			     
			     System.out.print("\nCredit Card No: ");
			     guestCCNo=scan.nextLong();
			     
			     System.out.print("\nCard expiry Date: ");
			     guestCardExpiry=scan.next();
			     
			     System.out.print("\nCard CCV: ");
			     guestCCV=scan.nextInt();
			     
			     System.out.print("\nID type: ");
			     guestIDType=scan.next();
			     
			     System.out.print("\nID No: ");
			     guestIDNo=scan.next();
			     
			     Human A = new Human(guestName,guestAge,guestGender,guestAddress);
			     CreditCard A1 = new CreditCard(guestCCNo,guestCardExpiry,guestCCV);
			     Identity A2 = new Identity(guestIDType,guestIDNo);
			     Guest A3 =  new Guest(A.getName(),A.getAge(),
			    		 A.getGender(),A.getAddress(),guestNationality,
							guestCountry,guestContact,A1,A2);
			     guestList.add(A3);
			     System.out.println("\nEnter Another Guest? (Y/N)");
			     String word = scan.next();
			     word = word.toUpperCase();
			     end= word.charAt(0);
			     
			     }
			     
			}
	
	
	public static void printGList() {
		
		System.out.println("-------------------------------");
		System.out.println("|         ~~ GUEST ~~         |");
		System.out.println("-------------------------------");
		
		for(int i=0; i<guestList.size();i++) {
			System.out.println("Guest Name: " + guestList.get(i).getName());
			System.out.println("Guest Age: " + guestList.get(i).getAge());
			System.out.println("Guest Gender: " + guestList.get(i).getGender());
			System.out.println("Guest Address: " + guestList.get(i).getAddress());
			System.out.println("Guest Nationality: " + guestList.get(i).getNationality());
			System.out.println("Guest Country: " + guestList.get(i).getCountry());
			System.out.println("Guest Contact Number: " + guestList.get(i).getContactNo());
			System.out.println("Guest Credit Card Number: " + guestList.get(i).getcC().getCardNo());
			System.out.println("Guest Card Expiry Date: " + guestList.get(i).getcC().getExpiryDate());
			System.out.println("Guest CCV: " + guestList.get(i).getcC().getCCV());
			System.out.println("Guest ID type: " + guestList.get(i).getiD().getIDType());
			System.out.println("Guest ID number " + guestList.get(i).getiD().getIDNo());
			System.out.println("------------------------------------");
			}

	
	}
	public static void removeGuest() {
		
		String nameRemove;
		int index = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("\nPlease type the name you want to remove");
		nameRemove = scan.next();
		
		
		for(int i =0; i<guestList.size(); i++) {
			if(nameRemove.toLowerCase().matches(guestList.get(i).getName().toLowerCase())) {
				guestList.remove(guestList.get(index));
				System.out.println("\nGuest has been removed successfully!");
				break;
			}
			else {
				index++;
			}
			
		}
	}
	public static Guest searchGuest() {
		String nameSearch;
		Guest N = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("\nPlease type the name you want to search: ");
		nameSearch = scan.next();
		
		for(int i =0; i<guestList.size(); i++) {
			
			if(nameSearch.toLowerCase().matches(guestList.get(i).getName().toLowerCase())) {
				N = guestList.get(i);
				System.out.println("\nGuest successfully found!");
				System.out.println("------------------------------------");
				System.out.println("Guest Name: "+ guestList.get(i).getName());
				System.out.println("Guest Age: " + guestList.get(i).getAge());
				System.out.println("Guest Gender: " + guestList.get(i).getGender());
				System.out.println("Guest ID type: " + guestList.get(i).getiD().getIDType());
				System.out.println("Guest ID number " + guestList.get(i).getiD().getIDNo());
				System.out.println("------------------------------------");
				break;	
			}
		}
		return N;
		
	}
}

