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
        int isARequest =(int) request.getSession().getAttribute("isARequest");
        try (Connection connection = FrontController.database.connect()) {

            String insertSql = "INSERT INTO carport.orders (user_id, customer_request) VALUES (?,?)";
            try (PreparedStatement ps = connection.prepareStatement(insertSql)) {
                ps.setInt(1, user_id);
                ps.setInt(2, isARequest);
                ps.execute();

            } catch (SQLException error) {
                System.out.println("Failed to add id to orders" +error.getMessage());
            }


            String orderSql = "SELECT order_id FROM carport.orders WHERE user_id = ? order by order_id desc";

            try (PreparedStatement ps = connection.prepareStatement(orderSql)) {
                ps.setInt(1,  user_id);
                ResultSet rs = ps.executeQuery();
                rs.next();
                request.getSession().setAttribute("order_id", rs.getInt("order_id"));
                System.out.println(request.getSession().getAttribute("order_id"));
            } catch (SQLException error) {
                System.out.println("Failed get order_id from database="+ error.getMessage());
            }
        }






    }






        public String execute( HttpServletRequest request,HttpServletResponse response) throws SQLException {
            //int length = Integer.parseInt(request.getParameter("length"));
          //  int width = Integer.parseInt(request.getParameter("width"));
           //  addIdAndGetOrder_id(request,response);

            addIdAndGetOrder_id(request,response);

            return pageToShow;
        }



    }

