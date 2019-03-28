package Thread;

import com.sun.jmx.snmp.tasks.ThreadService;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class demo {
    public static void main(String[] args) {
        ExecutorService threadPoll = Executors.newFixedThreadPool(3);
        MyThread m = new MyThread();
        new Thread(m).start();
        new Thread(m).start();
    }
}

class MyThread implements Runnable {
    private int a = 100;
    @Override
    public void run() {
        while (true) {
            if (a > 0) {
                a--;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                System.out.println(a);
            }
        }
    }
}