package com.company;

public class User implements IObserver {

    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public void update(String message) {
        System.out.println("Im sending an email to " + name + " at " + email + " with message: " + message);
    }
}
