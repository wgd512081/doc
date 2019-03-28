package Thread01;

public class MultyThreadShareDateTest {
        public static void main(String[] args){
            ShareData shareData = new ShareData();
            for(int i=1;i<=2;i++){
                new Thread(new MyIncreRunnable(shareData)).start();
                new Thread(new MyDecreRunanble(shareData)).start();
            }
        }
    }

    class MyIncreRunnable implements Runnable{
        private ShareData shareData;
        public MyIncreRunnable(ShareData shareData) {
            this.shareData = shareData;
        }
        @Override
        public void run() {
            for (int i = 1;i<=10;i++){
                shareData.increment();
            }
        }
    }

    class MyDecreRunanble implements Runnable{
        private ShareData shareData;
        public MyDecreRunanble(ShareData shareData) {
            this.shareData = shareData;
        }
        @Override
        public void run() {
            for(int i=1;i<=10;i++){
                shareData.decrement();
            }
        }
    }
    // 共享数据，对共享数据的操作也在这个对象中完成
    class ShareData{
        private int count = 0;
        public synchronized void increment(){
            count++;
            System.out.println(Thread.currentThread().getName()+" inc "+count);
        }
        public synchronized void decrement(){
            count--;
            System.out.println(Thread.currentThread().getName()+" dec " +count);
        }
    }

