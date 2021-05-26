package business.entities;

import java.sql.*;
import java.util.List;

public class Order {
    private int order_id;
    private Timestamp created;
    private double price;
    private int user_id;
    private int customer_request;
    private String mail;
    private int width;
    private int length;
    private List<Orderline> orderlines;

    public Order(int order_id, Timestamp created, double price, int user_id, String mail, int customer_request) {
        this.order_id = order_id;
        this.created = created;
        this.price = price;
        this.user_id = user_id;
        this.customer_request = customer_request;
        this.mail = mail;
    }

    public List<Orderline> getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(List<Orderline> orderlines) {
        this.orderlines = orderlines;
    }

    public int getCustomer_request() {
        return customer_request;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getOrder_id() {
        return order_id;
    }

    public Timestamp getCreated() {
        return created;
    }

    public double getPrice() {
        return price;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getMail() {
        return mail;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
