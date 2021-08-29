package com.pawlukowicz;

public class BubbleSort implements Strategy {
    private int []arrayToSort;
    private int arraySizeIterator;
    private double[][] dataSort;

    public BubbleSort(int[] arrayToSort, int numberOfTimeMeasurement) {
        this.arrayToSort = arrayToSort;
        this.arraySizeIterator = 0;
        this.dataSort = new double[2][numberOfTimeMeasurement];
        this.dataSort[0][arraySizeIterator] = arrayToSort.length;
    }

    @Override
    public double[][] getData() {
        return this.dataSort;
    }

    @Override
    public void addTimeToDataset(double measuredTime) {
        this.dataSort[0][arraySizeIterator] = arrayToSort.length;
        this.dataSort[1][arraySizeIterator] = measuredTime;
    }

    @Override
    public void setArray(int[] arrayToSort) {
        this.arrayToSort = arrayToSort;
        this.arraySizeIterator++;
    }

    @Override
    public void sortArray() {
        //System.out.println("Bubblesort");
        //printArray();

        int arrayLength = arrayToSort.length;
        for (int i = 0; i < arrayLength-1; i++) {
            for (int j = 0; j < arrayLength - i - 1; j++) {
                if (arrayToSort[j] > arrayToSort[j + 1]) {
                    int temp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = temp;
                }
            }
        }
       // System.out.println("Sorted array: ");
       // printArray();
    }

    private void printArray(){
        for (int i = 0 ; i < arrayToSort.length ; i++) {
            System.out.print(arrayToSort[i] + " ");
        }
        System.out.println();
    }

}
