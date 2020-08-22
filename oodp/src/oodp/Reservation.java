package oodp;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Reservation {

	private int reservationNo;
	private String checkInDate;
	private String checkOutDate;
	private ReservationStatus reservationStatus;
	private Guest guest;
	private Room room;
	private int noOfAdult;
	private int noOfChildren;
	private int days;
	private static int IdCount = 1;
	private boolean checkIn;



	public Reservation() {}
	public Reservation(String checkInDate, String checkOutDate,
					   ReservationStatus reservationStatus, Guest guest, Room room,
					   int noOfAdult, int noOfChildren, int days) {
		this.reservationNo = IdCount++;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.reservationStatus = reservationStatus;
		this.guest = guest;
		this.room = room;
		this.noOfAdult = noOfAdult;
		this.noOfChildren = noOfChildren;
		this.days = days;
	}

	public void setReserveNo(int reservationNo) {this.reservationNo= reservationNo; }
	public void setCheckInDate(String checkInDate) {this.checkInDate= checkInDate; }
	public void setCheckOutDate(String checkOutDate) {this.checkOutDate= checkOutDate; }
	public void setReservationStatus(ReservationStatus reservationStatus) {this.reservationStatus= reservationStatus; }
	public void setNoOfAdult(int noOfAdult) {this.noOfAdult= noOfAdult; }
	public void setNoOfChildren(int noOfChildren) {this.noOfChildren= noOfChildren; }
	public void setGuest(Guest guest) {this.guest= guest; }
	public void setRoom(Room room) {this.room= room; }
	public void setDays(int days) {this.days= days;}

	public int getReserveNo() {return this.reservationNo; }
	public String getCheckInDate() {return this.checkInDate; }
	public String getCheckOutDate() {return this.checkOutDate; }
	public ReservationStatus getReservationStatus() {return this.reservationStatus; }
	public int getNoOfAdult() {return this.noOfAdult; }
	public int getNoOfChildren() {return this.noOfChildren; }
	public Guest getGuest() {return this.guest; }
	public Room getRoom() {return this.room; }
	public int getDays() {return this.days;}

}
