package com.training.basics;

import com.training.basics.Threading.Task;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("hello World");
        testThreadOne();

    }

    private static void testThreadOne() {
        Task task = new Task();
        Thread thread = new Thread(task); // New State
        thread.start();
        try {
            //Thread.sleep(3000);
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Inside main ...");
    }

}
