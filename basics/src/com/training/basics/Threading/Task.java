package com.training.basics.Threading;

public class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("inside Run");
        go();
    }

    private void go() {
        System.out.println("inside Go method");
        more();
    }
    private void more() {
        System.out.println("inside More method");
    }
}
