package _10_DSA.exercise.linked_list;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addFirst(11);
        myLinkedList.addFirst(12);
        myLinkedList.addFirst(13);

        myLinkedList.add(4,9);
        myLinkedList.add(4,10);

        myLinkedList.addLast(15);

        System.out.println("Mảng ban đầu là");
        myLinkedList.printList();
        System.out.println("Số phần tử trong mảng là: ");
        System.out.println(myLinkedList.size());

        System.out.println("Phần tử đầu tiên là: " + myLinkedList.getFirst());
        System.out.println("Phần tử cuối cùng là: " + myLinkedList.getLast());

        System.out.println("Xóa phần tử thứ 3");
        myLinkedList.remove(3);
        System.out.println("Mảng sau khi xóa là: ");
        myLinkedList.printList();
        System.out.println("Số phần tử trong mảng là: ");
        System.out.println(myLinkedList.size());

        System.out.println("Mảng có chứa phần tử '13' không? " + myLinkedList.contains(13));
    }
}
