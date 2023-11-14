package ex6_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 4theme
 * exercise6_1
 * @author Vitalii Reshetnyk
 */
class Flower {
    private String name;
    private double price;
    private int freshness;
    private int stemLength;

    public Flower(String name, double price, int freshness, int stemLength) {
        this.name = name;
        this.price = price;
        this.freshness = freshness;
        this.stemLength = stemLength;
    }

    public double getPrice() {
        return price;
    }

    public int getFreshness() {
        return freshness;
    }

    public int getStemLength() {
        return stemLength;
    }

    @Override
    public String toString() {
        return name + " (Freshness: " + freshness + ", Stem Length: " + stemLength + ")";
    }
}

class Rose extends Flower {
    private String color;

    public Rose(String color, double price, int freshness, int stemLength) {
        super("Rose", price, freshness, stemLength);
        this.color = color;
    }

    @Override
    public String toString() {
        return color + " Rose";
    }
}

class Tulip extends Flower {
    private String variety;

    public Tulip(String variety, double price, int freshness, int stemLength) {
        super("Tulip", price, freshness, stemLength);
        this.variety = variety;
    }

    @Override
    public String toString() {
        return variety + " Tulip";
    }
}

class Bouquet {
    private List<Flower> flowers = new ArrayList<>();

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public double calculateCost() {
        double totalCost = 0;
        for (Flower flower : flowers) {
            totalCost += flower.getPrice();
        }
        return totalCost;
    }

    public void sortByFreshness() {
        Collections.sort(flowers, (f1, f2) -> Integer.compare(f2.getFreshness(), f1.getFreshness()));
    }

    public Flower findFlowerByStemLength(int minLength, int maxLength) {
        for (Flower flower : flowers) {
            if (flower.getStemLength() >= minLength && flower.getStemLength() <= maxLength) {
                return flower;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Bouquet: ");
        for (Flower flower : flowers) {
            result.append(flower).append(", ");
        }

        result.delete(result.length() - 2, result.length());
        return result.toString();
    }
}

public class FlowerShop {
    public static void main(String[] args) {
        Rose redRose = new Rose("Red", 2.5, 2, 12);
        Tulip yellowTulip = new Tulip("Yellow", 1.8, 3, 10);
        Rose whiteRose = new Rose("White", 2.0, 7, 15);

        Bouquet bouquet = new Bouquet();
        bouquet.addFlower(redRose);
        bouquet.addFlower(yellowTulip);
        bouquet.addFlower(whiteRose);

        System.out.println("Bouquet cost: $" + bouquet.calculateCost());

        bouquet.sortByFreshness();
        System.out.println("Bouquet after sorting by freshness: " + bouquet);

        Flower foundFlower = bouquet.findFlowerByStemLength(10, 12);
        if (foundFlower != null) {
            System.out.println("Flower found by stem length: " + foundFlower);
        } else {
            System.out.println("No flower found in the specified stem length range.");
        }
    }
}
