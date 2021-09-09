package com.epam.company.maintask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.Scanner;

public class RandomNumbers {
    private static Logger log = LogManager.getLogger(RandomNumbers.class);
    private static int number;
    private static int[] myArray;
    private static Scanner setArray = new Scanner(System.in);
    private static Random random = new Random();

    public static void setRandomNumber() {
        setNumber();
        setMyArray(getNumber());
        showMyArray();
        showLnMyArray();
    }

    public static void setNumber() {
        log.info("Enter the number of random numbers: ");
        number = setArray.nextInt();
    }

    public static int getNumber(){
        return number;
    }

    public static void setMyArray(int number){
        myArray = new int[number];
        for (int i = 0; i<number; i++){
            myArray[i] = random.nextInt(10);
        }
    }

    public static void showMyArray(){
        log.info("Random Number Array without Changing Line: ");
        for (int i = 0; i<myArray.length; i++){
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
    }

    public static void showLnMyArray(){
        log.info("Random Number Array with Change to New String: ");
        for (int i = 0; i<myArray.length; i++){
            System.out.println(myArray[i]);
        }
    }
}


