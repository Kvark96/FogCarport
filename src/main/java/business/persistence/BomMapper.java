package business.persistence;

import business.entities.Material;
import business.entities.MeasureEntities;
import business.entities.Orderline;
import business.entities.StandardCarportEntities;
import business.exceptions.UserException;
import com.sun.org.apache.xpath.internal.operations.Or;

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
                    String desc = rs.getString("description");
                    String unit = rs.getString("unit");

                    materialDescription.add(new Material(material_id,name,length,desc,unit));

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

    public List<Orderline> generateOrderlines(int order_id, List<Material> materials){
        List<Orderline> orderlines = new ArrayList<>();
        int i = 0;          // orderline_id
        for(Material m : materials){
            orderlines.add(new Orderline(order_id, ++i, m.getMaterial_id()));
        }
        return orderlines;
    }

    public void generateCarport(int orderid, int length, int width) {

        double antalRegner = ((double)length / 100.0) / 0.55;
        double antalSkruer = (double) length / 100.0 * (double) width/100.0 * 13.0 / 200.0;
        double widthCalculator = (double)width / 100.0;

        List<Material> materials = getMaterials();
        List<Orderline> orderlines = generateOrderlines(orderid, materials);

        for (Material m: materials) {
            if (m.getMaterial_id() == 5) {
                m.setLength(length);
            }

            if (m.getMaterial_id() == 6) {
                m.setLength(width);
                orderlines.get(6).setQuantity((int) Math.ceil(antalRegner));
                //m.setAmount((int) Math.ceil(antalRegner));
            }

            if (m.getMaterial_id() == 10) {
                orderlines.get(10).setQuantity((int) Math.ceil(widthCalculator));
                //m.setAmount((int) Math.ceil(widthCalculator));
            }

            if (m.getMaterial_id() == 11) {
                orderlines.get(11).setQuantity((int) Math.ceil(antalSkruer));
                //m.setAmount((int) Math.ceil(antalSkruer));
            }

            if (m.getMaterial_id() == 13) {
                orderlines.get(13).setQuantity((int) Math.ceil(antalRegner));
                //m.setAmount((int) Math.ceil(antalRegner));
            }
            if(m.getMaterial_id() == 14){
                orderlines.get(14).setQuantity((int) Math.ceil(antalRegner));
            }
        }


            try (Connection connection = database.connect()) {
                String sql = "INSERT INTO orderline (order_id, materials_materials_id, materials_length, materials_unit) VALUES (?,?,?,?)";

                for (int i = 0; i < materials.size(); i++) {

                    try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                        ps.setInt(1, orderid);
                        ps.setInt(2, materials.get(i).getMaterial_id());
                        ps.setInt(3, materials.get(i).getLength());

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
                    "JOIN carport.materials AS mt ON ol.materials_materials_id = mt.materials_id " +
                    "WHERE ol.order_id = " + orderId + ";";


            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    int material_id = rs.getInt("materials_id");
                    String name = rs.getString("name");
                    int length = rs.getInt("materials_length");
                    String desc = rs.getString("description");
                    String unit = rs.getString("unit");

                    materialDescription.add(new Material(material_id,name,length,desc,unit));

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