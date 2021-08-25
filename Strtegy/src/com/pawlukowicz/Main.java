package com.pawlukowicz;

public class Main {

    public static void main(String[] args) {
        Strategy strategyA = new ConcreteStrategyA();
        Strategy strategyB = new ConcreteStrategyB();

        Context context = new Context(strategyA);

        context.doSomething();

        context.setStrategy(strategyB);

        context.doSomething();
    }
}
