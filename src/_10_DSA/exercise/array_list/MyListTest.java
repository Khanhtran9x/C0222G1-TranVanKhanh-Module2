package _10_DSA.exercise.array_list;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);
        listInteger.add(5);
        System.out.println("element 0: "+listInteger.get(0));
        System.out.println("element 1: "+listInteger.get(1));
        System.out.println("element 2: "+listInteger.get(2));
        System.out.println("Does array contain element '4'? "+listInteger.contains(4));
        System.out.println("Index of element '2'? "+listInteger.indexOf(2));
        listInteger.remove(3);
        System.out.println("element 4: "+listInteger.get(3));

    }
}
