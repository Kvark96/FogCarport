package business.persistence;

import business.entities.Order;
import business.entities.PreviousOrder;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreviousOrdersMapper {


    Database database;
    public PreviousOrdersMapper(Database database){
        this.database = database;
    }


    public List<PreviousOrder> getOldOrders(int user_id) {
        List<Order> orders = new ArrayList<>();
        List<PreviousOrder> oldOrders = new ArrayList<>();

        try(Connection con = database.connect()) {
            String sql = "SELECT * FROM orders WHERE user_id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, user_id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    Timestamp created = rs.getTimestamp("created");
                    double price = rs.getDouble("price");
                    int order_id = rs.getInt("order_id");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    String type = rs.getString("roof_type");

                    orders.add(new Order(order_id, created, price, user_id, type));
                    oldOrders.add(new PreviousOrder(order_id,created,price,user_id,type,length,width));


                }
                return oldOrders;
            } catch (SQLException e) {
            throw new SQLException();
        }

        }catch (SQLException se){
            System.out.println("Failed to connect to database in ViewOrderCommand");
            System.out.println(se.getMessage());
        }

        return oldOrders;
    }
}
