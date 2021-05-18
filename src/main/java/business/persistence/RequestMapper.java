package business.persistence;

import business.entities.MeasureEntities;
import web.FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequestMapper {

    Database database;

    public RequestMapper(Database database) throws SQLException {
        this.database = database;
    }

    public void insertRequest(int length, int width) {
        try (Connection connection = database.connect()) {


            String sql = "INSERT INTO carport.orders  (order_id ,length,width) VALUES (?,?,?);";

            PreparedStatement ps = connection.prepareStatement(sql);


            ps.setDouble(1, length);
            ps.setDouble(2, width);
            ps.execute();
            System.out.println("insert request executed");

        } catch (SQLException ex) {
            ex.printStackTrace();

        }




    }
}




