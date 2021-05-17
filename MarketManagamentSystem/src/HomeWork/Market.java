package HomeWork;

import java.time.LocalDateTime;
import java.util.*;

public class Market implements IMarket{

    public static final Map<String, Product> productList = new HashMap<>();
    public static final Map<Integer, Sale> saleList = new HashMap<>();

    @Override
    public void addNewProduct() {
        try {
            Scanner scanner = new Scanner(System.in);
            Product product = new Product();
            System.out.println("Enter product name: ");
            String name = scanner.nextLine().toUpperCase();
            product.setProductName(name);
            Product existingProducts = productList.get(name);
            if (name.equals(existingProducts.getProductName())){
                System.out.println("Enter count to add inventory: ");
                int previousCount = existingProducts.getProductCount();
                int incrementedCount = scanner.nextInt();
                existingProducts.setProductCount(previousCount + incrementedCount);
                productList.put(product.getProductName(), product);
            }else {
                System.out.println("Enter product price: ");
                product.setProductPrice(scanner.nextDouble());
                System.out.println("Enter product category:" +
                        "\n 1-Fruits" +
                        "\n 2-Vegetables" +
                        "\n 3-Drinks" +
                        "\n 4-Snacks");
                int productCategory = scanner.nextInt();
                if (productCategory > ProductCategories.values().length) {
                    System.out.println("Please select within the provided numbers");
                    productCategory = scanner.nextInt();
                }
                product.setCategories(ProductCategories.values()[productCategory - 1]);
                System.out.println("Enter product count: ");
                product.setProductCount(scanner.nextInt());
                String productID = UUID.randomUUID().toString();
                product.setProductID(productID);
                productList.put(product.getProductName(), product);
            }
        }catch (Exception e){
            System.out.println("Please enter correct input type");
            addNewProduct();
        }
    }

    @Override
    public void getAllProducts() {
        try {
            productList.values();
        }catch (Exception e){
            System.out.println("Please enter correct input type");
            getAllProducts();
        }
    }

