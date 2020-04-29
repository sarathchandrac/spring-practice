package com.training.basics.Threading;

public class EmailCampaign implements Runnable{
    public EmailCampaign() {
    }

    @Override
    public void run() {
        System.out.println("Run EmailCampaign");
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
            // ready to yield
            Thread.yield();

        }
    }
}
