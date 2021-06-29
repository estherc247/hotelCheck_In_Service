package oodp;

import java.util.ArrayList;
public class OrderItem {
	private int guestNo;
	private String guestName;
	private int roomNo;
	private static int orderID;
	private String dateOfOrder;
	private String timeOfOrder;
	private OrderStatus status;
	private ArrayList<MenuItems> orderedList;
	
	public OrderItem() {}
	public OrderItem(int guestNo,String guestName,int roomNo,
			String dateOfOrder,String timeOfOrder,OrderStatus status,
			ArrayList<MenuItems> orderedList) {
		this.guestNo = guestNo;
		this.guestName = guestName;
		this.roomNo = roomNo;
		this.dateOfOrder = dateOfOrder;
		this.timeOfOrder = timeOfOrder;
		this.status = status;
		this.orderedList = orderedList;
		orderID++;
	}
	public void setGuestNo(int guestNo) {this.guestNo= guestNo; }
	public void setGuestName(String guestName) {this.guestName = guestName; }
	public void setRoomNo(int roomNo) {this.roomNo = roomNo; }
	public void setDOO(String dateOfOrder) {this.dateOfOrder= dateOfOrder; }
	public void setTOO(String timeOfOrder) {this.timeOfOrder= timeOfOrder; }
	public void setStatus(OrderStatus status) {this.status= status; }
	
	public int getGuestNo() {return guestNo;}
	public String getGuestName() {return guestName;}
	public int getRoomNo() {return roomNo;}
	public int getOID() {return orderID;}
	public String getDOO() {return dateOfOrder;}
	public String getTOO() {return timeOfOrder;}
	public OrderStatus getStatus(){return status;}
	public ArrayList<MenuItems> getOrderedList(){return orderedList;}
	
}