    @Override
    public void editProduct() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the name of product for edit: ");
            String name = scanner.nextLine();
            System.out.println("name : " + name);
            Product product = productList.get(name);
            if (productList.isEmpty() || product==null){
                System.out.println("Inventory is empty. Please First add product");
                addNewProduct();
            }else {
                System.out.println("Set new name: ");
                product.setProductName(scanner.nextLine().toUpperCase());
                System.out.println("Set new price: ");
                product.setProductPrice(scanner.nextDouble());
                System.out.println("Set new category: " +
                        "\n 1-Fruits" +
                        "\n 2-Vegetables" +
                        "\n 3-Drinks" +
                        "\n 4-Snacks");
                int productCategory = scanner.nextInt();
                if (productCategory > ProductCategories.values().length) {
                    System.out.println("Please select within the provided numbers");
                    productCategory = scanner.nextInt();
                }
                product.setCategories(ProductCategories.values()[productCategory - 1]);
                System.out.println("Enter new product count: ");
                product.setProductCount(scanner.nextInt());
                productList.put(product.getProductName(), product);
            }
        }catch (Exception e){
            System.out.println("Please enter correct input type");
            editProduct();
        }
    }

    @Override
    public void deleteProduct() {
        try {
            System.out.println("Enter the product name to delete: ");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine().toUpperCase();
            System.out.println("name : " + name);
            Product product = productList.get(name);
            if (!productList.isEmpty() && product!=null) {
                System.out.println(productList.remove(product.getProductName()) + "has been removed");
            }else {
                System.out.println("Inventory does not have such product");
            }
        } catch (Exception e) {
            System.out.println("Please enter correct input type");
            deleteProduct();
        }
    }

    @Override
    public void getProductsByCategory() {
        try {
            Scanner scanner = new Scanner(System.in);
            List<Product> productCategories = new ArrayList<>();
            System.out.println("Choose category: " +
                    "\n 1-Fruits" +
                    "\n 2-Vegetables" +
                    "\n 3-Drinks" +
                    "\n 4-Snacks");
            int selectCategory = scanner.nextInt();
            if (selectCategory > ProductCategories.values().length) {
                System.out.println("Please select within the provided numbers");
                selectCategory = scanner.nextInt();

            }
            for (String key : productList.keySet()) {
                Product product = productList.get(key);
                if (product.getCategories().equals(ProductCategories.values()[selectCategory - 1])) {
                    productCategories.add(product);
                }
            }
            System.out.println(productCategories);
        }catch (Exception e){
            System.out.println("Please enter correct inout type");
            getProductsByCategory();
        }
    }

    @Override
    public void showProductByPriceRange() {
        try {
            Scanner scanner = new Scanner(System.in);
            List<Product> productRange = new ArrayList<>();
            System.out.println("From range: ");
            double from = scanner.nextDouble();
            System.out.println("To range : ");
            double to = scanner.nextDouble();
            for (String key : productList.keySet()) {
                Product product = productList.get(key);
                if (from<0 && to<0 || from<0 || to<0){
                    System.out.println("Please enter positive numbers for search");
                    showProductByPriceRange();
                }else {
                    if (product.getProductPrice() < to && product.getProductPrice() > from) {
                        productRange.add(product);
                    } else {
                        System.out.println("There are no any product in that range");
                    }
                }
            }
            System.out.println(productRange);
        }catch (Exception e){
            System.out.println("Please enter correct input type");
            showProductByPriceRange();
        }
    }

    @Override
    public void searchProductByName() {
        try {
            System.out.println("Enter input for searching in product names: ");
            Scanner scanner = new Scanner(System.in);
            List<Product> priceRange = new ArrayList<>();
            String input;
            input = scanner.nextLine().toUpperCase();
            for (String key : productList.keySet()) {
                Product product = productList.get(key);
                if (product.getProductName().contains(input)) {
                    priceRange.add(product);
                }else {
                    System.out.println("There are not any product");
                }
            }
            System.out.println(priceRange);
        }catch (Exception e){
            System.out.println("Please enter correct input type");
            searchProductByName();
        }
    }

    @Override
    public void addNewSale() {
        try {
            Scanner scanner = new Scanner(System.in);
            Sale sale = new Sale();
            System.out.println("Enter sale ID: ");
            sale.setSaleID(scanner.nextInt());
            System.out.println("(To end sale please press 0) Enter product name: ");
            String saleProductName = scanner.nextLine();
            if (saleProductName.equals("0")) {

            } else {
                Product product = productList.get(saleProductName);
                if (!productList.isEmpty() && product != null) {
                    System.out.println("Enter count of product: ");
                    int saleProductCount = scanner.nextInt();
                    if (saleProductCount <= product.getProductCount()) {
                        sale.setSaleItems(product.getProductName());
                        sale.setCostOfSale(product.getProductPrice() * saleProductCount);
                        System.out.println("Enter date: (dd-mm-yy)");
                        sale.setSaleDate(scanner.nextLine());
                        product.setProductCount(product.getProductCount() - saleProductCount);
                        saleList.put(sale.getSaleID(), sale);
                    } else {
                        System.out.println("We don't have" + saleProductCount + product.getProductName());
                        System.out.println("Inventory has" + product.getProductCount() + product.getProductName());
                        addNewSale();
                    }
                } else {
                    System.out.println("Inventory is empty");
                }
            }
        }catch (Exception e){
            System.out.println("Please enter correct input type");
            addNewSale();
        }

    }

    @Override
    public void getSaleById() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the sale ID: ");
            int getSaleId = scanner.nextInt();
            Sale sale = saleList.get(getSaleId);
            if (getSaleId == sale.getSaleID()){
                System.out.println(saleList.get(sale));
            }else {
                System.out.println("There is no such sale");
                getSaleById();
            }
        }catch (Exception e){
            System.out.println("Please enter correct input type");
            getSaleById();
        }
    }

    @Override
    public void returnProductFromSale() {

    }

    @Override
    public void removeSale() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter sale ID: ");
            int removeSaleId = scanner.nextInt();
            if ( !saleList.isEmpty() && saleList.get(removeSaleId)!=null){
                System.out.println(saleList.remove(removeSaleId) + "has been removed");
            }else {
                System.out.println("There is no such sale");
                removeSale();
            }
        }catch (Exception e){
            System.out.println("Please enter correct type");
            removeSale();
        }
    }

    @Override
    public void getAllSales() {
        try {
            for (int key: saleList.keySet()){
                saleList.values();
            }
        }catch (Exception e){
            System.out.println("There are no any sale");
            getAllSales();
        }
    }

    @Override
    public void getSalesByDate() {
        try {

        }catch (Exception e){
            System.out.println("Please enter correct date type");
            getSalesByDate();
        }
    }

    @Override
    public void getSalesByDateInterval() {

    }

    @Override
    public void getSalesByPriceInterval() {
        try {
            Scanner scanner = new Scanner(System.in);
            List<Sale> costRange = new ArrayList<>();
            System.out.println("Enter from price: ");
            double fromCost = scanner.nextDouble();
            System.out.println("Enter to price: ");
            double toCost = scanner.nextDouble();
            if (fromCost<0 && toCost<0 || fromCost<0 || toCost<0){
                System.out.println("Please enter positive price");
                getSalesByPriceInterval();
            }else {
                for ( int key : saleList.keySet()){
                    Sale sale = saleList.get(key);
                    if (sale.getCostOfSale()<toCost && sale.getCostOfSale()>fromCost){
                        costRange.add(sale);
                    }else {
                        System.out.println("There are no any sale in that range");
                    }
                }
                System.out.println(costRange);
            }
        }catch (Exception e){
            System.out.println("Please enter correct input type");
            getSalesByPriceInterval();
        }
    }
}
