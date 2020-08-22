package oodp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class RoomServiceMgr {
	public static RoomServiceMgr instance;
	public RoomServiceMgr() {}
	public static RoomServiceMgr getInstance() {
		if(instance == null) {
			instance = new RoomServiceMgr();
		}
		return instance;
	}
	static ArrayList<OrderItem> orders = new ArrayList<OrderItem>();
	public static void createOrder(int guestID) {
		Scanner scan = new Scanner(System.in);
		char end = 'Y';
		String guestName;
		int roomNo;
		OrderStatus status;
		String foodName;
		String dateOfOrder = null;
		String timeOfOrder = null;
		boolean check = false;
		ArrayList<MenuItems> orderedList = new ArrayList<MenuItems>(); ;


		System.out.print("\nName: ");
		guestName=scan.next();


		check = false;
		while(check==false) {
			System.out.print("Date of order (dd/mm/yyyy): ");
			dateOfOrder=scan.next();
			check = validateJavaDate(dateOfOrder);
			if(check==false)
				System.out.println("Invalid date!");
		}
		check = false;
		while(check==false) {
			System.out.print("Time of order: ");
			timeOfOrder=scan.next();
			//check = validateJavaDate(timeOfOrder);
			if(check==false)
				System.out.println("Invalid date!");
		}

		System.out.print("\nRoom Number:");
		roomNo=scan.nextInt();


		status = OrderStatus.COMFIRMED;
		for(int i =0;i<GuestMgr.guestList.size();i++) {
			if(guestID == GuestMgr.guestList.get(i).getGuestNo()) {
				guestName = GuestMgr.guestList.get(i).getName();
			}
		}

		while(end == 'Y') {
			System.out.print("\nFood Name you want to order?");
			foodName =scan.next();
			for(int i =0; i < Menu.food.size(); i++) {
				if(Menu.food.get(i).getFoodName().toLowerCase().matches(foodName.toLowerCase())){
					orderedList.add(new MenuItems(Menu.food.get(i).getFoodName(),
							Menu.food.get(i).getFoodDesc(), Menu.food.get(i).getFoodRemarks(),
							Menu.food.get(i).getFoodPrice()));
				}
			}
			System.out.println("\nEnter Another Food Items? (Y/N)");
			String word = scan.next();
			word = word.toUpperCase();
			end= word.charAt(0);

		}
		OrderItem A = new OrderItem(guestID,guestName,roomNo,dateOfOrder,timeOfOrder,
				status,orderedList);

		orders.add(A);


	}
	public static void removeOrderItem(int orderID) {

		int index = 0;
		Scanner scan = new Scanner(System.in);

		for(int i=0;i<orders.size();i++)
		{
			if(orderID == (orders.get(i).getOID()))
			{
				orders.remove(orders.get(index));
				break;
			}
			else
			{
				index++;
			}
		}

	}
	public static void updateOrderstatusP(int orderID) {
		for(int i = 0;i<orders.size();i++)
		{
			if(orderID == (orders.get(i).getOID())){
				orders.get(i).setStatus(OrderStatus.PREPARING);
			}
		}
	}
	public static void updateOrderstatusD(int orderID) {
		for(int i = 0;i<orders.size();i++)
		{
			if(orderID == (orders.get(i).getOID())){
				orders.get(i).setStatus(OrderStatus.DELIVERED);
				removeOrderItem(orderID);
			}
		}
	}

	public static boolean validateJavaDate(String strDate)
	{
		if (strDate.trim().equals(""))
		{
			return true;
		}
		else
		{
			SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/mm/yyyy");
			sdfrmt.setLenient(false);
			try
			{
				Date javaDate = sdfrmt.parse(strDate);
			}
			/* Date format is invalid */
			catch (ParseException e)
			{
				return false;
			}
			return true;
		}
	}


}
