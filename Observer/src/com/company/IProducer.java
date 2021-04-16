package com.company;

public interface IProducer {
    void subscribe(IObserver observer);
    void unsubscribe(IObserver observer);
    void notifyObservers();
}
