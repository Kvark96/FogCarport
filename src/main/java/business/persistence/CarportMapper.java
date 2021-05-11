package business.persistence;

import business.entities.MeasureEntities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarportMapper {

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
                System.out.println(measureEntitiesList.toString());
                return measureEntitiesList;
            } catch (SQLException e) {
                throw new SQLException();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return measureEntitiesList;
    }

}
