package com.pawlukowicz;

public class SelectionSort implements Strategy {
    private int []arrayToSort;
    private int arraySizeIterator;
    private double[][] dataSort;

    public SelectionSort(int[] arrayToSort, int numberOfTimeMeasurement) {
        this.arrayToSort = arrayToSort;
        this.arraySizeIterator = 0;
        this.dataSort = new double[2][numberOfTimeMeasurement];
        this.dataSort[0][arraySizeIterator] = arrayToSort.length;
    }

    @Override
    public void addTimeToDataset(double measuredTime) {
        this.dataSort[0][arraySizeIterator] = arrayToSort.length;
        this.dataSort[1][arraySizeIterator] = measuredTime;
    }

    @Override
    public double[][] getData() {
        return this.dataSort;
    }

    @Override
    public void setArray(int[] arrayToSort) {
        this.arrayToSort = arrayToSort;
        this.arraySizeIterator++;
    }

    @Override
    public void sortArray() {
        //System.out.println("InsertionSort");
        //printArray();

        int arrayLength = arrayToSort.length;
        for (int i = 0 ; i < arrayLength - 1 ; i++) {
            int minimumElementInArray = i;
            for (int j = i + 1 ; j < arrayLength ; j++) {
                if (arrayToSort[j] < arrayToSort[minimumElementInArray]) {
                    minimumElementInArray = j;
                }
            }
            swapElementsOfArray(minimumElementInArray, i);
        }

        //System.out.println("Sorted array: ");
        //printArray();
    }

    private void swapElementsOfArray(int firstIndex, int secondIndex) {
        int temp = arrayToSort[firstIndex];
        arrayToSort[firstIndex] = arrayToSort[secondIndex];
        arrayToSort[secondIndex] = temp;
    }

    private void printArray(){
        for (int i = 0 ; i < arrayToSort.length ; i++) {
            System.out.print(arrayToSort[i] + " ");
        }
        System.out.println();
    }
}
