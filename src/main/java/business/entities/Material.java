package business.entities;

public class Material {
    private String description, name, unit;
    private int materials_id, length, quantity;

    public Material(String description, String name, String unit, int materials_id, int length, int quantity) {
        this.description = description;
        this.name = name;
        this.unit = unit;
        this.materials_id = materials_id;
        this.length = length;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public int getMaterials_id() {
        return materials_id;
    }

    public int getLength() {
        return length;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Material{" +
                "description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", materials_id=" + materials_id +
                ", length=" + length +
                ", quantity=" + quantity +
                '}';
    }
}
