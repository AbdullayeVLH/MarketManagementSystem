package HomeWork;

public interface IMarket {
    void addNewProduct() ;
    void getAllProducts() ;
    void editProduct() ;
    void deleteProduct() ;
    void getProductsByCategory() ;
    void showProductByPriceRange();
    void searchProductByName() ;
    void addNewSale() ;
    void getSaleById() ;
    void returnProductFromSale() ;
    void removeSale() ;
    void getAllSales() ;
    void getSalesByDate() ;
    void getSalesByDateInterval() ;
    void getSalesByPriceInterval() ;
}
