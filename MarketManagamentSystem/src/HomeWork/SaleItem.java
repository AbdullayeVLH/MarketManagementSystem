package HomeWork;

public class SaleItem {
    private int saleItemCode;
    private String saleItemName;
    private int saleItemCount;

    public int getSaleItemCode() {
        return saleItemCode;
    }

    public void setSaleItemCode(int saleItemCode) {
        this.saleItemCode = saleItemCode;
    }

    public String getSaleItemName() {
        return saleItemName;
    }

    public void setSaleItemName(String saleItemName) {
        this.saleItemName = saleItemName;
    }

    public int getSaleItemCount() {
        return saleItemCount;
    }

    public void setSaleItemCount(int saleItemCount) {
        this.saleItemCount = saleItemCount;
    }

    @Override
    public String toString() {
        return "SaleItem{" +
                "saleItemCode=" + saleItemCode +
                ", saleItemName='" + saleItemName + '\'' +
                ", saleItemCount=" + saleItemCount +
                '}';
    }

}
