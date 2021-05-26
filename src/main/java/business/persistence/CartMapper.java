package business.persistence;

import web.FrontController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartMapper {
    Database database;
    public CartMapper(Database database){
        this.database = database;
    }

    public void addStandardCarportToOrders(int user_id, int isARequest, int standard_id, int price) {
        try (Connection connection = FrontController.database.connect()) {

            String insertSql = "INSERT INTO carport.orders (user_id, customer_request,standard_id, price) VALUES (?,?,?,?)";

            try (PreparedStatement ps = connection.prepareStatement(insertSql)) {
                ps.setInt(1, user_id);
                ps.setInt(2, isARequest);
                ps.setInt(3, standard_id);
                ps.setInt(4, price);
                ps.execute();

            } catch (SQLException error) {
                System.out.println("Failed to add id to orders" + error.getMessage());
            }
        } catch (SQLException error) {
            System.out.println("Failed get order_id from database=" + error.getMessage());
        }
    }
}
