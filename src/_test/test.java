package _test;

import java.util.Arrays;

public class test {
    public static void main(String [] args)     {
        try {
            int x = 0;
            int y = 5 / x;
        }catch (ArithmeticException e) {
            System.out.println("Arithmetic");
        }catch (Exception ae) {
            System.out.println("Exception");
        }
        System.out.println("finished");
    }

    public static void badMethod(){
        throw new Error();
    }
}
