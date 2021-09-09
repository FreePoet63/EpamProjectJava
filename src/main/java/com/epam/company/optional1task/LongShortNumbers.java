package com.epam.company.optional1task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class LongShortNumbers {
    private static Logger log = LogManager.getLogger(LongShortNumbers.class);

    public static void setLongShortNum() {
        log.info("Enter numbers: ");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        String[]arr = new String[num];
        for(int i = 0; i < num; i++){
            System.out.printf("Elem %d: ", i);
            arr[i]=scan.next();
        }
        longAndShortRealization(arr);
    }

    public static void longAndShortRealization(String[] array){
        int min = array[0].length();
        int max = 0;
        for(String val : array){
            if(val.length() > max) {
                max = val.length();
            } else if(val.length() < min) {
                min = val.length();
            }
        }
        for(int i = 0; i < array.length; i++){
            if(array[i].length() == max) {
                System.out.println("Max number is " + array[i] + " his length " + array[i].length());
            } else if(array[i].length()==min) {
                System.out.println("Min number is "+ array[i]+" his length "+ array[i].length());
            }
        }
    }
}

