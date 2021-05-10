package business.entities;

public class Orderline {

    private int order_id, orderline_id, quantity, product_id;

    public Orderline(int order_id, int orderline_id, int quantity, int product_id) {
        this.order_id = order_id;
        this.orderline_id = orderline_id;
        this.quantity = quantity;
        this.product_id = product_id;
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

    public int getProduct_id() {
        return product_id;
    }
}
