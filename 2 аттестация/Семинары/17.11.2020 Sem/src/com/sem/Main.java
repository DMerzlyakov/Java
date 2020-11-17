package com.sem;

public class Main {

    public static void main(String[] args) {
//	    Thread t = Thread.currentThread();
//        System.out.println(t.getName());
//        System.out.println(t.getPriority()); //setPriority
//        t.isAlive(); //True и False
//        t.run(); //Точка входа в потом
//        t.sleep(100); //Останавливает на 100 мс
//        t.start();
        System.out.println("main thread started");
//        for (int i = 0; i<10; i++)
//            new NewThread("Thread"+i).start();
//        NewThread2 nt = new NewThread2();
//        Thread t = new Thread(nt, "Thread1");
//        t.start();
//        try{
//            Thread.sleep(1100);
//            nt.disable();
//            Thread
//        }catch (InterruptedException e) {
//            System.out.printf("Thread is interrupted");
//        }


//        NewThread nt = new NewThread( "Thread1");
//        nt.start();
//        try{
//            Thread.sleep(200);
//            nt.interrupt();
//            Thread.sleep(200);
//        }catch (InterruptedException e) {
//            System.out.printf("Thread is interrupted");
//        }


        CommonResurce comonResurce = new CommonResurce();
        for (int i = 0; i <5; i++){
            Thread t = new Thread(new CountThread(comonResurce), "thread"+i);
            t.start();
        }
        System.out.println("Main thread finished");

    }

}
