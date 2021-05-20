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
                    int amount = rs.getInt("amount");
                    String desc = rs.getString("description");
                    String unit = rs.getString("unit");

                    materialDescription.add(new Material(material_id,name,length,amount,desc,unit));

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

        double antalRegner = ((double)length / 100.0) / 0.55;
        double antalSkruer = (double) length / 100.0 * (double) width/100.0 * 13.0 / 200.0;
        double widthCalculator = (double)width / 100.0;

        List<Material> materials = getMaterials();

        for (Material m: materials) {
            if (m.getMaterial_id() == 5) {
                m.setLength(length);
            }

            if (m.getMaterial_id() == 6) {
                m.setLength(width);
                m.setAmount((int) Math.ceil(antalRegner));
            }

            if (m.getMaterial_id() == 10) {
                m.setAmount((int) Math.ceil(widthCalculator));
            }

            if (m.getMaterial_id() == 11) {
                m.setAmount((int) Math.ceil(antalSkruer));
            }

            if (m.getMaterial_id() == 13 || m.getMaterial_id() == 14) {
                m.setAmount((int) Math.ceil(antalRegner));
            }
        }


        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO orderline (order_id, materials_id, materials_length, quantity) VALUES (?,?,?,?)";

            for (int i = 0; i < materials.size(); i++) {

                try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                    ps.setInt(1, orderid);
                    ps.setInt(2, materials.get(i).getMaterial_id());
                    ps.setInt(3, materials.get(i).getLength());
                    ps.setInt(4, materials.get(i).getAmount());

                    ps.executeUpdate();




                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public List<Material> getOrderLineMaterials(int orderId) {
        List<Material> materialDescription = new ArrayList<>();
        try (Connection connection = database.connect()) {

            String sql = "select * from carport.orderline AS ol " +
                    "JOIN carport.materials AS mt ON ol.materials_id = mt.materials_id " +
                    "WHERE ol.order_id = " + orderId + ";";


            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    int material_id = rs.getInt("materials_id");
                    String name = rs.getString("name");
                    int length = rs.getInt("materials_length");

                    int quantity = rs.getInt("quantity");
                    String desc = rs.getString("description");
                    String unit = rs.getString("unit");

                    materialDescription.add(new Material(material_id,name,length,quantity,desc,unit));

                }

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