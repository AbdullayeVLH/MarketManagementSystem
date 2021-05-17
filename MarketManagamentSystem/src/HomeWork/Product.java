package HomeWork;

public class Product {
    private String productName;
    private double productPrice;
    private ProductCategories categories;
    private int productCount;
    private String productID;

    public String getProductName() {
        return productName;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public ProductCategories getCategories() {
        return categories;
    }

    public void setCategories(ProductCategories categories) {
        this.categories = categories;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", categories=" + categories +
                ", productCount=" + productCount +
                ", productID='" + productID + '\'' +
                '}' + "\n";
    }
}
