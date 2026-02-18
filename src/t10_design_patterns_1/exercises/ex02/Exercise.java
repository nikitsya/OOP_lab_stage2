package t10_design_patterns_1.exercises.ex02;

interface PriceStrategy {
    double finalPrice(double basePrice);
}

class NoDiscount implements PriceStrategy {
    @Override
    public double finalPrice(double basePrice) {
        return basePrice;
    }
}

class StudentDiscount implements PriceStrategy {
    @Override
    public double finalPrice(double basePrice) {
        return basePrice * 0.9;
    }
}

class BlackFridayDiscount implements PriceStrategy {
    @Override
    public double finalPrice(double basePrice) {
        double discounted = basePrice * 0.7;
        return Math.max(discounted, 5.0);
    }
}

class Checkout {

    PriceStrategy pricing;

    public Checkout(PriceStrategy pricing) {
        this.pricing = pricing;
    }
    public double price(double basePrice) {
        return pricing.finalPrice(basePrice);
    }
}

public class Exercise {
    public static void run() {
        double[] basePrices = new double[] { 10.00, 4.00 };

        Checkout none = new Checkout(new NoDiscount());
        Checkout student = new Checkout(new StudentDiscount());
        Checkout bf = new Checkout(new BlackFridayDiscount());

        for (double p : basePrices) {
            System.out.println("Base " + p + " -> none: " + none.price(p));
            System.out.println("Base " + p + " -> student: " + student.price(p));
            System.out.println("Base " + p + " -> black friday: " + bf.price(p));
        }
    }
}
