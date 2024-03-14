package org.example.presentation;

import org.example.dao.VictimDAO;
import org.example.model.VictimPojo;

import java.util.List;
import java.util.Scanner;

public class Presentation {
    public static VictimDAO display;
    static Scanner scan;

    static {
        scan = new Scanner(System.in);
    }
    static public int displayMenu() {

        System.out.println("***********************************");
        System.out.println("VICTIM MANAGEMENT SYSTEM");
        System.out.println("***********************************");
        System.out.println("MENU");
        System.out.println("***********************************");
        System.out.println("1. Fetch all victims");
        System.out.println("2. Fetch victim by age");
        System.out.println("3. Fetch victim  by status");
        System.out.println("4. Add a Victim");
        System.out.println("5. Update a Victim");
        System.out.println("6. Remove a Victim");
        System.out.println("7. Exit");
        System.out.println("***********************************");
        System.out.println("Enter the menu option:");
        int option = scan.nextInt();
        return option;
    }
    public static void displayAllVictims(List<VictimPojo> victimsList) {
        System.out.println("*******************************************************************************************************");
        System.out.println("*******************************************************************************************************");
        for(VictimPojo victim: victimsList) {
            System.out.println(victim);
        }
    }
    public static void displayVictim(VictimPojo victimsList) {
        System.out.println("*******************************************************************************************************");
        System.out.println("*******************************************************************************************************");
            System.out.println(victimsList);
    }
    public static void displayExitMessage() {
        System.out.println("***********************************");
        System.out.println("Thankyou for using DBM");
        System.out.println("***********************************");
    }
    public static void displayInvalidOptionMessage() {
        System.out.println("***********************************");
        System.out.println("Thankyou for using DBM");
        System.out.println("***********************************");
    }

    public static int scanAge() {
        System.out.println("Enter victim age:");
        int victimId = scan.nextInt();
        return victimId;
    }
    public static boolean scanStatus() {
        System.out.println("Enter victim status:");
        boolean status = scan.nextBoolean();
        return status;
    }
    public static int scanId() {
        System.out.println("Enter victim id:");
        int id = scan.nextInt();
        return id;
    }
    public static VictimPojo addVictim() {
        System.out.println("Enter victim age:");
        int age = scan.nextInt();
        System.out.println("Enter victim name:");
        String name = scan.next();
        System.out.println("Enter victim Status:");
        boolean status = scan.nextBoolean();
        System.out.println("Enter victim breed:");
        String breed = scan.next();
        System.out.println("Enter victim address:");
        String address = scan.next();
       VictimPojo victimPojo = new VictimPojo(name,age,breed,status,address);
        return victimPojo;
    }

    public static void disPlayVictim(VictimPojo victimPojo1) {
        System.out.println(victimPojo1);
    }

}
