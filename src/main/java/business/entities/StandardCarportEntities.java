package business.entities;

public class StandardCarportEntities {


    int standard_id;
    String name;
    String description;
    int price;
    int calcPrice;



    public StandardCarportEntities(int standard_id, String name, String description, int price) {
        this.standard_id = standard_id;
        this.name = name;
        this.description = description;
        this.price = price;
        calcPrice = getCalcPrice();
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

    public int getCalcPrice() {
        return calcPrice;
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
