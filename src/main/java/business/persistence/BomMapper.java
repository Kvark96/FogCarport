package business.persistence;

import business.entities.Material;
import business.entities.MeasureEntities;
import business.entities.StandardCarportEntities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BomMapper {

    Database database;

    public BomMapper(Database database) {
        this.database = database;
    }

    public List<Material> getMaterials() {
        List<Material> materialDescription = new ArrayList<>();
        try (Connection connection = database.connect()) {

            String sql = "select * from carport.materials;";


            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    int material_id = rs.getInt("materials_id");
                    String name = rs.getString("name");
                    int length = rs.getInt("length");
                    String unit = rs.getString("unit");
                    String desc = rs.getString("description");

                    materialDescription.add(new Material(material_id,name,length,unit,desc));

                }
                System.out.println(materialDescription.toString());
                return materialDescription;
            } catch (SQLException e) {
                throw new SQLException();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return materialDescription;

    }



}
