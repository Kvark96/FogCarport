package business.entities;

public class StandardCarportEntity {


   private int standard_id;
    private String name;
    private String description;
    private int price;
    private int calcPrice;
    private String img = "";


    public StandardCarportEntity(int standard_id, String name, String description, int price, String img) {
        this.standard_id = standard_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.img = img;
    }

    public String getImg() {
        return img;
    }
    public int getStandard_id() {
        return standard_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "StandardCarportEntities{" +
                "standard_id=" + standard_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
