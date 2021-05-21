package business.entities;

public class Orderline {

    private int order_id, orderline_id, quantity, material_id;
    private int length;

    public Orderline(int order_id, int quantity, int length, int material_id) {
        this.order_id = order_id;
        this.quantity = quantity;
        this.length = length;
        this.material_id = material_id;
    }

    @Override
    public String toString() {
        if(material_id > 9) return "";
        return "Orderline{ materials_id = " + material_id + ", quantity = " + quantity + ", length = " + length + " }\n";
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getOrderline_id() {
        return orderline_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMaterial_id() {
        return material_id;
    }
}
