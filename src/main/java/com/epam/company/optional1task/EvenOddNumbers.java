package com.epam.company.optional1task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class EvenOddNumbers {
    private static Logger log = LogManager.getLogger(EvenOddNumbers.class);
    private static int n;
    private static int evenDigits = 0;
    private static int oddDigits = 0;
    private static int evenNumbers = 0;
    private static int oddNumbers = 0;

    public static void setEvenOddDigits() {
        log.info("Enter n:");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[] arrayNumbers = new int[n];
        for (int s = 0; s < n; s++) {
            System.out.printf("Elem %d: ", s);;
            arrayNumbers[s] = sc.nextInt();
            ArrayList<Integer> listSimbols = new ArrayList<>();
            while (arrayNumbers[s] != 0) {
                listSimbols.add(arrayNumbers[s] % 10);
                arrayNumbers[s] /= 10;
            }
            for (int i = 0; i < listSimbols.size(); i++) {
                if (listSimbols.get(i) % 2 == 0) {
                    evenDigits++;
                } else{
                    oddDigits++;
                }
            }
            if (evenDigits == listSimbols.size()){
                evenNumbers++;
            } else if (evenDigits == oddDigits){
                oddNumbers++;
            }
            evenDigits = 0;
            oddDigits = 0;
        }
        System.out.println("Numbers consisting of even numbers only : " + evenNumbers +
                "\nAnd numbers where the number of even and odd numbers are : " + oddNumbers);
    }
}

