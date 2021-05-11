package web.commands;

import business.entities.Orderline;
import web.FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViewOrderCommand extends CommandProtectedPage{
    public ViewOrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        List<Orderline> orderlines = new ArrayList<>();

        int order_id = Integer.parseInt(request.getParameter("order_id"));
        String type = request.getParameter("typeOfOrder");

        try(Connection con = FrontController.database.connect()){
            String sql = "SELECT product_id, quantity, orders.price, email, orderline.orderline_id FROM carport.orderline JOIN carport.orders ON orderline.order_id = orders.order_id JOIN carport.users ON orders.user_id = users.user_id WHERE orders.order_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, order_id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                String user_email = rs.getString("email");
                request.setAttribute("user_email", user_email);

                double price = rs.getDouble("price");
                request.setAttribute("price", price);

                request.setAttribute("order_id", order_id);

                int orderline_id = rs.getInt("orderline_id");
                int quantity = rs.getInt("quantity");
                int product_id = rs.getInt("product_id");

                orderlines.add(new Orderline(order_id, orderline_id, quantity, product_id));
            }

            request.setAttribute("orderlines", orderlines);
            request.setAttribute("typeOfOrder", type);

        } catch (SQLException se){
            System.out.println("Failed to connect to database in ViewOrderCommand");
            System.out.println(se.getMessage());
        }

        return pageToShow;
    }
}
