package oodp;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.io.*;

public class RoomMgr {
    public static RoomMgr instance;
    private HandlerInterface database;
    static ArrayList<Room>  rooms = new ArrayList<>();

    public RoomMgr() {
        //retrieve data
        database = new DataHandler();
        rooms = database.readSerializedObject("Rooms");  //rooms in arraylist
    }
    public static RoomMgr getInstance() {
        if(instance == null) {
            instance = new RoomMgr();
        }
        return instance;
    }
    /*static ArrayList<Room> roomList = new ArrayList<Room>();
    public void createRoom() {
        char end = 'Y';
        Scanner scan = new Scanner(System.in);
        int roomNo;
        String roomType;
        String bedType;
        float roomRate;
        boolean wifi;
        boolean smoking;
        String roomStatus;
        while(end == 'Y') {
            System.out.print("\nRoom Number: ");
            roomNo=scan.nextInt();

            System.out.print("\nRoom Type (SINGLE/DOUBLE/SUITE/DELUXE/VIP): ");
            while(true) {
                roomType=scan.next();
                if(roomType.toUpperCase().matches("SINGLE") || roomType.toUpperCase().matches("DOUBLE")
                        || roomType.toUpperCase().matches("SUITE")|| roomType.toUpperCase().matches("DELUXE")
                        || roomType.toUpperCase().matches("VIP")) {
                    break;
                }
                else {
                    System.out.println("Invalid Option,type of rooms : Single/Double/Suite/Deluxe/VIP");
                }
            }

            System.out.print("\nBed Type(Single/Double): ");
            bedType=scan.next();

            System.out.print("\nRoom rate : ");
            roomRate=scan.nextFloat();

            System.out.print("\nWifi enabled? Y/N:");
            while(true) {
                String wifi1=scan.next();
                if(wifi1.toUpperCase().matches("Y")) {
                    wifi = true;
                    break;
                }
                else if(wifi1.toUpperCase().matches("N")) {
                    wifi =false;
                    break;
                }
                else {
                    System.out.println("Invalid Option, Please type Y or N");
                }
            }

            System.out.print("\nSmoking allowed? Y/N:" );
            while(true) {
                String smoking1=scan.next();
                if(smoking1.toUpperCase().matches("Y")) {
                    smoking = true;
                    break;
                }
                else if(smoking1.toUpperCase().matches("N")) {
                    smoking =false;
                    break;
                }
                else {
                    System.out.println("Invalid Option, Please type Y or N");
                }
            }

            System.out.print("\nRoom Status (MAINTENANCE/OCCUPIED/VACANT/RESERVED) : ");
            while(true) {
                roomStatus = scan.next();
                if(roomStatus.toUpperCase().matches("MAINTENANCE") ||  roomStatus.toUpperCase().matches("OCCUPIED") ||
                        roomStatus.toUpperCase().matches("VACANT") || roomStatus.toUpperCase().matches("RESERVED")) {
                    break;
                }
                else {
                    System.out.println("Invalid Option,Status can only be : MAINTENANCE/OCCUPIED/VACANT/RESERVED");
                }
            }
            Room A = new Room(roomNo,RoomType.valueOf(roomType.toUpperCase()),bedType,roomRate,wifi,smoking,RoomStatus.valueOf(roomStatus.toUpperCase()));
            roomList.add(A);
            System.out.println("\nEnter Another Room? (Y/N)");
            String word = scan.next();
            word = word.toUpperCase();
            end= word.charAt(0);
        }
    }*/

    public void getDetails(){
        Scanner obj1 = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter room number: ");
        String roomNumber = obj1.next();  // Read user input
        int index = 0;
        for(int i =0; i<rooms.size(); i++) {
            if (Objects.equals(roomNumber, rooms.get(i).getRoomNo())) {
                System.out.println("-----------------------------");
                System.out.println("|    DETAILS OF ROOM      |" + roomNumber);
                System.out.println("\n-----------------------------");
                System.out.println("Room Number: " + rooms.get(index).getRoomNo());
                System.out.println("Room Status: " + rooms.get(index).getRoomStatus());
                System.out.println("Room Type: " + rooms.get(index).getRoomType());
                System.out.println("Bed Type: " + rooms.get(index).getBedType().toUpperCase());
                System.out.println("Room rate: " + rooms.get(index).getRoomRate());
                System.out.println("Wifi Enabled: " + rooms.get(index).getWifi());
                System.out.println("Smoking: " + rooms.get(index).getSmoking());
                System.out.println("-----------------------------");
                break;}
            else {index++;}

        }
        if(rooms.size() < index+1) {
            System.out.println("No Room with room number " + roomNumber + " found.");
        }

    }

