package com.epam.company.optional1task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class NumbersAndLength {
    private static Logger log = LogManager.getLogger(NumbersAndLength.class);

    public static void setNumberLength() {
        log.info("Enter numbers and click ENTER: ");
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        double count = 0;
        String[] arr = line.split(" ");
        for (String str : arr) {
            count += str.length();
        }
        if (arr.length > 0)
            count /= arr.length;
        System.out.printf("Average length of entered numbers: %.2f", count);
        System.out.println("\nNumbers with length greater than average:");
        for (String s : arr) {
            if (s.length() > count)
                System.out.println(s + " Length: " + s.length());
        }
        System.out.println("Numbers with less than average length:");
        for (String s : arr) {
            if (s.length() < count)
                System.out.println(s + " Length: " + s.length());
        }
    }
}
