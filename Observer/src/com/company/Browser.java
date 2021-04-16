package com.company;

public class Browser implements IObserver {
    private String browserName;

    public Browser(String browserName) {
        this.browserName = browserName;
    }

    @Override
    public void update(String message) {
        System.out.println("Im sending a message: " + message + " to " + browserName);
    }
}