    public void updateDetails(){
        Scanner obj2 = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter room number: ");
        String roomNumber = obj2.nextLine();  // Read user input
        int index =0;


        for(int i =0; i<rooms.size(); i++) {
            if(roomNumber.compareTo(rooms.get(i).getRoomNo()) ==0){
                System.out.println("Which details do you want to change?: ");
                System.out.println("1. Room Status ");
                System.out.println("2. Room Type");
                System.out.println("3. Bed Type");
                System.out.println("4. Room Rate ");
                System.out.println("5. Wifi ");
                System.out.println("6. Smoking ");


                int choice = obj2.nextInt();
                switch(choice){
                    case 1:
                        System.out.println("New Room status: ");
                        while(true) {
                            String RS = obj2.next();
                            if(RS.toUpperCase().matches("MAINTENANCE") ||  RS.toUpperCase().matches("OCCUPIED") ||
                                    RS.toUpperCase().matches("VACANT") || RS.toUpperCase().matches("RESERVED")) {
                                rooms.get(i).setRoomStatus(RoomStatus.valueOf(RS.toUpperCase()));
                                break;
                            }
                            else {
                                System.out.println("Invalid Option,Please input a valid option");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("New Room type: ");
                        while(true) {
                            String roomType=obj2.next();
                            if(roomType.toUpperCase().matches("SINGLE") || roomType.toUpperCase().matches("DOUBLE")
                                    || roomType.toUpperCase().matches("SUITE")|| roomType.toUpperCase().matches("DELUXE")
                                    || roomType.toUpperCase().matches("VIP")) {
                                rooms.get(i).setRoomType(RoomType.valueOf(roomType.toUpperCase()));
                                break;
                            }
                            else {
                                System.out.println("Invalid Option,type of rooms : Single/Double");
                            }
                        }

                        break;
                    case 3:
                        System.out.println("New Bed type(Single/Double): ");
                        String BT = obj2.next();
                        rooms.get(i).setBedType(BT);
                        break;
                    case 4:
                        System.out.print("New Room rating: ");
                        float RR = obj2.nextFloat();
                        rooms.get(i).setRoomRate(RR);
                        break;
                    case 5:
                        System.out.print("Wifi (Y/N): ");
                        String wifi = obj2.next();
                        if(wifi.toUpperCase().matches("Y"))
                        {
                            boolean wifiC = true;
                            rooms.get(i).setWifi(wifiC);
                        }
                        if(wifi.toUpperCase().matches("N"))
                        {
                            boolean wifiC = false;
                            rooms.get(i).setWifi(wifiC);
                        }
                        break;
                    case 6:
                        System.out.print("Smoking (Y/N): ");
                        String smoke = obj2.next();
                        if(smoke.toUpperCase().matches("Y"))
                        {
                            boolean SmokingC = true;
                            rooms.get(i).setSmoking(SmokingC);
                        }
                        if(smoke.toUpperCase().matches("N"))
                        {
                            boolean SmokingC = false;
                            rooms.get(i).setSmoking(SmokingC);
                        }
                        break;
                }
                break;
            }
            else {index++;}


        }
        if(rooms.size() < index+1) {
            System.out.println("No Room with room number " + roomNumber + " found.");
        }
    }

    public void roomVacancyReport() {
        int VsingleNo = 0;
        int AsingleNo = 0;
        int VdoubleNo = 0;
        int AdoubleNo = 0;
        int VsuiteNo = 0;
        int AsuiteNo = 0;
        int VdeluxeNo = 0;
        int AdeluxeNo = 0;
        int VvipNo = 0;
        int AvipNo = 0;

        System.out.println("-----------SINGLE-------------");
        System.out.println("Rooms:");
        for(int i =0; i<rooms.size(); i++) {
            if(rooms.get(i).getRoomStatus() == RoomStatus.VACANT &&
                    rooms.get(i).getRoomType() ==  RoomType.SINGLE) {
                AsingleNo++;
                VsingleNo++;
                System.out.print(rooms.get(i).getRoomNo()+ ",");
            }
            else AsingleNo++;
        }
        System.out.println("\nNumber of rooms: " + VsingleNo + " out of " + AsingleNo);
		



        System.out.println("\n-----------DOUBLE------------");
        System.out.println("Rooms:");
        for(int j =0; j<rooms.size(); j++) {
            if(rooms.get(j).getRoomStatus()== RoomStatus.VACANT &&
                    rooms.get(j).getRoomType() == RoomType.DOUBLE) {
                AdoubleNo++;
                VdoubleNo++;
                System.out.print(rooms.get(j).getRoomNo()+ ",");
            }
            else {
                AdoubleNo++;
            }
        }
        System.out.println("\nNumber of rooms: " + VdoubleNo + " out of " + AdoubleNo);
		

        System.out.println("\n-----------SUITE-------------");
        System.out.println("Rooms:");
        for(int j =0; j<rooms.size(); j++) {
            if(rooms.get(j).getRoomStatus()== RoomStatus.VACANT &&
                    rooms.get(j).getRoomType() == RoomType.SUITE) {
                AsuiteNo++;
                VsuiteNo++;
                System.out.print(rooms.get(j).getRoomNo()+ ",");
            }
            else {
                AsuiteNo++;
            }
        }
        System.out.println("\nNumber of rooms: " + VsuiteNo + " out of " + AsuiteNo);
		


        System.out.println("\n-----------DELUXE------------");
        System.out.println("Rooms:");
        for(int j =0; j<rooms.size(); j++) {
            if(rooms.get(j).getRoomStatus()== RoomStatus.VACANT &&
                    rooms.get(j).getRoomType() == RoomType.DELUXE) {
                AdeluxeNo++;
                VdeluxeNo++;
                System.out.print(rooms.get(j).getRoomNo()+ ",");
            }
            else {
                AdeluxeNo++;
            }
        }
        System.out.println("\nNumber of rooms: " + VdeluxeNo + " out of " + AdeluxeNo);
        



        System.out.println("\n-------------VIP-------------");
        System.out.println("Rooms:");
        for(int j =0; j<rooms.size(); j++) {
            if(rooms.get(j).getRoomStatus()== RoomStatus.VACANT &&
                    rooms.get(j).getRoomType() == RoomType.VIP) {
                AvipNo++;
                VvipNo++;
                System.out.print(rooms.get(j).getRoomNo()+ ",");
            }
            else {
                AvipNo++;
            }
        }
        System.out.println("\nNumber of rooms: " + VvipNo + " out of " + AvipNo);
        System.out.println("-----------------------------");
        

    }


    public void roomStatusReport() {

    	System.out.println("-----------VACANT------------");
        System.out.println("Rooms: ");
        for(int i =0; i<rooms.size(); i++) {
            if(rooms.get(i).getRoomStatus()==RoomStatus.VACANT) {
                System.out.print(rooms.get(i).getRoomNo()+",");
            }
        }
        
       

        System.out.println("\n----------OCCUPIED-----------");
        System.out.println("Rooms: ");
        for(int i =0; i<rooms.size(); i++) {
            if(rooms.get(i).getRoomStatus() == RoomStatus.OCCUPIED) {
                System.out.print(rooms.get(i).getRoomNo()+",");
            }
        }
        
       


        System.out.println("\n----------RESERVED-----------");
        System.out.println("Rooms: ");
        for(int i =0; i<rooms.size(); i++) {
            if(rooms.get(i).getRoomStatus() == RoomStatus.RESERVED) {
                System.out.print(rooms.get(i).getRoomNo()+",");
            }
        }
        
        


        System.out.println("\n---------MAINTENANCE---------");
        System.out.println("Rooms: ");
        for(int i =0; i<rooms.size(); i++) {
            if(rooms.get(i).getRoomStatus()== RoomStatus.MAINTENANCE) {
                System.out.print(rooms.get(i).getRoomNo()+",");
            }
        }
        
        System.out.println("\n-----------------------------");

    }
}
