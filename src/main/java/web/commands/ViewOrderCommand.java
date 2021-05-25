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

    private void setOrderOnRequest(HttpServletRequest request, HttpServletResponse response){
        String sql = "SELECT * FROM carport.standardcarport WHERE standard_id = ?";

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        List<Orderline> orderlines = new ArrayList<>();

        int order_id = Integer.parseInt(request.getParameter("order_id"));
        String type = request.getParameter("typeOfOrder");
        int length = -1, width = -1;

        try(Connection con = FrontController.database.connect()){
            String sql =
                    "SELECT length, width, price, users.email, orderline.quantity, orderline.orderline_id, orderline.materials_id FROM carport.orders " +
                            "JOIN carport.users ON orders.user_id = users.user_id " +
                            "LEFT JOIN carport.orderline ON orders.order_id = orderline.order_id " +
                            "WHERE orders.order_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, order_id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                length = (int) rs.getDouble("length");
                width = (int) rs.getDouble("width");
                double price = rs.getDouble("price");
                String user_email = rs.getString("email");
                int quantity = rs.getInt("quantity");
                int material_id = rs.getInt("materials_id");

                request.setAttribute("user_email", user_email);
                request.setAttribute("price", price);

                orderlines.add(new Orderline(order_id, quantity, length, material_id));
                System.out.println(orderlines.toString());
            }

            request.setAttribute("order_id", order_id);
            request.setAttribute("length", length);
            request.setAttribute("width", width);
            request.setAttribute("typeOfOrder", type);

        } catch (SQLException se){
            System.out.println("Failed to connect to database in ViewOrderCommand");
            System.out.println(se.getMessage());
        }

        return pageToShow;
    }
}
