package _00_exercise.extra_ex_2.controller;

import _00_exercise.extra_ex_2.service.MovieTheatreImpl;

import java.util.Scanner;

public class MovieTheatreController {
    public static MovieTheatreImpl movieTheatre = new MovieTheatreImpl();

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("---MENU---");
            System.out.println("1.\tMovie Show List\n" +
                    "2.\tAdd New Show\n" +
                    "3.\tDelete A Show\n" +
                    "4.\tExit\n");
            try {
                System.out.println("Input your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        movieTheatre.display();
                        break;
                    case 2:
                        movieTheatre.addNew();
                        break;
                    case 3:
                        movieTheatre.remove();
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.err.println("Your choice does not match our options");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please input a number which matches our options");
            }
        }
    }
}
