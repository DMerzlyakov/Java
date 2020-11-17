package task_3;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Semaphore sem = new Semaphore(2);
        for(int i=1;i<6;i++)
            new Philosopher(sem,i).start();
    }
}
class Philosopher extends Thread
{
    Semaphore sem;
    int num = 0;
    int id;
    Philosopher(Semaphore sem, int id)
    {
        this.sem=sem;
        this.id=id;
    }

    public void run()
    {
        try
        {
            while(num<3)
            {
                sem.acquire();
                System.out.println ("Философ " + id+" сел");
                sleep(500);
                num++;

                System.out.println ("Философ " + id+" встал");
                sem.release();

                sleep(500);
            }
        }
        catch(InterruptedException e)
        { }
    }
}