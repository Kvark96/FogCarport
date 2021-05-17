package business.entities;

public class Material {
    private int material_id;
    private String name;
    private int length;
    private String unit;
    private String description;

    public Material(int material_id, String name, int length, String unit, String description) {
        this.material_id = material_id;
        this.name = name;
        this.length = length;
        this.unit = unit;
        this.description = description;
    }

    public int getMaterial_id() {
        return material_id;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public String getUnit() {
        return unit;
    }

    public String getDescription() {
        return description;
    }
}
