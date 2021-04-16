package com.company;

public class Main {

    public static void main(String[] args) {
        Blog blog = new Blog();

        User user1 = new User("Karol", "karol@gmail.com");
        User user2 = new User("Franek", "franek@gmail.com");

        Browser browser1 = new Browser("Mozilla");

        blog.subscribe(user1);
        blog.subscribe(user2);
        blog.subscribe(browser1);

        blog.setMessage("message1");

        blog.notifyObservers();

        System.out.println(" ------------------ ");

        blog.setMessage("message2");

        blog.notifyObservers();

        System.out.println(" ------------------ ");

        blog.unsubscribe(user2);

        blog.setMessage("message3");

        blog.notifyObservers();




    }
}
