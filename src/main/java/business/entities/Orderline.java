package business.entities;

public class Orderline {

    private int order_id, orderline_id, quantity, material_id;

    public Orderline(int order_id, int orderline_id, int quantity, int material_id) {
        this.order_id = order_id;
        this.orderline_id = orderline_id;
        this.quantity = quantity;
        this.material_id = material_id;
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
