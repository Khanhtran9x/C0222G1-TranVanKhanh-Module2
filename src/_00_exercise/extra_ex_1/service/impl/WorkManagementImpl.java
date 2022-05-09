package _00_exercise.extra_ex_1.service.impl;

import _00_exercise.extra_ex_1.model.Work;
import _00_exercise.extra_ex_1.service.itf.WorkManagementService;
import _00_exercise.extra_ex_1.ultils.ReadAndWrite;
import _00_exercise.extra_ex_1.ultils.RegexAndException;
import _00_exercise.extra_ex_1.ultils.WorkDayComparator;
import _00_exercise.extra_ex_1.ultils.WorkPriorityComparator;

import java.util.*;

public class WorkManagementImpl implements WorkManagementService {
    public Scanner scanner = new Scanner(System.in);
    public static List<Work> workList;
    public static List<Work> completedWorkList;
    public static Work work;
    public static final String WORK_PATH = "src\\_00_exercise\\extra_ex_1\\data\\WorkList.csv";
    public static final String COMPLETED_WORK = "src\\_00_exercise\\extra_ex_1\\data\\CompletedWork.csv";
    public static List<String []> stringList;

    public List<Work> readFile(String path) {
        List<Work> list = new ArrayList<>();
        stringList = ReadAndWrite.readCsvFile(path);
        for (String[] strArr : stringList) {
            work = new Work(strArr);
            list.add(work);
        }
        return list;
    }

    @Override
    public void display() {
        workList = readFile(WORK_PATH);
        completedWorkList = readFile(COMPLETED_WORK);
        Collections.sort(workList, new WorkPriorityComparator());

        if (workList.isEmpty()) {
            System.err.println("Work list is empty, please input a new one");
        } else {
            for (Work work : workList) {
                for (Work item: completedWorkList){
                    if (item.getWorkCode().equals(work.getWorkCode())){
                        System.err.println(work.getInfo());
                    } else {
                        System.out.println(work.getInfo());
                    }
                }
            }
        }
    }

    @Override
    public void displayByDayOfWeek() {
        workList = readFile(WORK_PATH);
        completedWorkList = readFile(COMPLETED_WORK);
        workList.sort(new WorkDayComparator());

        if (workList.isEmpty()) {
            System.err.println("Work list is empty, please input a new one");
        } else {
            for (Work work : workList) {
                for (Work item: completedWorkList){
                    if (item.getWorkCode().equals(work.getWorkCode())){
                        System.err.println(work.getInfo());
                    } else {
                        System.out.println(work.getInfo());
                    }
                }
            }
        }
    }

    @Override
    public void addNew() {
        workList = readFile(WORK_PATH);

        System.out.println("--INPUT INFORMATION OF WORK---");

        System.out.println("Input work code: ");
        String code = RegexAndException.inputCode();

        System.out.println("Input work name: ");
        String name = RegexAndException.inputName();

        System.out.println("Input work day: ");
        String dayOfWeek = scanner.nextLine();

        String priority = "";
        int choice;
        boolean check = true;
        while (check) {
            System.out.println("Choose work priority: ");
            System.out.println("1. High");
            System.out.println("2. Normal");
            System.out.println("3. Low");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        priority = "High";
                        check = false;
                        break;
                    case 2:
                        priority = "Normal";
                        check = false;
                        break;
                    case 3:
                        priority = "Low";
                        check = false;
                        break;
                    default:
                        System.out.println("Your choice does not match our options");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please input a number which matches our options");
            }
        }

        work = new Work(code, name, dayOfWeek, priority);
        workList.add(work);

        ReadAndWrite.writeCsvFile(workList, WORK_PATH);
    }

    public void updateCompletedWork(){
        completedWorkList = new ArrayList<>();
        workList = readFile(WORK_PATH);

        if (workList.isEmpty()) {
            System.err.println("Work list is empty");
        } else {
            for (Work work : workList) {
                System.out.println(work.getInfo());
            }
        }
        System.out.println("Input the code of the completed work: ");
        String code = scanner.nextLine();

        for (Work work: workList) {
            if (code.equals(work.getWorkCode())){
                completedWorkList.add(work);
            }
        }
        ReadAndWrite.writeCsvFile(completedWorkList, COMPLETED_WORK);
    }

    @Override
    public void edit() {

    }

    @Override
    public void remove() {

    }
}
