package com.epam.company.optional1task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class NumbersMinimumNumberDifferentDigits {
    private static Logger log = LogManager.getLogger(NumbersMinimumNumberDifferentDigits.class);

    public static void displayNamberDifferentDigits() {
       Scanner scanner = new Scanner(System.in);
       log.info("Array startDimension: ");
       int[] array = new int[scanner.nextInt()];
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Elem %d: ", i);
            array[i] = scanner.nextInt();
        }
        System.out.println("\n" + Arrays.toString(array));
        colculationNumber(array);
        System.out.println();
    }

    private static void colculationNumber(int[] arr) {
        int min = differentNumber(arr[0]);
        int minElem = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (differentNumber(arr[i]) < min) {
                min = differentNumber(arr[i]);
                minElem = arr[i];
            }
        }
        System.out.printf("Elem: %d", minElem);
    }

    private static int differentNumber(int x) {
        HashSet<Integer> nums = new HashSet<>();
        while (x > 0) {
            nums.add(x % 10);
            x /= 10;
        }
        return nums.size();
    }
}
