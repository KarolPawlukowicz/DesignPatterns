package com.pawlukowicz;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static int minValueOfRandomNumber = 0;
    public static int maxValueOfRandomNumber = 10;

    private static void fillArrayWithRandomNumbers(int []array){
        for(int i = 0 ; i < array.length ; i++){
            array[i] = ThreadLocalRandom.current().nextInt(minValueOfRandomNumber, maxValueOfRandomNumber + 1);
        }
    }

    public static void main(String[] args) {
        int arraySize = 1000;
        int []array = new int[arraySize];

        fillArrayWithRandomNumbers(array);

        Strategy bubbleSort = new BubbleSort(array);
        Strategy quickSort = new QuickSort(array);
        Strategy selectionSort = new SelectionSort(array);

        Context context = new Context(bubbleSort);
        context.measureSortTime();


        fillArrayWithRandomNumbers(array);
        context.setStrategy(quickSort);
        context.measureSortTime();


        fillArrayWithRandomNumbers(array);
        context.setStrategy(selectionSort);
        context.measureSortTime();
    }
}
