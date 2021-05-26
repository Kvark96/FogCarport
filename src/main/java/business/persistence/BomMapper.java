package business.persistence;

import business.entities.*;
import business.services.CarportFacade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BomMapper {

    Database database;
    private CarportFacade carportFacade;

    public BomMapper(Database database) {
        this.database = database;
        this.carportFacade = new CarportFacade(database);

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

                    materialDescription.add(new Material(material_id, name, length, amount, desc, unit));

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



    public void insertCustomCartport(int orderid, List<Material> materials) {
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

            String sql = "select * from orderline AS ol " +
                    "JOIN materials AS mt ON ol.materials_id = mt.materials_id " +
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

                    materialDescription.add(new Material(material_id, name, length, quantity, desc, unit));

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

    public List<Orderline> getOrderlines(int order_id) {
        List<Orderline> orderlines = new ArrayList<>();
        String sql = "SELECT * FROM carport.orderline WHERE order_id = ?";
        try (Connection connection = database.connect()) {

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, order_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orderlines.add(new Orderline(
                        order_id,
                        rs.getInt("quantity"),
                        rs.getInt("materials_length"),
                        rs.getInt("materials_id"),
                        carportFacade.getCarportFromId(rs.getInt("standard_id"))));
            }

        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            throwables.printStackTrace();
        }
        return orderlines;
    }
}