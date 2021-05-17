package HomeWork;

import java.time.LocalDateTime;
import java.util.Date;

public class Sale {
    private int saleID;
    private double costOfSale;
    private String saleItems;
    private String saleDate;

    public int getSaleID() {
        return saleID;
    }

    public void setSaleID(int saleID) {
        this.saleID = saleID;
    }

    public double getCostOfSale() {
        return costOfSale;
    }

    public void setCostOfSale(double costOfSale) {
        this.costOfSale = costOfSale;
    }

    public void setCostOfSale(int costOfSale) {
        this.costOfSale = costOfSale;
    }

    public String getSaleItems() {
        return saleItems;
    }

    public void setSaleItems(String saleItems) {
        this.saleItems = saleItems;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleID=" + saleID +
                ", costOfSale=" + costOfSale +
                ", saleItems='" + saleItems + '\'' +
                ", saleDate=" + saleDate +
                '}' + "\n";
    }
}
