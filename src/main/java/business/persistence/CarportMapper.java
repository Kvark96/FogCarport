package business.persistence;

import business.entities.MeasureEntities;
import business.entities.StandardCarportEntities;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarportMapper {

    Database database;
    List<StandardCarportEntities> standardCarportEntities;

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


    public List<StandardCarportEntities> getStandardCarportEntities() {
        standardCarportEntities = new ArrayList<>();
        try (Connection connection = database.connect()) {

            String sql = "SELECT * FROM carport.standardcarport;";


            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    int standard_id = rs.getInt("standard_id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    int price = rs.getInt("price");

                    standardCarportEntities.add(new StandardCarportEntities(standard_id, name, description, price));

                }
                System.out.println(standardCarportEntities.toString());
                return standardCarportEntities;
            } catch (SQLException e) {
                throw new SQLException();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return standardCarportEntities;
    }

    public StandardCarportEntities getCarportFromId(int id) throws NoSuchFieldException {
        for (StandardCarportEntities s : standardCarportEntities) {
            if (s.getStandard_id() == id) {
                return s;
            }

        }
      throw new NoSuchFieldException();

    }
}
