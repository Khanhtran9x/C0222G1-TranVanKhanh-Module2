package _22_structural_design_pattern.exercise.facade_pattern;

public class Client {
    public void printRandomEvenList() {
        RandomListFacade randomListFacade = new RandomListFacade();
        randomListFacade.printRandomEvenList();
    }
}
