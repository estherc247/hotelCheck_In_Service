package oodp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class PaymentMgr {

	public static PaymentMgr instance;
	public PaymentMgr() {}
	public static PaymentMgr getInstance() {
		if(instance == null) {
			instance = new PaymentMgr();
		}
		return instance;
	}

	static ArrayList<Payment> paymentList = new ArrayList<Payment>();

	public void createPayment()
	{
		int days = 0;
		String roomNo;
		int rNo=0;
		double discount = 0.0;
		String paymentMethod;
		String name;

		Reservation r = null;
		Room rm = null;
		Guest g = null;
		OrderItem or = null;
		GuestMgr guestMgr = GuestMgr.getInstance();
		RoomMgr roomMgr = RoomMgr.getInstance();
		ReservationMgr reserveMgr = ReservationMgr.getInstance();
		RoomServiceMgr rsMgr = RoomServiceMgr.getInstance();


		Scanner sc = new Scanner(System.in);


		g = guestMgr.searchGuest();
		while(g==null) {
			System.out.println("Guest not found!");
			g = guestMgr.searchGuest();
		}
		name = g.getName();

		System.out.println("Reservation No. ");
		rNo = sc.nextInt();
		for(int i =0; i<reserveMgr.reserveList.size(); i++)
		{
			if(reserveMgr.reserveList.get(i).getReserveNo() == rNo)
				r = reserveMgr.reserveList.get(i);
		}

		/*Get room service ordered list for this payment*/
		for(int i = 0; i<rsMgr.orders.size(); i++)
		{
			if(rsMgr.orders.get(i).getGuestName().toLowerCase().matches(name.toLowerCase()))
			{
				System.out.print("hi");
				or = rsMgr.orders.get(i);
			}
		}

		System.out.println("Room No.: ");
		roomNo = sc.nextLine();
		for(int i=0; i<roomMgr.rooms.size(); i++)
		{
			if(roomMgr.rooms.get(i).getRoomNo() == roomNo)
			{
				rm = roomMgr.rooms.get(i);
			}
		}

		/*Retrieve discount(if any)*/
		Boolean dis = false;
		do {
			System.out.println("Enter discount (if none, input 0): ");
			try {
				discount = sc.nextDouble();
				if (discount < 0 || discount > 80)
					System.out.println("Discount not valid. Please try again!");
				else
					dis = true;
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input. Please try again!");
				sc.next();
			}
		}while(dis == false);

		/*Payment Method*/
		System.out.println("Choose payment method: ");
		System.out.println("(1) Cash");
		System.out.println("(2) Credit Card");
		int c = sc.nextInt();

		if(c == 1)
		{
			paymentMethod = "Cash";
		}
		else
		{
			paymentMethod = "Credit Card";
		}

		days = r.getDays();

		Payment payment = new Payment(r, name, rm, discount, paymentMethod, or, days);
		paymentList.add(payment);
	}

	/*Print Bill Invoice*/
	public void printBill()
	{
		for(Payment paymentitem:paymentList) {
			System.out.println("======================");
			System.out.println("     Bill Invoice     ");
			System.out.println("======================");
			System.out.println("");

			System.out.println("Bill to: " + paymentitem.getName());
			System.out.println("Payed by : " + paymentitem.getMethod());
			System.out.println();

			System.out.println("Duration of stay: " + paymentitem.getReservation().getCheckInDate() + " to " + paymentitem.getReservation().getCheckOutDate() + " (" + paymentitem.getDays() + "days)");
			System.out.println("-- Room Charges -- ");
			System.out.println("Total room charges before tax: " + paymentitem.calRoomBill());
			System.out.println();

			System.out.println("-- Room Service --");
			//list out all room service items that guest ordered
			System.out.println("Ordered Items: ");
			ArrayList<MenuItems> ordered = paymentitem.getorderItem().getOrderedList();
			for(MenuItems orderitem:ordered)
			{
				System.out.println(orderitem.getFoodName());
			}


			System.out.println("Total cost: " + paymentitem.calRoomServiceBill());

			System.out.println("---------------------------------");
			System.out.println("Room Charges: " + paymentitem.calRoomBill());
			System.out.println("Room Service Charges: " + paymentitem.calRoomServiceBill());
			System.out.println("Tax: " + paymentitem.calTaxAmt());
			System.out.println("Total Discount (if any): " + paymentitem.calDiscountAmt());
			System.out.println("-- Grand Total: " + paymentitem.calTotal());
			System.out.println();
			System.out.println("Payment done. Thank You!");
		}
	}

	public void updateRoomStatus()
	{
		for(Payment paymentitem:paymentList) {
			paymentitem.getRoom().setRoomStatus(RoomStatus.VACANT);
		}
	}
}
