package ex8_1;

/**
 * 4theme
 * exercise8_1
 * @author Vitalii Reshetnyk
 */


import java.util.ArrayList;
import java.util.List;

public class Payment {
    private List<Item> items;

    public Payment() {
        this.items = new ArrayList<>();
    }

    public void addItem(String name, double price, int quantity) {
        Item newItem = new Item(name, price, quantity);
        items.add(newItem);
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (Item item : items) {
            totalAmount += item.calculateItemTotal();
        }
        return totalAmount;
    }

    public void printReceipt() {
        System.out.println("Receipt:");
        for (Item item : items) {
            System.out.println(item.toString());
        }
        System.out.println("Total Amount: $" + getTotalAmount());
    }

    private class Item {
        private String name;
        private double price;
        private int quantity;

        public Item(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public double calculateItemTotal() {
            return price * quantity;
        }

        @Override
        public String toString() {
            return "Item: " + name + ", Price: $" + price + ", Quantity: " + quantity +
                    ", Total: $" + calculateItemTotal();
        }
    }

    public static void main(String[] args) {
        Payment payment = new Payment();

        payment.addItem("Product 1", 15.25, 5);
        payment.addItem("Product 2", 91.25, 9);
        payment.addItem("Product 3", 13.75, 1);

        payment.printReceipt();
    }
}

