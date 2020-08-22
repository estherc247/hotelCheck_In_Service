package oodp;

import java.util.Date;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.Calendar;


public class Payment {
    private String name;
    private String method;
    private int days;
    private double discount;
    private Reservation reservation;
    private Room room;
    private OrderItem orderitem;
    private static final double tax = 0.07;
    
    public Payment() {}
    public Payment(Reservation reservation, String name, Room room,
    		double discount, String method, OrderItem orderitem, int days)
    {
    	this.reservation = reservation;
    	this.name = name;
    	this.room = room;
    	this.discount = discount;
    	this.days = days;
    	this.method = method;
    	this.orderitem = orderitem;
    }
    
    /*Calculate room charges*/
	public double calRoomBill() 
	{
		double roomTotal = 0;
		roomTotal = days*room.getRoomRate();
		
		return roomTotal;
	}
	
	/*Calculate room service charges*/
	public double calRoomServiceBill()
	{
		ArrayList<MenuItems> ordered = orderitem.getOrderedList();
		double roomServiceTotal = 0.0;
		
		for(MenuItems orderitem:ordered)
		{
			roomServiceTotal += orderitem.getFoodPrice();
		}
		
		return roomServiceTotal;
		
	}
	
	/*Calculate taxAmt*/
	public double calTaxAmt()
	{
		return tax * (calRoomBill() + calRoomServiceBill());
	}
	
	/*Calculate discountAmt*/
	public double calDiscountAmt()
	{
		return discount/100 * (calRoomBill() + calRoomServiceBill());
	}
	
	/*Calculate total with tax and discount*/
	public double calTotal()
	{
		return calRoomBill() + calRoomServiceBill() + calTaxAmt() - calDiscountAmt();
	}

    public Reservation getReservation() {return reservation;}
    public void setReservation(Reservation reservation) {this.reservation = reservation;}
    
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    
    public Room getRoom() {return room;}
    public void setRoom(Room room) {this.room = room;}
    
    public double getDiscount() {return discount;}
    public void setDiscount(double discount) {this.discount = discount;}
    
    public int getDays() {return days;}
    public void setDays(int days) {this.days = days;}
    
    public String getMethod() {return method;}
    public void setMethod(String method) {this.method = method;}
    
    public OrderItem getorderItem() {return orderitem;}
    public void setorderItem(OrderItem orderitem) {this.orderitem = orderitem;} 
    
}