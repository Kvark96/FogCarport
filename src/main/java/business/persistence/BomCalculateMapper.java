package business.persistence;

import business.entities.CalculateNumbers;
import business.entities.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BomCalculateMapper {

    Database database;

    public BomCalculateMapper(Database database) {
        this.database = database;
    }

    public CalculateNumbers getCalculateNumbers() {

        CalculateNumbers calculateNumbers = null;

        try (Connection connection = database.connect()) {

            String sql = "select * from bomcalculator;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    int bomId = rs.getInt("bom_id");
                    double distanceMeasure = rs.getDouble("distance_Measure");
                    int screwKvm = rs.getInt("screw_kvm");
                    int postPerLength = rs.getInt("post_length_for_amount");
                    int screwPackageNumbers = rs.getInt("screw_package_numbers");

                    calculateNumbers = new CalculateNumbers(bomId, distanceMeasure, screwKvm, postPerLength, screwPackageNumbers);

                }

                return calculateNumbers;

            } catch (SQLException e) {
                throw new SQLException();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return calculateNumbers;
    }




}
