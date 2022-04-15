package _12_java_collections_framework.exercise.array_list_linked_list_practicing.array_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {

    public static void addProduct(ArrayList<Product> productArr){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sản phẩm muốn thêm");
        String productName = scanner.nextLine();
        System.out.println("Nhập ID sản phầm muốn thêm");
        String productID = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm muốn thêm");
        double productPrice = Double.parseDouble(scanner.nextLine());
        Product product = new Product(productName, productID, productPrice);

        productArr.add(product);
        System.out.println("Đã thêm sản phẩm thành công!!");
    }

    public static void editProductById(ArrayList<Product> productArr){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID sản phẩm muốn sửa");
        String productID = scanner.nextLine();

        for (int i = 0; i < productArr.size(); i++) {
         if (productArr.get(i).getProductId().equals(productID)){
             System.out.println("Nhập lại tên mới của sản phẩm");
             String productName = scanner.nextLine();
             System.out.println("Nhập lại ID mới của sản phẩm");
             String productId = scanner.nextLine();
             System.out.println("Nhập lại giá mới của sản phẩm");
             double productPrice =  Double.parseDouble(scanner.nextLine());

             Product product = new Product(productName, productID, productPrice);
             productArr.add(i, product);
         } else {
             System.out.println("ID vừa nhập vào không tồn tại");
         }
        }
    }

    public static void removeProductById(ArrayList<Product> productArr) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID sản phẩm muốn xóa");
        String productID = scanner.nextLine();

        for (Product product: productArr) {
            if (product.getProductId().equals(productID)) {
                productArr.remove(product);
                System.out.println("Đã xóa thành công!!");
                break;
            } else {
                System.out.println("ID vừa nhập vào không tồn tại");
            }
        }
    }

    public static void displayProductList(ArrayList<Product> productArr){
        for (Product product: productArr) {
            System.out.println(product.toString());
        }
    }

    public static void findProductByName(ArrayList<Product> productArr){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sản phẩm muốn tìm");
        String productName = scanner.nextLine();

        for (Product product: productArr) {
            if (product.getProductName().equals(productName)){
                System.out.println("Kết quả tìm kiếm là: ");
                System.out.println(product.toString());
            } else {
                System.out.println("Tên của sản phẩm vừa nhập vào không tồn tại");
            }
        }
    }

    public static void sortProductByPrice(ArrayList<Product> productArr){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chọn cách thức sắp xếp");
        System.out.println("1. Sắp xếp tăng dần");
        System.out.println("2. Sắp xếp giảm dần");
        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                sortAscending(productArr);
                break;
            case 2:
                sortDescending(productArr);
                break;
        }
    }

    private static void sortDescending(ArrayList<Product> productArr) {
        AscendingComparator ascendingComparator = new AscendingComparator();
        Collections.sort(productArr, ascendingComparator);
    }

    private static void sortAscending(ArrayList<Product> productArr) {
        DescendingComparator descendingComparator = new DescendingComparator();
        Collections.sort(productArr, descendingComparator);
    }
}
