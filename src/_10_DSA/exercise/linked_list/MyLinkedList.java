package _10_DSA.exercise.linked_list;

import javax.xml.soap.Node;
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;
    private Node tail;
    private E e;

    public MyLinkedList() {
    }

    public MyLinkedList(E e) {
        head = new Node(e);
    }

    private class Node {
        private Node next;
        private Node prev;
        private E e;

        public Node(E e) {
            this.e = e;
        }

        public E getData() {
            return this.e;
        }
    }

    public void add(int index, E e) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(e);
        temp.next.next = holder;
        tail = temp.next;
        numNodes++;
    }

    public void addFirst(E e) {
        Node temp = head;
        head = new Node(e);
        head.next = temp;
        tail = temp;
        numNodes++;
    }

    public void addLast(E e) {
        Node newNode = new Node(e);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }

        numNodes++;
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes) return null;
        else if (index == 0) return removeFirst();
        else if (index == numNodes - 1) return removeLast();
        else {
            Node previous = head;

            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }

            Node current = previous.next;
            previous.next = current.next;
            numNodes--;
            return current.e;
        }
    }
    public boolean remove(Object o) {
        if (o == null) {
            for (Node x = head; x != null; x = x.next) {
                if (x.e == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node x = head; x != null; x = x.next) {
                if (o.equals(x.e)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }
    public E unlink(Node x) {
        final E element = x.e;
        final Node next = x.next;
        final Node prev = x.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.e = null;
        numNodes--;
        return element;
    }

    public E removeFirst() {
        if (numNodes == 0) return null;
        else {
            Node temp = head;
            head = head.next;
            numNodes--; //
            if (head == null) tail = null;
            return temp.e;
        }
    }

    public E removeLast() {
        if (numNodes == 0) return null; // Nothing to remove
        else if (numNodes == 1) { // Only one element in the list
            Node temp = head;
            head = tail = null; // list becomes empty
            numNodes = 0;
            return temp.e;
        } else {
            Node current = head;

            for (int i = 0; i < numNodes - 2; i++)
                current = current.next;

            Node temp = tail;
            tail = current;
            tail.next = null;
            numNodes--;
            return temp.e;
        }
    }
    public boolean add(E e) {
        linkLast(e);
        return true;
    }
    public void linkLast(E e) {
        final Node l = tail;
        final Node newNode = new Node(e);
        tail = newNode;
        if (l == null)
            head = newNode;
        else
            l.next = newNode;
        numNodes++;
    }

    public E get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.e;
    }

    public E getFirst() {
        final Node f = head;
        if (f == null)
            throw new NoSuchElementException();
        return f.e;
    }

    public E getLast() {
        final Node f = tail;
        if (tail == null)
            throw new NoSuchElementException();
        return f.e;
    }

    public void clear() {
        for (Node x = head; x != null; ) {
            Node next = x.next;
            x.e = null;
            x.next = null;
            x.e = null;
            x = next;
        }
        head = null;
        numNodes = 0;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.e);
            temp = temp.next;
        }
    }

    public int size() {
        return numNodes;
    }

    public boolean contains(E e) {
        return indexOf(e) != -1;
    }
    public int indexOf(E e) {
        int index = 0;
        if (e == null) {
            for (Node x = head; x != null; x = x.next) {
                if (x.e == null)
                    return index;
                index++;
            }
        } else {
            for (Node x = head; x != null; x = x.next) {
                if (e.equals(x.e))
                    return index;
                index++;
            }
        }
        return -1;
    }

}
