package exchanger;

import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String [] args) {
        Exchanger<String> exe = new Exchanger<>();
        new Thread(new PutThread(exe)).start();
        new Thread(new GetThread(exe)).start();
    }
}
