package business.persistence;

import business.entities.Cart;
import business.entities.Order;
import business.entities.Orderline;
import web.FrontController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    private Database database;

    public OrderMapper(Database database) {
        this.database = database;
    }


    public void addOrderlineToDatabase(List<Orderline> lines) {

        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO orderline (order_id, quantity, standard_id) VALUES (?,?,?)";

            for (int i = 0; i < lines.size(); i++) {
                Orderline ol = lines.get(i);
                try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                    ps.setInt(1, ol.getOrder_id());
                    ps.setInt(2, ol.getQuantity());
                    ps.setInt(3, ol.getStandardCarportEntity().getStandard_id());
                    ps.executeUpdate();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }


    public void addOrderToDatabase(int user_id, int customer_request, Cart cart) {
        try (Connection connection = database.connect()) {

            String insertSql = "INSERT INTO carport.orders (user_id, customer_request, price) VALUES (?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(insertSql)) {
                ps.setInt(1, user_id);
                ps.setInt(2, customer_request);
                ps.setDouble(3, cart.calcPrice_());
                ps.execute();

            } catch (SQLException error) {
                System.out.println("Failed to add id to orders" + error.getMessage());
            }
        } catch (SQLException se) {
            System.out.println("Failed to Connect to DB in OrderMapper");
            se.printStackTrace();
        }
    }

    public void addOrderToDatabase(int user_id, int length, int width, int customer_request) {
        try (Connection connection = database.connect()) {

            String insertSql = "INSERT INTO carport.orders (user_id, customer_request,length,width) VALUES (?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(insertSql)) {
                ps.setInt(1, user_id);
                ps.setInt(2, customer_request);
                ps.setDouble(3, length);
                ps.setDouble(4, width);
                ps.execute();

            } catch (SQLException error) {
                System.out.println("Failed to add id to orders" + error.getMessage());
            }
        } catch (SQLException se) {
            System.out.println("Failed to Connect to DB in OrderMapper");
            se.printStackTrace();
        }
    }

    public int getLatestOrderIDFromUserID(int user_id) {
        String orderSql = "select order_id from orders where user_id = ? order by created desc";
        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(orderSql)) {
                ps.setInt(1, user_id);
                ResultSet rs = ps.executeQuery();
                rs.next();

                return rs.getInt("order_id");

            } catch (SQLException error) {
                System.out.println("Failed get order_id from database=" + error.getMessage());
            }
        } catch (SQLException se) {
            System.out.println("Failed to Connect to DB in OrderMapper");
            se.printStackTrace();
        }
        return -1;
    }

    public List<Order> getOrdersFromDatabase(int customer_request) {

        List<Order> orders = new ArrayList<>();

        try (Connection con = database.connect()) {
            String sql = "SELECT * FROM orders JOIN carport.users ON orders.user_id = users.user_id WHERE customer_request = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, customer_request);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int order_id = rs.getInt("order_id");
                Timestamp ts = rs.getTimestamp("created");
                double price = rs.getDouble("price");
                int user_id = rs.getInt("user_id");
                String mail = rs.getString("email");
                int type = rs.getInt("customer_request");
                orders.add(new Order(order_id, ts, price, user_id, mail, type));
            }
        } catch (SQLException se) {
            System.out.println("Failed to connect to database in OrderlistCommand");
            System.out.println(se.getMessage());
        }

        return orders;
    }

    public Order getOrderFromDatabase(int order_id) {
        Order order = null;
        try (Connection con = FrontController.database.connect()) {

            String sql =
                    "SELECT customer_request, users.user_id, orders.order_id, created, length, width, price, users.email, orderline.quantity, orderline.orderline_id, orderline.materials_id FROM carport.orders " +
                            "JOIN carport.users ON orders.user_id = users.user_id " +
                            "LEFT JOIN carport.orderline ON orders.order_id = orderline.order_id " +
                            "WHERE orders.order_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, order_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int length = (int) rs.getDouble("length");
                int width = (int) rs.getDouble("width");
                double price = rs.getDouble("price");
                String user_email = rs.getString("email");
                Timestamp timestamp = rs.getTimestamp("created");
                int user_id = rs.getInt("user_id");
                int customer_request = rs.getInt("customer_request");

                order = new Order(order_id, timestamp, price, user_id, user_email, customer_request);
                order.setWidth(width);
                order.setLength(length);
                return order;

                // int order_id, Timestamp created, double price, int user_id, String mail, String type
            }


        } catch (SQLException se) {
            System.out.println("Failed to connect to database in ViewOrderCommand");
            System.out.println(se.getMessage());
        }
        return order;
    }
}
