package introinheritance.basket;

public class ShoppingBasket {

    private Basket basket = new Basket();

    public void addItem(Item item) {
        basket.addItem(item);
    }

    public void removeItem(String barcode) {
        basket.removeItem(barcode);
    }

    public double sumNettoPrice() { // az összes tételre
        double sum = 0;
        for (Item item : basket.getItems()) {
            sum += item.getNettoPrice();
        }
        return sum;
    }

    public double sumTaxValue() {  // az összes tételre
        double sum = 0;
        for (Item item : basket.getItems()) {
            sum += item.getTaxAmount();
        }
        return sum;

    }

    public double sumBruttoPrice() {
       return sumNettoPrice() + sumTaxValue();
    }

    public void checkout() { // befejezzük a vásárlást, a kosár ürítése
        basket.clearBasket();
    }

    public void removeMostExpensiveItem() { // kikeresi és eltávolítja a kosárból a legdrágább tételt
        Item expensiveItem = basket.getItems().get(0);
        for (Item item : basket.getItems()) {
            if (expensiveItem.getNettoPrice() * (1.0 + expensiveItem.getTaxAmount()) < item.getNettoPrice() * (1.0 + item.getTaxAmount())) {
                expensiveItem = item;
            }
        }
        basket.removeItem(expensiveItem.getBarcode());
    }
}
