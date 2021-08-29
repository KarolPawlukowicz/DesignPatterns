package com.pawlukowicz;

import java.util.concurrent.ThreadLocalRandom;


public class Main {
    public static int minValueOfRandomNumber = 0;
    public static int maxValueOfRandomNumber = 1000;

    private static void fillArrayWithRandomNumbers(int []array){
        for(int i = 0 ; i < array.length ; i++){
            array[i] = ThreadLocalRandom.current().nextInt(minValueOfRandomNumber, maxValueOfRandomNumber + 1);
        }
    }

    public static void main(String[] args) {
        Chart chart = new Chart();
        int numberOfTimeMeasurement = 8;


        // bubble sort
        int arraySize = 5000;
        int valueOfIncrementArraySize = 5000;
        int []arrayToSort = new int[arraySize];
        fillArrayWithRandomNumbers(arrayToSort);
        Strategy bubbleSort = new BubbleSort(arrayToSort, numberOfTimeMeasurement);
        Context context = new Context(bubbleSort);

        for(int i = 0 ; i < numberOfTimeMeasurement ; i++) {
            context.measureSortTime();
            chart.addDataset("BubbleSort", bubbleSort.getData());

            arraySize += valueOfIncrementArraySize;
            arrayToSort = new int[arraySize];
            fillArrayWithRandomNumbers(arrayToSort);
            bubbleSort.setArray(arrayToSort);
        }

        // insertion sort
        arraySize = 5000;
        valueOfIncrementArraySize = 5000;
        arrayToSort = new int[arraySize];
        fillArrayWithRandomNumbers(arrayToSort);
        Strategy selectionSort = new SelectionSort(arrayToSort, numberOfTimeMeasurement);
        context = new Context(selectionSort);

        for(int i = 0 ; i < numberOfTimeMeasurement ; i++) {
            context.measureSortTime();
            chart.addDataset("SelectionSort", selectionSort.getData());

            arraySize += valueOfIncrementArraySize;
            arrayToSort = new int[arraySize];
            fillArrayWithRandomNumbers(arrayToSort);
            selectionSort.setArray(arrayToSort);
        }

        // quick sort
        arraySize = 5000;
        valueOfIncrementArraySize = 5000;
        arrayToSort = new int[arraySize];
        fillArrayWithRandomNumbers(arrayToSort);
        Strategy quickSort = new QuickSort(arrayToSort, numberOfTimeMeasurement);
        context = new Context(quickSort);

        for(int i = 0 ; i < numberOfTimeMeasurement ; i++) {
            context.measureSortTime();
            chart.addDataset("QuickSort", quickSort.getData());

            arraySize += valueOfIncrementArraySize;
            arrayToSort = new int[arraySize];
            fillArrayWithRandomNumbers(arrayToSort);
            quickSort.setArray(arrayToSort);
        }


        chart.createChart();
    }
}
