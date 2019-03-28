package Thread;

public class Demo1 {

    public static void main(String[] args) {
        TicketWindow tw = new TicketWindow();
        for (int i = 1; i < 4; i++) {
            Thread t = new Thread(tw, "TickWindow-" + i);
            t.start();
        }
    }
}

class TicketWindow implements Runnable {
    private int tickets = 100;//车票总量

    @Override
    public void run() {
        while (true) {
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + "准备出票,剩余票数:" + tickets + "张");
                tickets--;
                System.out.println(Thread.currentThread().getName() + "卖出一张,剩余票数:" + tickets + "张");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + "余票不足,停止售票!");
                break;
            }
        }
    }

}