package com.pawlukowicz;

public class QuickSort implements Strategy {
    private int []array;
    private int startingIndex;
    private int endingIndex;

    public QuickSort(int[] array) {
        this.array = array;
        startingIndex = 0;
        endingIndex = array.length-1;
    }

    @Override
    public void sortArray() {
        System.out.println("Before Quicksort");
        printArray();
        sortArrayUsingQuickSort(startingIndex, endingIndex);

        System.out.println("Sorted array: ");
        printArray();
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

    private void swap(int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private int partition(int startingIndex, int endingIndex)
    {
        int pivot = array[endingIndex];
        int indexOfSmallerElement = startingIndex - 1;

        for(int i = startingIndex; i <= endingIndex - 1; i++) {
            if (array[i] < pivot) {
                indexOfSmallerElement++;
                swap(indexOfSmallerElement, i);
            }
        }
        swap(indexOfSmallerElement + 1, endingIndex);
        return (indexOfSmallerElement + 1);
    }

    private void printArray(){
        for (int i = 0 ; i < array.length ; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


}
