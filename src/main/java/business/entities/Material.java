package business.entities;

public class Material {
    private int material_id;
    private String name;
    private int length;
    private int unit;
    private String description;

    public void setLength(int length) {
        this.length = length;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public Material(int material_id, String name, int length, int unit, String description) {
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

    public int getUnit() {
        return unit;
    }

    public String getDescription() {
        return description;
    }
}
