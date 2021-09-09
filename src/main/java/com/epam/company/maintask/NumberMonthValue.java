package com.epam.company.maintask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import java.text.DateFormatSymbols;

public class NumberMonthValue {
    private static Logger log = LogManager.getLogger(NumberMonthValue.class);

    public static void setNumberMonthValue() throws IllegalArgumentException {
        log.info("Select month");
        Scanner monthNamber = new Scanner(System.in);
        if (!monthNamber.hasNextInt()) {
            throw new IllegalArgumentException("Incorrect value");
        }
        log.info(getMonth(monthNamber.nextInt()));
    }

    public static String getMonth(int numberOfMonth) {
        if (!correctMonth(numberOfMonth)) {
            throw new IllegalArgumentException("Incorrect month number");
        }
        return new DateFormatSymbols().getMonths()[numberOfMonth - 1];
    }

    public static boolean correctMonth(int numberOfMonth) {
        if (numberOfMonth >=1 && numberOfMonth <= 12){
            return true;
        }
        else {
            return false;
        }
    }
}
