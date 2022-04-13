package _12_java_collections_framework.exercise.array_list_linked_list_practicing.linked_list;

public class Product {
    private String productName;
    private String productId;
    private double productPrice;

    public Product() {
    }

    public Product(String productName, String productId, double productPrice) {
        this.productName = productName;
        this.productId = productId;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productId='" + productId + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
