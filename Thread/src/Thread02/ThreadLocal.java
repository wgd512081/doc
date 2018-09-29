package Thread02;

import java.util.Random;

public class ThreadLocal {
    private static ThreadLocal x = new ThreadLocal();

    private static ThreadLocal myThreadLocalThreadLocal = new ThreadLocal();
    private static Integer data = 0;
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                int data = new Random().nextInt();
                System.out.println(Thread.currentThread().getName()+"qqqqqqq"+data);

                new A().get();
                new B().get();
            }
        }){}.start();



    }
    static class A {
        public void get (){

            System.out.println("A from " + Thread.currentThread().getName() + data);
        }
    }

    static class B{
        public void get (){
            System.out.println("B from " + Thread.currentThread().getName() + data);
        }
    }


}

class MyThreadLocal{
    private MyThreadLocal(){};
    private static MyThreadLocal instance = null;
    public static MyThreadLocal getInstance(){

        if(instance ==null){
            instance = new MyThreadLocal();
        }
        return instance;
    }

    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
