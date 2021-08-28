package com.pawlukowicz;

public class BubbleSort implements Strategy {
    private int []array;

    public BubbleSort(int[] array) {
        this.array = array;
    }

    @Override
    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public void sortArray() {
        System.out.println("Bubblesort");
        //printArray();

        int arrayLength = array.length;
        for (int i = 0; i < arrayLength-1; i++) {
            for (int j = 0; j < arrayLength - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
       // System.out.println("Sorted array: ");
       // printArray();
    }

    private void printArray(){
        for (int i = 0 ; i < array.length ; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
