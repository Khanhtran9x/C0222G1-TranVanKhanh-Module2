package _00_exercise.extra_ex_1.ultils;

import _00_exercise.extra_ex_1.model.Work;
import java.util.Comparator;

public class WorkDayComparator implements Comparator<Work> {

    @Override
    public int compare(Work o1, Work o2) {
        if (getDateOfWeek(o1.getDayOfWeek()) > getDateOfWeek(o2.getDayOfWeek())) {
            return 1;
        } else if (getDateOfWeek(o1.getDayOfWeek()) < getDateOfWeek(o2.getDayOfWeek())){
            return -1;
        }
        return 0;
    }

    public int getDateOfWeek(String date) {
        switch (date) {
            case "Monday":
                return 1;
            case "Tuesday":
                return 2;
            case "Wednesday":
                return 3;
            case "Thursday":
                return 4;
            case "Friday":
                return 5;
            case "Saturday":
                return 6;
            case "Sunday":
                return 7;
        }
        return -1;
    }
}
