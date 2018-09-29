package Thread01;

public class TranditionlaThreadDemo {
    public static void main(String[] args) {
        new TranditionlaThreadDemo().init();
    }

    public void init() {
        final Business business = new Business();
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int j = 1; j < 50; j++) {
                            business.sub(j);
                        }
                    }
                }
        ).start();

        for (int j = 1; j < 50; j++) {
            business.main(j);
        }
    }

    class Business {
        private boolean flag = true;

        public synchronized void sub(int j) {
            while (!flag) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println("subThread:wuguodong!" + i + "loop of" + j);
            }
            flag = false;
            this.notify();
        }

        public synchronized void main(int j) {
            while (flag) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 1; i <= 100; i++) {
                System.out.println("main Thread:wuguodong!" + i + "loop of" + j);
            }
            flag = true;
            this.notify();
        }
    }

}

