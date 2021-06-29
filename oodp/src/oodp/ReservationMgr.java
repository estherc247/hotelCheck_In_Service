package oodp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class ReservationMgr {
	public static ReservationMgr instance;
	public ReservationMgr() {}
	public static ReservationMgr getInstance() {
		if(instance == null) {
			instance = new ReservationMgr();
		}
		return instance;
	}
	static ArrayList<Reservation> reserveList = new ArrayList<Reservation>();
	public void createReserve() {
		Scanner sc = new Scanner(System.in);
		char end = 'Y';
		int reservationNo;
		String checkInDate=null;
		String checkOutDate=null;
		ReservationStatus reservationStatus=ReservationStatus.CONFIRMED;
		String guestName;
		Guest guest = null;
		GuestMgr guestMgr = GuestMgr.getInstance();
		Room room = null;
		RoomMgr roomMgr = RoomMgr.getInstance();
		String roomNo;
		int noOfAdult;
		int noOfChildren;
		int days;

		ArrayList<Guest> guestList = guestMgr.guestList;
		ArrayList<Room> roomList = RoomMgr.rooms;


		int index = 0;
		while(Character.toUpperCase(end) == 'Y') {
			guest = guestMgr.searchGuest();
			if(guest == null) {
				System.out.println("Guest not found!");
				break;
			}
			boolean check = false;
			while(check == false) {
				System.out.print("Enter Room Number: ");
				roomNo = sc.nextLine();
				for(int i =0; i<roomList.size(); i++) {
					if(Objects.equals(roomNo, roomList.get(i).getRoomNo())) {
						room = roomList.get(index);
						break;
					}
					else
						index++;
				}
				if(room == null)
					System.out.println("Invalid Room Number");
				else {
					RoomStatus status = room.getRoomStatus();
					if((status != (RoomStatus.VACANT))) {
						System.out.println("Room is not available!");
					}
					else {
						room.setRoomStatus(RoomStatus.RESERVED);
						check = true;
					}
				}
			}
			System.out.print("Enter number of adult(s): ");
			noOfAdult = sc.nextInt();
			System.out.print("Enter number of child(s): ");
			noOfChildren = sc.nextInt();
			System.out.print("Enter no. of days: ");
			days = sc.nextInt();
			check = false;
			while(check==false) {
				System.out.print("Enter Check In Date(dd/MM/yyyy): ");
				checkInDate = sc.next();
				check = validateJavaDate(checkInDate);
				if(check==false)
					System.out.println("Invalid date!");
			}
			check = false;
			while(check==false) {
				System.out.print("Enter Check Out Date(dd/MM/yyyy): ");
				checkOutDate = sc.next();
				check = validateJavaDate(checkOutDate);
				if(check==false)
					System.out.println("Invalid date!");
			}

			Reservation R = new Reservation(checkInDate, checkOutDate,
					reservationStatus, guest, room,
					noOfAdult, noOfChildren, days);
			reserveList.add(R);
			System.out.print("Enter Another Reservation? (Y/N)");
			end = sc.next().charAt(0);
		}
	}

	public void removeReserve() {
		int reservationNo;
		int index = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter reservation number to remove: ");
		reservationNo = sc.nextInt();
		System.out.println(reservationNo);

		for(int i =0; i<reserveList.size(); i++) {
			System.out.println(reserveList.get(i));
			if(reservationNo == (reserveList.get(i).getReserveNo())) {
				reserveList.remove(reserveList.get(index));
				break;
			}
			else {
				index++;
			}

		}
	}

	public void printReserve() {
		for(Reservation reserveitem:reserveList) {
			System.out.println("Reservation Number: " + reserveitem.getReserveNo());
			System.out.println("Guest Name: " + reserveitem.getGuest().getName());
			System.out.println("Guest Contact Number: " + reserveitem.getGuest().getContactNo());
			System.out.println("Check In Date: " + reserveitem.getCheckInDate());
			System.out.println("Check Out Date: " + reserveitem.getCheckOutDate());
			System.out.println("No. of Adult(s): " + reserveitem.getNoOfAdult());
			System.out.println("No. of Children: " + reserveitem.getNoOfChildren());
			System.out.println("Reservation Status: " + reserveitem.getReservationStatus());
			System.out.println("Room Number: " + reserveitem.getRoom().getRoomNo());
			System.out.println("------------------------------------");
		}
	}

	public void updateCheckInStatus() {
		int index = 0;
		Guest guest = null;
		GuestMgr guestMgr = GuestMgr.getInstance();
		guest = guestMgr.searchGuest();
		if(guest==null) {
			System.out.println("Checked In successfully.");
		}
		for(int i =0; i<reserveList.size(); i++) {
			if(reserveList.get(i).getGuest().getName().toLowerCase().contains(guest.getName().toLowerCase())) {
				reserveList.get(i).setReservationStatus(ReservationStatus.CHECKEDIN);
				reserveList.get(i).getRoom().setRoomStatus(RoomStatus.OCCUPIED);
				System.out.println("Checked In successfully.");
				printReserve();
			}
			else {
				index++;
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
			SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
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