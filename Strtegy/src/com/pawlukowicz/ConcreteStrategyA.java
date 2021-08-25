package com.pawlukowicz;

public class ConcreteStrategyA implements Strategy {

    @Override
    public void sort(){
        System.out.println("sortowanie strategia A");
    }
}
