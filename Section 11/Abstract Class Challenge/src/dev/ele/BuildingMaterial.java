package dev.ele;

public class BuildingMaterial extends ProductForSale {
    public String material;
    public boolean waterResistant;

    public BuildingMaterial(String material, boolean waterResistant, String type, double price, String description) {
        super(type, price, description);
        this.material = material;
        this.waterResistant = waterResistant;
    }

    @Override
    public void showDetails() {
        String isWaterResistantString = waterResistant ? "is water Resistant" : "is not water resistant";
        System.out.printf(
                "TYPE: %s%nPRICE: %s%nMATERIAL: %s%nWATER RESISTANT: %s%nDESCRIPTION: %s%n",
                this.getType(), this.getPrice(), this.material, isWaterResistantString,
                this.getDescription());
    }

    /**
     * @return the material
     */
    public String getMaterial() {
        return material;
    }

    /**
     * @return the waterResistant
     */
    public boolean isWaterResistant() {
        return waterResistant;
    }
}