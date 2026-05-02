public class Ingredient {
    private String name;
    private String unit;

    // Konstruktor
    public Ingredient(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }

    // Getterek
    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return name + " (" + unit + ")";
    }
}