package com.pawlukowicz;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void measureSortTime() {
        double start = System.currentTimeMillis();
        strategy.sortArray();
        double end = System.currentTimeMillis();
        System.out.println("Elapsed Time in mili seconds: "+ (end-start));
        strategy.addTimeToDataset(end-start);
    }
}
