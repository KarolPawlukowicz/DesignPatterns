package com.company;

import java.util.ArrayList;
import java.util.List;

public class Blog implements IProducer {
    private List<IObserver> subscribers;
    private String message;

    public Blog() {
        subscribers = new ArrayList<>();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void subscribe(IObserver observer) {
        this.subscribers.add(observer);
    }

    @Override
    public void unsubscribe(IObserver observer) {
        this.subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver subscriber : subscribers){
            subscriber.update(this.message);
        }
    }
}
