package business.entities;

import web.FrontController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Orderline> orderlines;

    private int order_id;
    private Timestamp created;
    private double price;
    private int user_id;
    private String type;
    private String mail;

    public Order(int order_id, Timestamp created, double price, int user_id, String type) {
        this.order_id = order_id;
        this.created = created;
        this.price = price;
        this.user_id = user_id;
        this.type = type;
        orderlines = new ArrayList<>();
        mail = getUserMail();
    }

    private String getUserMail() {
        try(Connection con = FrontController.database.connect()){
            String sql = "SELECT mail FROM carport.users WHERE user_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString(1);
        } catch(SQLException se){
            System.out.println(se.getMessage());
            return se.getMessage();
        }
    }

    public void addOrderline(Orderline o){
        orderlines.add(o);
    }

    public List<Orderline> getOrderlines() {
        return orderlines;
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

    public String getType() {
        return type;
    }

    public String getMail() {
        return mail;
    }
}
