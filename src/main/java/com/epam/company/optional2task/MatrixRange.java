package com.epam.company.optional2task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MatrixRange {
    private static Logger log = LogManager.getLogger(MatrixRange.class);

    public static void setMatrixRange() {
        log.info("Enter the amount matrix:");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int array[][] = new int[size][size];
        Random(array, size);
        CalculatingTheRankMatrix(array);
    }

    public static void Random(int arr[][], int item) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[j][i] = random.nextInt(2 * item + 1) - item;
            }
        }
    }

    public static void CalculatingTheRankMatrix(int[][] newArray) {
        int[] arrayMatrix = new int[newArray.length * newArray.length];
        int count = 0;
        int arrive = 0;
        int max = 0;
        int numberIncreases = 0;
        int interrupted = 0;
        int min = 0;
        int numberDecreases = 0;
        for(int[] arrElement : newArray){
            for(int result : arrElement){
                arrayMatrix[count++] = result;
            }
        }
        for (int i = 0; i < arrayMatrix.length-1; i++){
            if(arrayMatrix[i] < arrayMatrix[i+1]){
                arrive += 1;
                if(arrive > max) {
                    max = arrive;
                    numberIncreases = i + 1;
                }
            }else{
                arrive = 0;
            }
            if(arrayMatrix[i] > arrayMatrix[i+1]){
                interrupted +=1;
                if(interrupted > min){
                    min = interrupted;
                    numberDecreases = i + 1;
                }
            } else{
                interrupted = 0;
            }
        }
        System.out.println("Maximum sequence of increasing numbers:");
        int[]increaseArray = new int[max + 1];
        System.arraycopy(arrayMatrix,(numberIncreases - max), increaseArray,0,(max+1));
        System.out.println(Arrays.toString(increaseArray)+" "+(max + 1));
        System.out.println("Maximum descending sequence:");
        int[]reduceArray = new int[min + 1];
        System.arraycopy(arrayMatrix,(numberDecreases - min), reduceArray,0,(min+1));
        System.out.println(Arrays.toString(reduceArray)+" "+(min + 1));
    }
}
