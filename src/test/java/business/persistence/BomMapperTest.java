package business.persistence;


import business.entities.Material;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

public class BomMapperTest {


    private final static String DATABASE = "carport";  // Change this to your own database
    private final static String TESTDATABASE = DATABASE + "_test";
    private final static String USER = "root";
    private final static String PASSWORD = "Cph73128";
    private final static String URL = "jdbc:mysql://localhost:3306/" + TESTDATABASE + "?serverTimezone=CET&useSSL=false";

    private static Database database;
    private static UserMapper userMapper;

    @BeforeAll
    public static void setUpClass() {
        try {
            database = new Database(USER, PASSWORD, URL);
            userMapper = new UserMapper(database);
        } catch (ClassNotFoundException e) {   // kan ikke finde driveren i database klassen
            fail("Database connection failed. Missing jdbc driver");
        }
    }

    @BeforeEach
    void setUp() {
        // reset test database
        try ( Statement stmt = database.connect().createStatement() ) {
            stmt.execute("drop table if exists users" );
            stmt.execute("create table " + TESTDATABASE + ".users LIKE " + DATABASE + ".users;" );
            stmt.execute(
                    "insert into users values " +
                            "(1,'jens','jens@somewhere.com','jensen','customer','111','vej','1234'), " +
                            "(2,'Peter','ken@somewhere.com','kensen','customer','123','vej','1234'), " +
                            "(4,'HH','robin@somewhere.com','batman','employee','444','vej','1234')");



            // generate carport
            // reset test database

                stmt.execute("drop table if exists orderline" );
                stmt.execute("create table " + TESTDATABASE + ".orderline LIKE " + DATABASE + ".orderline;" );
                stmt.execute(
                        "insert into orderline values " +
                                "(1,1,1,1,1), " +
                                "(2,2,2,2,2), " +
                                "(3,3,3,3,3)");

            stmt.execute("drop table if exists materials" );
            stmt.execute("create table " + TESTDATABASE + ".materials LIKE " + DATABASE + ".materials;" );
            stmt.execute(
                    "insert into materials values " +
                            "(1,'25x200 mm. trykimp. Brædt',360,4,'Understernbrædder til for & bag ende','stk')," +
                            "(2,'tsk',540,4,'something','stk'), " +
                            "(3,'tsk',360,2,'something','stk'), " +
                            "(4,'tsk',540,4,'something','stk'), " +
                            "(5,'tsk',0,2,'something','stk'), " +
                            "(6,'tsk',0,0,'something','stk'), " +
                            "(7,'tsk',300,6,'something','stk'), " +
                            "(8,'tsk',540,4,'something','stk'), " +
                            "(9,'tsk',360,2,'something','stk'), " +
                            "(10,'tsk',600,0,'something','stk'), " +
                            "(11,'tsk',NULL,0,'something','stk'), " +
                            "(12,'tsk',1000,2,'something','stk'), " +
                            "(13,'tsk',NULL,0,'something','stk'), " +
                            "(14,'tsk',NULL,0,'something','stk'), " +
                            "(15,'tsk',NULL,1,'something','stk'), " +
                            "(16,'tsk',NULL,1,'something','stk'), " +
                            "(17,'tsk',NULL,12,'something','stk'), " +
                            "(18,'tsk',NULL,12,'something2','stk')");


        } catch (SQLException ex) {
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }
    // reset test database

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

   @Test
    void generateCarport(int length, int width) {
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
                assertEquals(4,  antalRegner);
            }
        }

    }
}