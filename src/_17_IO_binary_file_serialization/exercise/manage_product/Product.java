package _17_IO_binary_file_serialization.exercise.manage_product;

import java.io.Serializable;

public class Product implements Serializable {
    private int productCode;
    private String productName;
    private String productBrand;
    private int productPrice;

    public Product(int productCode, String productName, String productBrand, int productPrice) {
        this.productCode = productCode;
        this.productName = productName;
        this.productBrand = productBrand;
        this.productPrice = productPrice;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode=" + productCode +
                ", productName='" + productName + '\'' +
                ", productBrand='" + productBrand + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
