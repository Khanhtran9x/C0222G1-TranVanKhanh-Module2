package _17_IO_binary_file_serialization.exercise.manage_product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductTest implements Serializable{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1,"Nokia N10", "Nokia", 1000 ));
        productList.add(new Product(1,"Iphone XS Max", "Apple", 5000 ));
        productList.add(new Product(1,"Samsung Zflip", "Samsung", 1500));
        productList.add(new Product(1,"Oppo A6", "Oppo", 700 ));
        productList.add(new Product(1,"Xiaomi ultra", "Xiaomi", 500));

        System.out.println("Nhập đường dẫn của file cần ghi dữ liệu");
        String path = scanner.nextLine();
        for (Product product: productList) {
            addProductToFile(path, product);
        }


    }
    public static void addProductToFile(String path, Product product){
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(product);
            oos.close();
            fos.close();

        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
