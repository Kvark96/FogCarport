package business.persistence;

import business.entities.MeasureEntities;
import business.entities.StandardCarportEntity;
import web.FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarportMapper  {

    Database database;


    public CarportMapper(Database database) {
        this.database = database;
    }



    public List<MeasureEntities> getMeasureEntities() {
        List<MeasureEntities> measureEntitiesList = new ArrayList<>();
        try (Connection connection = database.connect()) {

            String sql = "select * from carport.measures;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    int measureId = rs.getInt("measure_id");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");

                    measureEntitiesList.add(new MeasureEntities(measureId, length, width));

                }
                return measureEntitiesList;
            } catch (SQLException e) {
                throw new SQLException();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return measureEntitiesList;
    }



    public List<StandardCarportEntity> getStandardCarportEntitiesList() {
        List<StandardCarportEntity> standardCarportEntityList = new ArrayList<>();
        try (Connection connection = database.connect()) {

            String sql = "SELECT * FROM carport.standardcarport;";


            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    int standard_id = rs.getInt("standard_id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    int price = rs.getInt("price");
                    String img = rs.getString("img");

                    standardCarportEntityList.add(new StandardCarportEntity(standard_id, name, description, price, img));

                }
                return standardCarportEntityList;
            } catch (SQLException e) {
                throw new SQLException();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return standardCarportEntityList;
    }


    /*
    private void addIdAndGetOrder_id(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int user_id = (int) request.getSession().getAttribute("user_id");
        int isARequest = (int) request.getSession().getAttribute("isARequest");
        int length = (int) request.getSession().getAttribute("length");
        int width = (int) request.getSession().getAttribute("width");
        try (Connection connection = FrontController.database.connect()) {

            String insertSql = "INSERT INTO carport.orders (user_id, customer_request,length,width) VALUES (?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(insertSql)) {
                ps.setInt(1, user_id);
                ps.setInt(2, isARequest);
                ps.setDouble(3, length);
                ps.setDouble(4, width);
                ps.execute();

            } catch (SQLException error) {
                System.out.println("Failed to add id to orders" + error.getMessage());
            }


            String orderSql = "SELECT order_id FROM carport.orders WHERE user_id = ? order by order_id desc";

            try (PreparedStatement ps = connection.prepareStatement(orderSql)) {
                ps.setInt(1, user_id);
                ResultSet rs = ps.executeQuery();
                rs.next();
                request.setAttribute("order_id", rs.getInt("order_id")); // THIS WAS CHANGED FROM SESSIONSCOPE

                bomMapper.generateCarport(rs.getInt("order_id"), length, width);

                System.out.println(request.getSession().getAttribute("order_id"));
            } catch (SQLException error) {
                System.out.println("Failed get order_id from database=" + error.getMessage());
            }
        }

    }

    */

}
