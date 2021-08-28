package com.pawlukowicz;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class Main {
    public static int minValueOfRandomNumber = 0;
    public static int maxValueOfRandomNumber = 100;

    private static void fillArrayWithRandomNumbers(int []array){
        for(int i = 0 ; i < array.length ; i++){
            array[i] = ThreadLocalRandom.current().nextInt(minValueOfRandomNumber, maxValueOfRandomNumber + 1);
        }
    }

    public static void main(String[] args) {
        Chart chart = new Chart();

        double[][] dataBubbleSort = { {5000, 10000, 15000}, {1, 2, 3} };
        double[][] dataInsertionSort = { {5000, 10000, 15000}, {1, 2, 3} };
        double[][] dataQuickSort = { {5000, 10000, 15000}, {1, 2, 3} };

        int arraySize = 5000;
        int []array = new int[arraySize];

        int arraySize2 = 10000;
        int []array2 = new int[arraySize2];

        int arraySize3 = 15000;
        int []array3 = new int[arraySize3];

        // Bubble sort
        fillArrayWithRandomNumbers(array);
        fillArrayWithRandomNumbers(array2);
        fillArrayWithRandomNumbers(array3);

        Strategy bubbleSort = new BubbleSort(array);

        Context context = new Context(bubbleSort);
        dataBubbleSort[1][0] = context.measureSortTime();

        bubbleSort.setArray(array2);
        dataBubbleSort[1][1] = context.measureSortTime();

        bubbleSort.setArray(array3);
        dataBubbleSort[1][2] = context.measureSortTime();

        chart.addDataset("BubbleSort", dataBubbleSort);


        // Selection sort
        fillArrayWithRandomNumbers(array);
        fillArrayWithRandomNumbers(array2);
        fillArrayWithRandomNumbers(array3);

        Strategy selectionSort = new SelectionSort(array);
        context = new Context(selectionSort);
        dataInsertionSort[1][0] = context.measureSortTime();

        selectionSort.setArray(array2);
        dataInsertionSort[1][1] = context.measureSortTime();

        selectionSort.setArray(array3);
        dataInsertionSort[1][2] = context.measureSortTime();

        chart.addDataset("SelectionSort", dataInsertionSort);


        // Selection sort
        fillArrayWithRandomNumbers(array);
        fillArrayWithRandomNumbers(array2);
        fillArrayWithRandomNumbers(array3);

        Strategy quickSort = new QuickSort(array);
        context = new Context(quickSort);
        dataQuickSort[1][0] = context.measureSortTime();

        quickSort.setArray(array2);
        dataQuickSort[1][1] = context.measureSortTime();

        quickSort.setArray(array3);
        dataQuickSort[1][2] = context.measureSortTime();

        chart.addDataset("QuickSort", dataQuickSort);


        chart.createChart();
    }
}
