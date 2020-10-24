package com.sda.practical.handler;

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
}
