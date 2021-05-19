package business.entities;

public class Material {
    private int material_id;
    private String name;
    private int length;
    private String description;
    private String unit;



    public void setLength(int length) {
        this.length = length;
    }


    public Material(int material_id, String name, int length, String description, String unit) {
        this.material_id = material_id;
        this.name = name;
        this.length = length;
        this.description = description;
        this.unit = unit;

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


    public String getDescription() {
        return description;
    }

    public String getUnit() { return unit; }
}
