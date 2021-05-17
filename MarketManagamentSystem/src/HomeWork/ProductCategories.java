package HomeWork;

public enum ProductCategories {
    FRUITS("Drinks"),
    VEGETABLES("Vegetables"),
    DRINKS("Drinks"),
    SNACKS("Snacks");

    private final String toString;

    ProductCategories(String toString){
        this.toString = toString;
    }
}
