package Data;

import oodp.*;
import com.sun.tools.javac.Main;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        HandlerInterface database = new DataHandler();
        ArrayList<Room> rooms = new ArrayList<>();
        Room r1 = new Room("0101", RoomType.SINGLE, "Single", 266, true, true, RoomStatus.OCCUPIED);
        Room r2 = new Room("0102",RoomType.SINGLE, "Double",226, true, true, RoomStatus.OCCUPIED);
        Room r3 = new Room("0103",RoomType.DELUXE, "Single",426, true, true, RoomStatus.VACANT);
        Room r4 = new Room("0104",RoomType.DELUXE, "Double",486, true, true, RoomStatus.VACANT);
        Room r5 = new Room("0105",RoomType.DOUBLE, "Double",316, true, true, RoomStatus.MAINTENANCE);
        Room r6 = new Room("0106",RoomType.SUITE, "Single",526, true, true, RoomStatus.OCCUPIED);
        Room r7 = new Room("0107",RoomType.SUITE, "Double",566, true, false, RoomStatus.VACANT);

        Room r8 = new Room("0201",RoomType.SUITE, "Double",266, false, false, RoomStatus.OCCUPIED);
        Room r9 = new Room("0202",RoomType.SUITE, "Double",566, false, true, RoomStatus.MAINTENANCE);
        Room r10 = new Room("0203",RoomType.DELUXE, "Single",426, true, true, RoomStatus.VACANT);
        Room r11 = new Room("0204",RoomType.SINGLE, "Single",186, true, true, RoomStatus.VACANT);
        Room r12 = new Room("0205",RoomType.DOUBLE, "Double",316, true, false, RoomStatus.OCCUPIED);
        Room r13 = new Room("0206",RoomType.DELUXE, "Double",486, true, false, RoomStatus.RESERVED);
        Room r14 = new Room("0207",RoomType.SUITE, "Single",526, true, true, RoomStatus.OCCUPIED);

        Room r15 = new Room("0301",RoomType.SINGLE, "Single",186, false, false, RoomStatus.MAINTENANCE);
        Room r16 = new Room("0302",RoomType.SINGLE, "Double",226, true, false, RoomStatus.VACANT);
        Room r17 = new Room("0303",RoomType.SUITE, "Double",566, true, true, RoomStatus.VACANT);
        Room r18 = new Room("0304",RoomType.DOUBLE, "Single",274, true, true, RoomStatus.OCCUPIED);
        Room r19 = new Room("0305",RoomType.VIP, "Double",862, true, true, RoomStatus.RESERVED);
        Room r20 = new Room("0306",RoomType.SUITE, "Single",526, true, false, RoomStatus.OCCUPIED);
        Room r21 = new Room("0307",RoomType.DELUXE, "Single",426, false, false, RoomStatus.VACANT);

        Room r22 = new Room("0401",RoomType.DOUBLE, "Double",316, false, true, RoomStatus.MAINTENANCE);
        Room r23 = new Room("0402",RoomType.SINGLE, "Double",226, true, true, RoomStatus.VACANT);
        Room r24 = new Room("0403",RoomType.SINGLE, "Single",186, true, true, RoomStatus.VACANT);
        Room r25 = new Room("0404",RoomType.SUITE, "Double",566, true, true, RoomStatus.OCCUPIED);
        Room r26 = new Room("0405",RoomType.SUITE, "Double",566, true, true, RoomStatus.RESERVED);
        Room r27 = new Room("0406",RoomType.VIP, "Single",802, true, true, RoomStatus.OCCUPIED);
        Room r28 = new Room("0407",RoomType.DELUXE, "Double",486, true, false, RoomStatus.VACANT);

        Room r29 = new Room("0501",RoomType.DELUXE, "Single",426, false, false, RoomStatus.RESERVED);
        Room r30 = new Room("0502",RoomType.SINGLE, "Double",226, false, true, RoomStatus.OCCUPIED);
        Room r31 = new Room("0503",RoomType.DOUBLE, "Single",276, false, true, RoomStatus.OCCUPIED);
        Room r32 = new Room("0504",RoomType.SUITE, "Single",526, true, true, RoomStatus.VACANT);
        Room r33 = new Room("0505",RoomType.DELUXE, "Single",426, true, true, RoomStatus.MAINTENANCE);
        Room r34 = new Room("0506",RoomType.DELUXE, "Double",486, false, true, RoomStatus.RESERVED);
        Room r35 = new Room("0507",RoomType.VIP, "Double",862, true, false, RoomStatus.VACANT);

        Room r36 = new Room("0601",RoomType.DOUBLE, "Double",316, true, true, RoomStatus.OCCUPIED);
        Room r37 = new Room("0602",RoomType.SUITE, "Single",526, true, false, RoomStatus.RESERVED);
        Room r38 = new Room("0603",RoomType.SINGLE, "Single",186, true, true, RoomStatus.VACANT);
        Room r39 = new Room("0604",RoomType.DELUXE, "Double",486, false, false, RoomStatus.VACANT);
        Room r40 = new Room("0605",RoomType.DELUXE, "Single",426, false, true, RoomStatus.OCCUPIED);
        Room r41 = new Room("0606",RoomType.SINGLE, "Double",226, true, true, RoomStatus.MAINTENANCE);
        Room r42 = new Room("0607",RoomType.VIP, "Single",802, true, false, RoomStatus.RESERVED);

        Room r43 = new Room("0701",RoomType.DELUXE, "Single",426, true, false, RoomStatus.VACANT);
        Room r44 = new Room("0702",RoomType.DOUBLE, "Double",316, true, false, RoomStatus.VACANT);
        Room r45 = new Room("0703",RoomType.SUITE, "Double",566, true, true, RoomStatus.RESERVED);
        Room r46 = new Room("0704",RoomType.SINGLE, "Single",186, false, false, RoomStatus.OCCUPIED);
        Room r47 = new Room("0705",RoomType.VIP, "Double",862, true, true, RoomStatus.MAINTENANCE);
        Room r48 = new Room("0706",RoomType.SUITE, "Single",526, false, true, RoomStatus.MAINTENANCE);
        Room r49 = new Room("0707",RoomType.DOUBLE, "Single",274, true, true, RoomStatus.OCCUPIED);


        rooms.add(r1);
        rooms.add(r2);
        rooms.add(r3);
        rooms.add(r4);
        rooms.add(r5);
        rooms.add(r6);
        rooms.add(r7);

        rooms.add(r8);
        rooms.add(r9);
        rooms.add(r10);
        rooms.add(r11);
        rooms.add(r12);
        rooms.add(r13);
        rooms.add(r14);

        rooms.add(r15);
        rooms.add(r16);
        rooms.add(r17);
        rooms.add(r18);
        rooms.add(r19);
        rooms.add(r20);
        rooms.add(r21);

        rooms.add(r22);
        rooms.add(r23);
        rooms.add(r24);
        rooms.add(r25);
        rooms.add(r26);
        rooms.add(r27);
        rooms.add(r28);

        rooms.add(r29);
        rooms.add(r30);
        rooms.add(r31);
        rooms.add(r32);
        rooms.add(r33);
        rooms.add(r34);
        rooms.add(r35);

        rooms.add(r36);
        rooms.add(r37);
        rooms.add(r38);
        rooms.add(r39);
        rooms.add(r40);
        rooms.add(r41);
        rooms.add(r42);

        rooms.add(r43);
        rooms.add(r44);
        rooms.add(r45);
        rooms.add(r46);
        rooms.add(r47);
        rooms.add(r48);
        rooms.add(r49);


        database.writeSerializedObject("Rooms",rooms);

    }
}
