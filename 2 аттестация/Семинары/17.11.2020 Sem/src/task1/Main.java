package task1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread thread = new Thread()
        {
            @Override
            public void run(){
                System.out.println(getState());
                try {
                    synchronized (lock){
                        lock.notifyAll();
                        lock.wait(3000);
                    }
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        synchronized (lock) {
            System.out.println(thread.getState());
            thread.start();
            lock.wait();
            System.out.println(thread.getState());
            lock.notifyAll();
            System.out.println(thread.getState());
        }
    }
}
