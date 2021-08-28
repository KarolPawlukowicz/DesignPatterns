package com.pawlukowicz;

public class SelectionSort implements Strategy {
    private int []array;

    public SelectionSort(int[] array) {
        this.array = array;
    }

    @Override
    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public void sortArray() {
        System.out.println("InsertionSort");
        //printArray();

        int arrayLength = array.length;
        for (int i = 0 ; i < arrayLength - 1 ; i++) {
            int minimumElementInArray = i;
            for (int j = i + 1 ; j < arrayLength ; j++) {
                if (array[j] < array[minimumElementInArray]) {
                    minimumElementInArray = j;
                }
            }
            swapElementsOfArray(minimumElementInArray, i);
        }

        //System.out.println("Sorted array: ");
        //printArray();
    }

    private void swapElementsOfArray(int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private void printArray(){
        for (int i = 0 ; i < array.length ; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
