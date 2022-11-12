package bussiness.entity;

import java.io.Serializable;

public class Product implements Serializable {
    private String productID;
    private String productName;
    private int importPrice ;
    private boolean productStatus;
    private Catalog catalog;

    public Product() {
    }

    public Product(String productID, String productName, int importPrice, boolean productStatus, Catalog catalog) {
        this.productID = productID;
        this.productName = productName;
        this.importPrice = importPrice;
        this.productStatus = productStatus;
        this.catalog = catalog;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(int importPrice) {
        this.importPrice = importPrice;
    }



    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
