package com.epam.company.optional2task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MaxElementMatrixsAndDeleteAllItems {
    private static Logger log = LogManager.getLogger(MaxElementMatrixsAndDeleteAllItems.class);
    private static int number;
    private static int newNumber;

    public static void getMaxElementMatrixsAndDeleteAllItems() {
        log.info("Start operation");
        Scanner scanValue = new Scanner(System.in);
        try {
            number = Integer.valueOf(scanValue.nextLine());
        } catch (NumberFormatException e) {
            return;
        }
        try {
            newNumber = Integer.valueOf(scanValue.nextLine());
        } catch (NumberFormatException e) {
            return;
        }
        int[][] arr = new int[number][number];
        Random random = new Random();
        int max = -newNumber;

        ArrayList<Integer> rows = new ArrayList<Integer>();
        ArrayList<Integer> column = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.ints(number, -newNumber, newNumber).toArray();
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if (max == arr[i][j]) {
                    if (rows.indexOf(j) == -1)
                        rows.add(j);
                    if (column.indexOf(i) == -1)
                        column.add(i);
                }
            }
        }
        System.out.println("\nMax: " + max);
        int[][] newArr = new int[number - rows.size()][number - column.size()];
        System.out.println("Size: " + (number - rows.size()) + "x" + (number - column.size()));
        int newArrI = 0;
        int newArrJ = 0;
        for (int i = 0; i < number; i++) {
            if (rows.indexOf(i) == -1) {
                newArrJ = 0;
                for (int j = 0; j < number; j++) {
                    if (column.indexOf(j) == -1) {
                        newArr[newArrI][newArrJ]
                                = arr[j][i];
                        newArrJ++;
                    }
                }
                newArrI++;
            }
        }
        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr[i].length; j++) {
                System.out.println();
                System.out.print(newArr[i][j] + " ");
            }
        }
    }
}
