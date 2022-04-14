package _10_DSA.exercise.array_list;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private E elements[];

    public MyList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyList(E[] e) {
        for (int i = 0; i < e.length; i++)
            this.add(e[i]);
    }


    public void add(int index, E e) {
        ensureCapa();
        for (int i = size - 1; i >= index; i--) elements[i + 1] = elements[i];
        elements[index] = e;
        size++;
    }

    public boolean add(E e) {
        ensureCapa();
        elements[size++] = e;
        return true;
    }

    public int size() {
        return size;
    }

    public E remove(int index) {
        checkIndex(index);

        E e = elements[index];

        for (int j = index; j < size - 1; j++)
            elements[j] = elements[j + 1];

        elements[size - 1] = null;

        size--;
        return e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++)
            if (e.equals(elements[i]))
                return true;
        return false;
    }

    public E clone(E[] e) {
        elements = e;
        return (E) elements;
    }

    public int indexOf(E e) {
        for (int i = 0; i < size; i++)
            if (e.equals(elements[i])) return i;
        return -1;
    }

    public E get(int index) {
        checkIndex(index);
        return elements[index];
    }

    private void ensureCapa() {
        if (size > elements.length){
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
        }
    }


    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException
                    ("index " + index + " out of bounds");
    }

}
