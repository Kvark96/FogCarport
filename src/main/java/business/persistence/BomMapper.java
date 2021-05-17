package business.persistence;

import business.entities.Material;
import business.entities.MeasureEntities;
import business.entities.Orderline;
import business.entities.StandardCarportEntities;
import business.exceptions.UserException;

import java.sql.*;
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
                    int unit = rs.getInt("unit");
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

    public void generateCarport(int orderid, int length, int width) {

        double antalRegner = (length / 100) / 0.55;
        double antalSkruer = length * width * 13 / 200;
        double widthCalculator = width / 100;

        List<Material> materials = getMaterials();

        for (Material m: materials) {
            if (m.getMaterial_id() == 5) {
                m.setLength(length);
            }

            if (m.getMaterial_id() == 6) {
                m.setLength(width);
                m.setUnit((int) Math.ceil(antalRegner));
            }

            if (m.getMaterial_id() == 10) {
                m.setUnit((int) Math.ceil(widthCalculator));
            }

            if (m.getMaterial_id() == 11) {
                m.setUnit((int) Math.ceil(antalSkruer));
            }

            if (m.getMaterial_id() == 13 || m.getMaterial_id() == 14) {
                m.setUnit((int) Math.ceil(antalRegner));
            }
        }


            try (Connection connection = database.connect()) {
                String sql = "INSERT INTO orderline (orderline_id, order_id, materials_materials_id) VALUES (?,?,?)";

                for (int i = 0; i > materials.size(); i++) {

                    try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                        ps.setInt (1, orderid);
                        ps.setInt (2, materials.get(i).getMaterial_id());

                        ps.executeUpdate();


                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

    }
}
