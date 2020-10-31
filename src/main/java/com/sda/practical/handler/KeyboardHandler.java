package com.sda.practical.handler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class KeyboardHandler {

    private Scanner scanner;

    public KeyboardHandler() {
        this.scanner = new Scanner(System.in);
    }

    public String readString(String label) {
        System.out.println(label);
        return scanner.nextLine();
    }

    public Date readDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date date = Calendar.getInstance().getTime();
        return date;
    }

    public Integer readInteger(String label) {
        Integer value = -1;
        boolean stare = true;
        do {
            System.out.println(label);
            if (!scanner.hasNextInt()) {
                System.out.println("That is not a number!");
                scanner.next();
            } else {
                value = scanner.nextInt();
                scanner.nextLine();
                stare = false;
            }
        } while (stare);
        return value;
    }

    public Double readDouble(String label) {
        Double value = -1.0;
        boolean stare = true;
        do {
            System.out.println(label);
            if (!scanner.hasNextDouble()) {
                System.out.println("That is not a double!");
                scanner.next();
            } else {
                value = scanner.nextDouble();
                scanner.nextLine();
                stare = false;
            }
        } while (stare);
        return value;
    }
}
