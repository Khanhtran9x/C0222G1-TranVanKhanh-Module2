package _00_exercise.extra_ex_2.service;


import _00_exercise.extra_ex_2.model.MovieShow;
import _00_exercise.extra_ex_2.ultils.ReadAndWrite;
import _00_exercise.extra_ex_2.ultils.RegexAndException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieTheatreImpl implements Service {
    public Scanner scanner = new Scanner(System.in);
    public static List<MovieShow> movieShows;
    public static MovieShow movieShow;
    public static final String PATH = "src\\_00_exercise\\extra_ex_2\\data\\MovieShow.csv";
    public static List<String[]> stringList;

    public List<MovieShow> readFile(String path) {
        List<MovieShow> list = new ArrayList<>();
        stringList = ReadAndWrite.readCsvFile(path);

        for (String[] strArr : stringList) {
            movieShow = new MovieShow(strArr);
            list.add(movieShow);
        }

        return list;
    }

    @Override
    public void display() {
        movieShows = readFile(PATH);
        if (movieShows.isEmpty()) {
            System.err.println("Movie show list is empty, please input a new one");
        } else {
            for (MovieShow movieShow : movieShows) {
                System.out.println(movieShow.getInfo() + "\n");
            }
        }
    }

    @Override
    public void addNew() {
        movieShows = readFile(PATH);

        System.out.println("--INPUT INFORMATION OF MOVIE SHOW---");

        System.out.println("Input movie show code: ");
        String code = RegexAndException.inputCode();

        System.out.println("Input movie name: ");
        String name = RegexAndException.inputName();

        System.out.println("Input movie show date: ");
        String date = RegexAndException.inputShowDate();

        System.out.println("Input movie tickets: ");
        int tickets = RegexAndException.inputTickets();

        movieShow = new MovieShow(code, name, date, tickets);
        movieShows.add(movieShow);
        ReadAndWrite.writeCsvFile(movieShows, PATH);
        System.out.println("Added successfully");
    }

    @Override
    public void edit() {

    }

    @Override
    public void remove() {
        movieShows = readFile(PATH);
        boolean check = true;

        System.out.println("Input the code of movie show that you want to remove");
        String movieCode;

        while (check) {
            movieCode = scanner.nextLine();
            for (MovieShow movieShow : movieShows) {
                if (movieCode.equals(movieShow.getShowCode())) {
                    System.out.println("Do you actually want to remove it? 1. Yes,   2. No");
                    int choice = Integer.parseInt(scanner.nextLine());
                    try {
                        if (choice == 1){
                            movieShows.remove(movieShow);
                            check = false;
                            break;
                        } else if (choice == 2){
                            check = false;
                            break;
                        } else {
                            System.out.println("Please input 1 or 2 to confirm");
                            check = false;
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Please input 1 or 2 to confirm");
                        check = false;
                        break;
                    }
                }
            }
            if (check){
                System.err.println("The code you inputted does not exist, please input again");
            }
        }

        ReadAndWrite.writeCsvFile(movieShows, PATH);
        System.out.println("Remove successfully");
    }
}
