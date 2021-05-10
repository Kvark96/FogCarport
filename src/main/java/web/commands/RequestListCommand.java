package web.commands;

import business.entities.Order;
import web.FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestListCommand extends CommandProtectedPage{
    public RequestListCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        List<Order> requestList = new ArrayList<>();

        try(Connection con = FrontController.database.connect()){
            String sql = "SELECT * FROM orders WHERE customer_request = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int order_id = rs.getInt("order_id");
                Timestamp ts = rs.getTimestamp("created");
                double price = rs.getDouble("price");
                int user_id = rs.getInt("user_id");
                requestList.add(new Order(order_id, ts, price, user_id, "Forespørgsel"));
            }

            request.setAttribute("requestList", requestList);

        } catch (SQLException se){
            System.out.println("Failed to connect to database in RequestListCommand");
            System.out.println(se.getMessage());
        }

        return pageToShow;
    }
}
