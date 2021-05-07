package web.commands;

import business.exceptions.UserException;
import web.FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConfirmRequestCommand extends CommandProtectedPage {


    public ConfirmRequestCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    private void addIdAndGetOrder_id(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int user_id = (int) request.getSession().getAttribute("user_id");
        try (Connection connection = FrontController.database.connect()) {

            String insertSql = "INSERT INTO carport.orders (user_id) VALUES (?)";
            try (PreparedStatement ps = connection.prepareStatement(insertSql)) {
                ps.setInt(1, user_id);
                ps.execute();

            } catch (SQLException se) {
                System.out.println("Failed to add to orders = ");
                System.out.println(se.getMessage());
            }


            String orderSql = "SELECT order_id FROM carport.orders WHERE order_id = ?";
            int order_id = 0;
            try (PreparedStatement ps = connection.prepareStatement(orderSql)) {
                ps.setInt(1,  order_id);
                ResultSet rs = ps.executeQuery();
                rs.next();
                request.getSession().setAttribute("order_ided", rs.getInt("order_id"));
            } catch (SQLException se) {
                System.out.println("Failed to retrieve order_id from database = ");
                System.out.println(se.getMessage());
            }
        } }


        public String execute( HttpServletRequest request,HttpServletResponse response) throws SQLException {
            //int length = Integer.parseInt(request.getParameter("length"));
          //  int width = Integer.parseInt(request.getParameter("width"));
            addIdAndGetOrder_id(request,response);

            return pageToShow;
        }



    }

