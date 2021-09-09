package com.epam.company.maintask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class ReverseDate {
    private static Logger log = LogManager.getLogger(ReverseDate.class);

    public static void setReverseDateConsole() {
        log.info("Reverse argument");
        Scanner newDate = new Scanner(System.in);
        StringBuffer setDate = new StringBuffer(newDate.nextLine());
        setDate.reverse();
        log.info("Reverse Date: " + setDate.toString());
    }
}
