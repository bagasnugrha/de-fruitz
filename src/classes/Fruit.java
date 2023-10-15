package classes;

public abstract class Fruit {

    private String ID;
    private int weight;
    private double basePrice;

    public Fruit(String ID, int weight, double basePrice) {
        this.ID = ID;
        this.weight = weight;
        this.basePrice = basePrice;
    }

    // abstract methods
    public abstract double getPrice();
    public abstract double getMultiplier();

    // setters getters
    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getBasePrice() {
        return this.basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
    
}
