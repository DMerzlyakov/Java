package com.sem;

public class NewThread2 implements Runnable{
    private boolean isActive;

    public void disable() {
        isActive = false;
    }
    NewThread2() {
        isActive = true;
    }
    @Override
    public void run() {
        System.out.printf("%s started", Thread.currentThread().getName());

        try {
            Thread.sleep(200);
        }
        catch (InterruptedException e ) {
            System.out.printf("Thread is interrupted");
        }
        System.out.printf("Thread %s is finished", Thread.currentThread().getName());
    }



}
