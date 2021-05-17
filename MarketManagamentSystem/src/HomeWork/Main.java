package HomeWork;

import java.util.Scanner;

public class Main {

    private static void menu(){
        System.out.println("Please choose the operation" +
                "\n -1 for operations with products" +
                "\n -2 for operations with sales" +
                "\n -3 for exit system");
    }

    private static void productOperations(){
        System.out.println("Please choose the operation" +
                "\n -1 for add new item" +
                "\n -2 for edit existing item" +
                "\n -3 for delete item" +
                "\n -4 for show  item" +
                "\n -5 for show all items by categories" +
                "\n -6 for show all items within defined price range" +
                "\n -7 for search items by name" +
                "\n -8 for exit system");
    }

    private static void salesOperations(){
        System.out.println("Please choose the operation" +
                "\n -1 for add new item" +
                "\n -2 for edit existing item" +
                "\n -3 for delete item" +
                "\n -4 for show all items" +
                "\n -5 for show all items by categories" +
                "\n -6 for show all items within defined price range" +
                "\n -7 for search items by name" +
                "\n -8 for search items by name" +
                "\n -9 for exit system");
    }

    private static void getInputsFromUser(){
        try {
            menu();
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            if (input>0){
                switch (input){
                    case 1:
                        productOperationsInputs();
                        getInputsFromUser();
                    case 2:
                        saleOperationsInputs();
                        getInputsFromUser();
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Please enter number from the list");
                        getInputsFromUser();
                }
            }else {
                System.out.println("Please enter positive number");
                getInputsFromUser();
            }
        }catch (Exception e){
            System.out.println("Please enter correct input type");
            getInputsFromUser();
        }
    }

    private static void productOperationsInputs(){
        try {
            productOperations();
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            if (input>0){
                switch (input){
                    case 1:
                        Market addProduct = new Market();
                        addProduct.addNewProduct();
                        getInputsFromUser();
                    case 2:
                        Market editProduct = new Market();
                        editProduct.editProduct();
                        getInputsFromUser();
                    case 3:
                        Market deleteProduct = new Market();
                        deleteProduct.deleteProduct();
                        getInputsFromUser();
                    case 4:
                        Market showAllProducts = new Market();
                        showAllProducts.getAllProducts();
                        getInputsFromUser();
                    case 5:
                        Market showByCategory = new Market();
                        showByCategory.getProductsByCategory();
                        getInputsFromUser();
                    case 6:
                        Market getByPriceRange = new Market();
                        getByPriceRange.showProductByPriceRange();
                        getInputsFromUser();
                    case 7:
                        Market searchByName = new Market();
                        searchByName.searchProductByName();
                        getInputsFromUser();
                    case 8:
                        System.exit(0);
                    default:
                        System.out.println("Please enter from the list");
                        productOperationsInputs();
                }
            }else {
                System.out.println("Please enter positive number");
                productOperationsInputs();
            }

        }catch (Exception e){
            System.out.println("Please enter correct input type");
            productOperationsInputs();
        }
    }

    private static void saleOperationsInputs(){
        try {
            salesOperations();
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            if (input>0){
                switch (input){
                    case 1:
                        Market addSale = new Market();
                        addSale.addNewSale();
                        getInputsFromUser();
                    case 2:
                        getInputsFromUser();
                    case 3:
                        Market deleteSale = new Market();
                        deleteSale.removeSale();
                        getInputsFromUser();
                    case 4:
                        Market getAllSAles = new Market();
                        getAllSAles.getAllSales();
                        getInputsFromUser();
                    case 5:
                        getInputsFromUser();
                    case 6:
                        Market showSalesByPrice = new Market();
                        showSalesByPrice.getSalesByPriceInterval();
                        getInputsFromUser();
                    case 7:
                        getInputsFromUser();
                    case 8:
                        Market showSaleById = new Market();
                        showSaleById.getSaleById();
                        getInputsFromUser();
                    case 9:
                        System.exit(0);
                    default:
                        System.out.println("Please enter from the list");
                        saleOperationsInputs();
                }
            }else {
                System.out.println("Please enter positive number");
                saleOperationsInputs();
            }

        }catch (Exception e){
            System.out.println("Please enter correct input type");
            saleOperationsInputs();
        }
    }

    public static void main(String[] args) {
        getInputsFromUser();
    }
}
