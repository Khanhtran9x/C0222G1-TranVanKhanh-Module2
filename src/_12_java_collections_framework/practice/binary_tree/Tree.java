package _12_java_collections_framework.practice.binary_tree;

public interface Tree<E> {
    public boolean insert(E e);
    public void inorder();
    public int getSize();
}
