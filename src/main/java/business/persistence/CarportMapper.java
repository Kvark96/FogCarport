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
                System.out.println(e.getMessage());
                throw new SQLException();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return standardCarportEntityList;
    }
}
