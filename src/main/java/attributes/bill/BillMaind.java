package attributes.bill;

public class BillMaind {

    public static void main(String[] args) {

        Bill bill = new Bill();
        bill.addItem(new Item("alma", 2, 300));
        bill.addItem(new Item("körte", 1, 500));
        bill.addItem(new Item("zsemle", 10, 30));
        System.out.println(bill.calculateTotalPrice());

    }
}
