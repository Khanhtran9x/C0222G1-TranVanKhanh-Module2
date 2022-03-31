package _01_introduction_java.practice;

import java.util.Scanner;

public class UngDungDocSoThanhChu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập vào số cần đọc");
        int number = scanner.nextInt();

        String read;

        if (number > 0 && number <= 10){
            read = readOnes(number);
            System.out.println(read);
        }
        if (number > 10 && number <= 13){
            read = read2Digits(number);
            System.out.println(read);
        }
        if (number > 13 && number < 20){
            number = number % 10;
            read = readOnes(number) + "teen";
            System.out.println(read);
        }
        if (number >= 20 && number < 100){
            int numberOnes = number % 10;
            number -= numberOnes;
            read = readTens(number);
            String readOnes = readOnes(numberOnes);
            System.out.println(read + " " + readOnes);
        }
        if (number >= 100){
            int numberOnes = number % 10;
            int numberTens = number % 100 - numberOnes;
            number = (number - number % 100) / 100;
            read = readOnes(number);
            String readTens = readTens(numberTens);
            String readOnes = readOnes(numberOnes);
            System.out.println(read + " hundreds "+ readTens + " " + readOnes);
        }

    }
    public static String readOnes(int number) {
        String read;
        switch (number){
            case 1:
                read = "one";
                break;
            case 2:
                read = "two";
                break;
            case 3:
                read = "three";
                break;
            case 4:
                read = "four";
                break;
            case 5:
                read = "five";
                break;
            case 6:
                read = "six";
                break;
            case 7:
                read = "seven";
                break;
            case 8:
                read = "eight";
                break;
            case 9:
                read = "nine";
                break;
            case 10:
                read = "ten";
                break;
            default:
                read = "";
        }
        return read;
    }
    public static String read2Digits(int number) {
        String read;
        switch (number){
            case 11:
                read = "eleven";
                break;
            case 12:
                read = "twelve";
                break;
            case 13:
                read = "three";
                break;
            default:
                read = "";
        }
        return read;
    }
    public static String readTens(int number) {
        String read;
        switch (number){
            case 20:
                read = "twenty";
                break;
            case 30:
                read = "thirty";
                break;
            case 40:
                read = "forty";
                break;
            case 50:
                read = "fifty";
                break;
            case 60:
                read = "sixty";
                break;
            case 70:
                read = "seventy";
                break;
            case 80:
                read = "eighty";
                break;
            case 90:
                read = "ninety";
                break;
            default:
                read = "";
        }
        return read;
    }
}
