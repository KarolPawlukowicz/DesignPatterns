package com.pawlukowicz;

public interface Strategy {
    public void sortArray();
    public void setArray(int[] array);
    public void addTimeToDataset(double measuredTime);
    public double[][] getData();
}
