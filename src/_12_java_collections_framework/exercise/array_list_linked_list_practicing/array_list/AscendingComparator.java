package _12_java_collections_framework.exercise.array_list_linked_list_practicing.array_list;

import java.util.Comparator;

public class AscendingComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getProductPrice() > o2.getProductPrice()){
            return 1;
        }
        else if (o1.getProductPrice() < o2.getProductPrice()){
            return -1;
        }
        else {
            return 0;
        }
    }
}
