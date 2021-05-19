package web.commands;

import business.entities.Cart;
import business.entities.StandardCarportEntities;
import business.persistence.CarportMapper;
import web.FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConfirmCartCommand extends CommandProtectedPage {
    public ConfirmCartCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }


    private void addStandartCarportToOrders(HttpServletRequest request, HttpServletResponse response) {

        int user_id = (int) request.getSession().getAttribute("user_id");
        int isARequest = 0;
        int standard_id = (int) request.getSession().getAttribute("standard_id");
        try (Connection connection = FrontController.database.connect()) {

            String insertSql = "INSERT INTO carport.orders (user_id, customer_request,standard_id) VALUES (?,?,?)";

            try (PreparedStatement ps = connection.prepareStatement(insertSql)) {
                ps.setInt(1, user_id);
                ps.setInt(2, isARequest);
                ps.setInt(3, standard_id);
                ps.execute();

            } catch (SQLException error) {
                System.out.println("Failed to add id to orders" + error.getMessage());
            }
        } catch (SQLException error) {
            System.out.println("Failed get order_id from database=" + error.getMessage());
        }
    }


        @Override
        public String execute (HttpServletRequest request, HttpServletResponse response) throws
        SQLException, NoSuchFieldException {

        addStandartCarportToOrders(request,response);


            return pageToShow;
        }
    }

