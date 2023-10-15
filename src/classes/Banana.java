package classes;

public class Banana extends Fruit {

    private String ripeness;

    public Banana(String ID, int weight, int basePrice, String ripeness) {
        super(ID, weight, basePrice);
        this.ripeness = ripeness;
    }

    public String getRipeness() {
        return this.ripeness;
    }

    public void setRipeness(String ripeness) {
        this.ripeness = ripeness;
    }

    @Override
    public double getMultiplier() {

        // get multiplier based on banana's ripeness
        switch (getRipeness()) {
            case "Overripe":
                return 1.3;
            
            case "Semi-ripe":
                return 1;

            case "Ripe":
                return 0.8;

            case "Unripe":
                return 0.6;
        
            default:
                return 0;
        }
    }

    @Override
    public double getPrice() { // calculate price
        return (getBasePrice() * getMultiplier()) + (getWeight() * 1.2);
    }

    @Override
    public String toString() {
        return String.format("| %5s | %10s | %7s | %15s | %15s |\n", getID(), "Banana", getWeight(), "-", getRipeness());
    }
}   
