package _22_structural_design_pattern.exercise.facade_pattern;

import java.util.List;

public class RandomListFacade {
    private RandomList randomList = new RandomList();
    private ListFilter listFilter = new ListFilter();
    private ListPrinter listPrinter = new ListPrinter();

    public RandomListFacade() {
    }

    public void printRandomEvenList(){
        List<Integer> integerList = this.randomList.generateList(100, 1, 101);
        List<Integer> integerList1 = this.listFilter.filterOdd(integerList);
        this.listPrinter.printList(integerList1);

    }
}
