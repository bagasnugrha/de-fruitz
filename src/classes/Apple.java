package classes;

public class Apple extends Fruit {

    private String variety;

    public Apple(String ID, int weight, int basePrice, String variety) {
        super(ID, weight, basePrice);
        this.variety = variety;
    }

    public String getVariety() {
        return this.variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    @Override
    public double getMultiplier() {
        
        // get multiplier based on apple's variety        
        switch (getVariety()) {
            case "Fuji":
                return 1.6;
            
            case "Honeycrisp":
                return 2;

            case "Gala":
                return 1.3;

            case "Golden Delicious":
                return 2;
        
            default:
                return 0;
        }
    }

    @Override
    public double getPrice() { // calculate price
        return (getBasePrice() * getMultiplier()) + (getWeight() * 1.4);
    }
    
    @Override
    public String toString() {
        return String.format("| %5s | %10s | %7s | %15s | %15s |\n", getID(), "Apple", getWeight(), getVariety(), "-");
    }
}