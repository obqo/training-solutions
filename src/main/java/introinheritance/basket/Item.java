package introinheritance.basket;

public class Item {

    private String barcode;
    private double nettoPrice;
    private int vatPercent;

    public Item(String barcode, double nettoPrice, int vatPercent) {
        this.barcode = barcode;
        this.nettoPrice = nettoPrice;
        this.vatPercent = vatPercent;
    }

    public double getTaxAmount() { // a nettoPrice és a vatPercent alapján kiszámolja az adó összegét
        return nettoPrice * vatPercent / 100.0;
    }

    public String getBarcode() {
        return barcode;
    }

    public double getNettoPrice() {
        return nettoPrice;
    }

    @Override
    public String toString() {  // generált string reprezentáció
        return "Item{" +
                "barcode='" + barcode + '\'' +
                ", nettoPrice=" + nettoPrice +
                ", vatPercent=" + vatPercent +
                '}';
    }
}
