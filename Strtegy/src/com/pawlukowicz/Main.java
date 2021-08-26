package com.pawlukowicz;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static int minValueOfRandomNumber = 0;
    public static int maxValueOfRandomNumber = 10;

    private static void initializeArray(int []array){
        for(int i = 0 ; i < array.length ; i++){
            array[i] = ThreadLocalRandom.current().nextInt(minValueOfRandomNumber, maxValueOfRandomNumber + 1);
        }
    }

    public static void main(String[] args) {
        int arraySize = 10;
        int []firstArray = new int[arraySize];
        int []secondArray = new int[arraySize];

        initializeArray(firstArray);
        initializeArray(secondArray);


        Strategy bubbleSort = new BubbleSort(firstArray);
        Strategy quickSort = new QuickSort(secondArray);

        Context context = new Context(bubbleSort);
        context.doSomething();


        context.setStrategy(quickSort);
        context.doSomething();
    }
}
