package _00_exercise.extra_ex_1.ultils;

import _00_exercise.extra_ex_1.model.Work;

import java.util.Comparator;

public class WorkPriorityComparator implements Comparator<Work> {

    @Override
    public int compare(Work o1, Work o2) {
        if (o1.getPriority().equals("High") || o1.getPriority().equals("Normal") && o2.getPriority().equals("Normal") ||
                o1.getPriority().equals("Normal") && o2.getPriority().equals("Low")){
            return -1;
        } else {
            return 1;
        }
    }
}
