package com.pawlukowicz;

public class QuickSort implements Strategy {
    private int []arrayToSort;
    private int arraySizeIterator;
    private double[][] dataSort;
    private int startingIndex;
    private int endingIndex;

    public QuickSort(int[] arrayToSort, int numberOfTimeMeasurement) {
        this.arrayToSort = arrayToSort;
        startingIndex = 0;
        endingIndex = arrayToSort.length-1;

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
        //System.out.println("Quicksort");
        //printArray();
        sortArrayUsingQuickSort(startingIndex, endingIndex);

        //System.out.println("Sorted array: ");
        //printArray();
    }

    private void sortArrayUsingQuickSort(int startingIndex, int endingIndex)
    {
        if (startingIndex < endingIndex)
        {
            int partitioningIndex = partition(startingIndex, endingIndex);

            sortArrayUsingQuickSort(startingIndex, partitioningIndex - 1);
            sortArrayUsingQuickSort(partitioningIndex + 1, endingIndex);
        }
    }

    private void swapElementsOfArray(int firstIndex, int secondIndex) {
        int temp = arrayToSort[firstIndex];
        arrayToSort[firstIndex] = arrayToSort[secondIndex];
        arrayToSort[secondIndex] = temp;
    }

    private int partition(int startingIndex, int endingIndex)
    {
        int pivot = arrayToSort[endingIndex];
        int indexOfSmallerElement = startingIndex - 1;

        for(int i = startingIndex; i <= endingIndex - 1; i++) {
            if (arrayToSort[i] < pivot) {
                indexOfSmallerElement++;
                swapElementsOfArray(indexOfSmallerElement, i);
            }
        }
        swapElementsOfArray(indexOfSmallerElement + 1, endingIndex);
        return (indexOfSmallerElement + 1);
    }

    private void printArray(){
        for (int i = 0 ; i < arrayToSort.length ; i++) {
            System.out.print(arrayToSort[i] + " ");
        }
        System.out.println();
    }


}
