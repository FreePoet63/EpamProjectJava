package com.epam.company.maintask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class SumProductOfNumbers {
    private static Logger log = LogManager.getLogger(SumProductOfNumbers.class);

    public static void setNumbersOfSumProduct() {
        log.info("Set numbers, and click ENTER");
        Scanner number = new Scanner(System.in);
        int numberOne = number.nextInt();
        int numberTwo = number.nextInt();
        log.info("Sum =" + (numberOne + numberTwo));
        log.info("Multi =" + (numberOne * numberTwo));
    }
}