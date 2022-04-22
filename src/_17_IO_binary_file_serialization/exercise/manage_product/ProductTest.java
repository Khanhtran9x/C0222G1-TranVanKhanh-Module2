package _17_IO_binary_file_serialization.exercise.manage_product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Nokia N10", "Nokia", 1000));
        productList.add(new Product(1, "Iphone XS Max", "Apple", 5000));
        productList.add(new Product(1, "Samsung Zflip", "Samsung", 1500));
        productList.add(new Product(1, "Oppo A6", "Oppo", 700));
        productList.add(new Product(1, "Xiaomi ultra", "Xiaomi", 500));

        System.out.println("Nhập đường dẫn của file cần ghi dữ liệu");
        String path = scanner.nextLine();
        writeToFile(path, productList);

        int choice = -1;
        while (choice != 4) {
            System.out.println("Menu");
            System.out.println("1. Hiển thị danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm mới vào danh sách");
            System.out.println("3. Tìm kiếm sản phẩm thông qua tên sản phẩm");
            System.out.println("4. Thoát chương trình");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayProductList(path);
                    break;
                case 2:
                    productList.add(inputNewProduct());
                    writeToFile(path, productList);
                    System.out.println("Thêm sản phẩm thành công");
                    break;
                case 3:
                    searchProductInfo(path);
                    break;
            }
        }


    }

    public static void writeToFile(String path, List<Product> product) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(product);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Product inputNewProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào mã sản phẩm");
        int productCode = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào tên sản phẩm");
        String productName = scanner.nextLine();
        System.out.println("Nhập vào tên nhà sản xuất");
        String productBrand = scanner.nextLine();
        System.out.println("Nhập vào giá sản phẩm");
        int productPrice = scanner.nextInt();
        Product product = new Product(productCode, productName, productBrand, productPrice);
        return product;
    }

    public static List<Product> readDataFromFile(String path) {
        List<Product> productList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            productList = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    public static void displayProductList(String path) {
        List<Product> productList = readDataFromFile(path);
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public static void searchProductInfo(String path) {
        List<Product> productList = readDataFromFile(path);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sản phẩm cần tìm kiếm");
        String productName = scanner.nextLine();
        int count = 0;
        for (Product product : productList) {
            if (product.getProductName().contains(productName)) {
                System.out.println(product.toString());
                count++;
                break;
            }
        }
        if (count == 0) {
            System.out.println("Tên sản phẩm vừa nhập vào không có trong file");
        }
    }

}
