package exchanger;

import java.util.concurrent.Exchanger;

public class GetThread implements Runnable {
    Exchanger<String> exchanger;

    String message;

    GetThread(Exchanger<String> ex) {
        this.exchanger = ex;
        message = "hello";
    }

    @Override
    public void run(){
        try {
            message = exchanger.exchange(message);
            System.out.println("Get " + message);
        }catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
