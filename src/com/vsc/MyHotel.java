package com.vsc;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class MyHotel {

    public static boolean mainMenu = true;
    public static boolean subMenu = true;

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Room[] myHotel = new Room[10];
        myHotel[0] = new Room();
        myHotel[1] = new Room();
        myHotel[2] = new Room();
        myHotel[3] = new Room();
        myHotel[4] = new Room();
        myHotel[5] = new Room();
        myHotel[6] = new Room();
        myHotel[7] = new Room();
        myHotel[8] = new Room();
        myHotel[9] = new Room();

        int roomNum = 0;
        initialise(myHotel);
        while (mainMenu) {
            while (subMenu) {


                System.out.println("^^^^^^^^^^^^^╬ Marriott Hotel London ╬^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("Hello and Welcome to our Hotel Program\nThank you very much for choosing us!");
                System.out.println("☺☺☺☺☺☺☺☺☺ ☺☺☺☺☺☺☺☺☺ ☺☺☺☺☺☺☺☺ ☺☺☺☺☺☺☺ ☺☺☺☺☺☺☺☺☺ ☺☺☺☺☺☺ ☺☺☺☺☺☺☺☺☺☺☺");
                System.out.println("Please select one of the options:");
                System.out.println("A: Please Make Your Reservation!.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("B: List of Available Rooms.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("C: Information for all Rooms.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("D: Deregistering a Client from a Room.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("E: Find room from customer name.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("F: View rooms Ordered alphabetically by name.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("♥♠♣♥☺♠♥☺♥♠♣♥☺♠♥☺♥♠♣♥☺♠♥☺♥♠♣♥☺♠♥☺♥♠♣♥☺♠♥☺♥♠♣♥☺♠♥☺");
                System.out.println("================================================");
                System.out.println("Please insert your option here:");
                String Selection = input.next();
                Selection = Selection.toUpperCase();
                switch (Selection) {
                    case "A":
                        bookARoom(myHotel, roomNum);
                        break;
                    case "B":
                        checkIfEmpty(myHotel);
                        break;
                    case "C":
                        viewAllRooms(myHotel);
                        break;
                    case "D":
                        deleteCustomerFromRoom(myHotel, roomNum);
                        break;
                    case "E":
                        findRoomFromCustomerName(myHotel);
                        break;
                    case "F":
                        viewRoomsOrderedAlphabeticallyByName(myHotel);
                        break;
                    default:
                        System.out.println("Invalid Selection");
                        break;
                }
                System.out.println("================================================");
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("Would you like to Select another Option\n1 ) Yes\n2 ) No");
                System.out.println("˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅˅");
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("Please put your option below:");
                if (input.nextInt() == 1) {
                    subMenu = true;
                } else {
                    subMenu = false;
                }
            }
            subMenu = true;
            System.out.println("ᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥ");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("Would You Like To Continue With The Program\n1 ) Yes\n2 ) No");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("ᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥᴥ");
            System.out.println("Please put your option below:");
            if (input.nextInt() == 1) {
                mainMenu = true;
            } else {
                System.out.println("Thanks for registration!");
                System.exit(0);

            }
        }

    }


    public static void initialise(Room[] myHotel) {
        for (int x = 0; x < myHotel.length; x++) {
            myHotel[x].setName("nobody");
        }
    }

    public static void checkIfEmpty(Room[] myHotel) {
        for (int x = 0; x < myHotel.length; x++) {
            if (myHotel[x].getName().equals("nobody")) {
                System.out.println("Room " + (x + 1) + " is Empty");
            }
        }
    }

    public static void bookARoom(Room[] myHotel, int roomNum) {

        int roomDate;
        String roomName;
        int days;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter room number (1-10):");
        roomNum = input.nextInt() - 1;
        System.out.println("Enter name for room " + (roomNum + 1) + " :");
        roomName = input.next();
        System.out.println("Amount persons?:");
        int persons = input.nextInt();
        System.out.println("How many days is the reservation?:");
        days = input.nextInt();
        System.out.println("Days included Breakfast?:");
        int meals = input.nextInt();

        if (persons > 1) {
            System.out.println("Double room for: " + persons + " " + "persons");
        } else
            System.out.println("Single room for: " + persons + " " + "person");

        if (meals > 1) {
            int priceForStay = days * (persons * 9500);
            System.out.println("Price for staying: " + priceForStay / 100 + "€");
        } else if (meals < 1) {
            int priceForStay = days * (persons * 8000);
            System.out.println("Price for staying: " + priceForStay / 100 + "€");
        } else
            System.out.println(" ");
        System.out.println("Room number:" + (roomNum + 1));
        System.out.println("Accommodated  name to:" + roomName);
        System.out.println("Number of customers:" + persons);
        System.out.println("Number of days:" + days);
        myHotel[roomNum].setName(roomName);


    }

    public static void viewAllRooms(Room[] myHotel) {
        for (int x = 0; x < myHotel.length; x++) {
            System.out.println("Room " + (x + 1) + " Occupied by " + myHotel[x].getName());

        }
    }

    public static void deleteCustomerFromRoom(Room[] myHotel, int roomNum) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter room number to delete(1-10):");
        roomNum = input.nextInt() - 1;
        myHotel[roomNum].setName("nobody");
        System.out.println("Entery Deleted :)");
    }

    public static void findRoomFromCustomerName(Room[] myHotel) {
        Scanner input = new Scanner(System.in);
        String roomName;
        System.out.println("Enter name to Search for:");
        roomName = input.next();
        int x;
        boolean Checker = false;
        for (x = 0; x < myHotel.length; x++) {
            if (roomName.equals(myHotel[x].getName())) {
                System.out.println("The Account That Matches That name is in Room number " + (x + 1));
                Checker = true;
            }
        }
        if (Checker == false) {
            System.out.println("There are no Rooms Booked with that name\n(make sure you've used the correct CAP's)");
        }
    }

    public static void viewRoomsOrderedAlphabeticallyByName(Room[] myHotel) {

        String[] myStrArray = new String[myHotel.length];

        for (int i = 0; i < myHotel.length; i++) myStrArray[i] = myHotel[1].getName();

        Arrays.sort(myStrArray, String.CASE_INSENSITIVE_ORDER);
        for (int a = 0; a < myStrArray.length; a++) {
            System.out.println(myStrArray[a]);

        }

    }

    private static class Room {


        public String mainName;
        int guestsInRoom;

        public Room(String s) {
            mainName = "k";

        }

        public Room() {

        }

        public void setName(String aName) {

            mainName = aName;
        }

        public String getName() {
            return mainName;
        }


    }

}
