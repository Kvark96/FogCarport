package business.persistence;

import business.entities.CalculateNumbers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
                    int minimumPosts = rs.getInt("minimum_number_of_posts");
                    int maxPosts = rs.getInt("max_number_of_posts");

                    calculateNumbers = new CalculateNumbers(bomId, distanceMeasure, screwKvm, postPerLength, screwPackageNumbers,minimumPosts,maxPosts);

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
