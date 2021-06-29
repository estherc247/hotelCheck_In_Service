package oodp;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Room implements Serializable
{
    private String roomNo;
    private RoomType roomType;
    private String bedType;
    private float roomRate;
    private boolean wifi;
    private boolean smoking;
    private RoomStatus roomStatus;
    private static int numberOfRooms;

    public Room(){
    }
    public Room(String roomNo, RoomType roomType, String bedType,float roomRate,boolean wifi,
                boolean smoking, RoomStatus roomStatus) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.bedType = bedType;
        this.roomRate = roomRate;
        this.wifi = wifi;
        this.smoking = smoking;
        this.roomStatus = roomStatus;
        numberOfRooms++;
    }

    //public Room(int roomNo, RoomType single, String single1, int roomRate, boolean wifi, boolean smoking, RoomStatus occupied) {}

    public void setRoomNo(String roomNo) {this.roomNo = roomNo; }
    public void setRoomType(RoomType roomType) {this.roomType = roomType; }
    public void setBedType(String bedType) {this.bedType = bedType; }
    public void setRoomRate(float roomRate) {this.roomRate = roomRate; }
    public void setWifi(boolean wifi) {this.wifi = wifi; }
    public void setSmoking(boolean smoking) {this.smoking = smoking; }
    public void setRoomStatus(RoomStatus roomStatus) {this.roomStatus = roomStatus; }

    public String getRoomNo() {return roomNo;}
    public RoomType getRoomType() {return roomType;}
    public String getBedType() {return bedType;}
    public float getRoomRate() {return roomRate;}
    public boolean getWifi() {return wifi;}
    public boolean getSmoking() {return smoking;}
    public RoomStatus getRoomStatus() {return roomStatus;}
    public int getNumberOfRooms() {return numberOfRooms;}

    }



