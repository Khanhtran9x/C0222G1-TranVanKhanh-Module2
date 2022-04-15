package _12_java_collections_framework.exercise.array_list_linked_list_practicing.linked_list;

import java.util.*;

public class ProductTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> productArr = new LinkedList<>();
        Product product1 = new Product("Vinamilk", "VNM", 9000);
        Product product2 = new Product("Cocacola", "COC", 8000);
        productArr.add(product1);
        productArr.add(product2);
        int choice = -1;

        while (choice != 6) {
            System.out.println("Menu");
            System.out.println("0. Thêm sản phẩm");
            System.out.println("1. Sửa thông tin sản phẩm theo ID");
            System.out.println("2. Xóa sản phẩm theo ID");
            System.out.println("3. Hiển thị danh sách sản phẩm");
            System.out.println("4. Tìm kiếm sản phẩm theo tên");
            System.out.println("5. Sắp xếp sản phẩm tăng, giảm dần theo giá");
            System.out.println("6. Thoát");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 0:
                    ProductManager.addProduct(productArr);
                    break;
                case 1:
                    ProductManager.editProductById(productArr);
                    break;
                case 2:
                    ProductManager.removeProductById(productArr);
                    break;
                case 3:
                    ProductManager.displayProductList(productArr);
                    break;
                case 4:
                    ProductManager.findProductByName(productArr);
                    break;
                case 5:
                    ProductManager.sortProductByPrice(productArr);
                    break;
            }
        }

    }
}
