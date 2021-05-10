package web.commands;

import business.entities.Order;
import web.FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderlistCommand extends CommandProtectedPage{
    public OrderlistCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        List<Order> orders = new ArrayList<>();

        try(Connection con = FrontController.database.connect()){
            String sql = "SELECT * FROM orders WHERE customer_request = 0";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int order_id = rs.getInt("order_id");
                Timestamp ts = rs.getTimestamp("created");
                double price = rs.getDouble("price");
                int user_id = rs.getInt("user_id");
                String type = rs.getInt("customer_request") == 1 ? "Forespørgsel" : "Ordre";
                orders.add(new Order(order_id, ts, price, user_id, type));
            }

            request.setAttribute("orders", orders);

        } catch (SQLException se){
            System.out.println("Failed to connect to database in OrderlistCommand");
            System.out.println(se.getMessage());
        }

        return pageToShow;
    }
}
