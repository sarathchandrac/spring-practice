package com.training.basics;

import com.training.basics.Threading.DataAggregator;
import com.training.basics.Threading.EmailCampaign;
import com.training.basics.Threading.Task;

import java.util.concurrent.TimeUnit;

public class TestPriority {

    public static void main(String[] args) {
	// write your code here
        System.out.println(Thread.currentThread());

        Thread t1 = new Thread(new EmailCampaign());
        Thread t2 = new Thread(new DataAggregator());
        t1.setName("EmailCampaign");
        t2.setName("DataAggregator");
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
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
