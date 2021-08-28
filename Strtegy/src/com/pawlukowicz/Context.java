package com.pawlukowicz;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public long measureSortTime() {
        long start = System.nanoTime();
        strategy.sortArray();
        long end = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: "+ (end-start));
        return end-start;
    }
}
