package _test;

import java.util.Arrays;

public class test {
    static public int X = 2;

    static {
        X = 1;
    }

    static public void method() {
        X = 5;
    }

    public static void main(String[] args) {
        test o = new test();
        test.method();
        test.X = 10;
        System.out.printf("x=%d, y=%d", o.X, test.X);
    }
}
