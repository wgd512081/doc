package Thread;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Maintest {
    public static void main(String[] args) throws IOException {
        int a = 1;
        int b = 2;
        StringBuffer c = new StringBuffer("ads");
        StringBuffer d = new StringBuffer("ads");
        change(a, b);
        changes(c, d);
        System.out.println(a + "," + b);
        System.out.print(c + "," + d);


    }

    public static void change(int a, int b) {
        a = 4;
        b = b + 5;
    }

    public static void changes(StringBuffer a, StringBuffer b) {
        a = a.append("123");
        b = new StringBuffer("123");
    }
}