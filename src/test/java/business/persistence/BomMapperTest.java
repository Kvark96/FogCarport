package business.persistence;


import business.entities.Material;
import business.services.BomFacade;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import web.FrontController;

import java.sql.*;
import java.time.Instant;
import java.util.List;
import java.sql.Timestamp;



import static org.junit.jupiter.api.Assertions.*;

public class BomMapperTest {


    private final static String DATABASE = "carport";  // Change this to your own database
    private final static String TESTDATABASE = DATABASE + "_test";
    private final static String USER = "root";
    private final static String PASSWORD = "herr1234";
    private final static String URL = "jdbc:mysql://localhost:3306/" + TESTDATABASE + "?serverTimezone=CET&useSSL=false";

    private static Database database;
    private static BomMapper bomMapper;
    private  static BomFacade bomFacade;

    @BeforeAll
    public static void setUpClass() {
        try {
            database = new Database(USER, PASSWORD, URL);
            bomMapper = new BomMapper(database);
            bomFacade = new BomFacade(database);
        } catch (ClassNotFoundException e) {   // kan ikke finde driveren i database klassen
            fail("Database connection failed. Missing jdbc driver");
        }
    }

    @BeforeEach
    void setUp() {
        Timestamp setTimestamp = Timestamp.from(Instant.now());
        // reset test database
        try (Statement stmt = database.connect().createStatement()) {
          //  stmt.execute("drop table if exists orderline ");
            //stmt.execute("drop table if exists orders ");<
            //stmt.execute("drop table if exists users");
            stmt.execute("create table " + TESTDATABASE + ".users LIKE " + DATABASE + ".users;");
            stmt.execute(
                    "insert into users values " +
                            "(1,'jens','jens@somewhere.com','jensen','customer','111','vej','1234'), " +
                            "(2,'Peter','ken@somewhere.com','kensen','customer','123','vej','1234'), " +
                            "(4,'HH','robin@somewhere.com','batman','employee','444','vej','1234')");
            stmt.execute("create table " + TESTDATABASE + ".orders LIKE " + DATABASE + ".orders;");
            stmt.execute("insert into orders values " +
                    " (1, '2021-05-10 20:00:00', 0, 1, 0, 420, 420), " +
                    " (2, '2021-05-10 20:01:00', 0, 1, 0, 320, 320)" );
            stmt.execute("create table " + TESTDATABASE + ".orderline LIKE " + DATABASE + ".orderline;");


        } catch (SQLException ex) {
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }
    }

    @Test
    void TestOrderlineCreation() {
        bomFacade.generateCarport(1, 420, 420);
        List<Material> materials = bomMapper.getOrderLineMaterials(1);

        assertNotEquals(0, materials.size());

    }

    @Test
    void TestMaterialValuesOfIdSix() {

        bomFacade.generateCarport(1,420,420);       //Can't create Order-object
        bomFacade.generateCarport(2, 320, 320);
        List<Material> materials = bomMapper.getOrderLineMaterials(1);
        List<Material> materials1 = bomMapper.getOrderLineMaterials(2);

        assertEquals(8, materials.get(5).getAmount());
        assertEquals(6, materials1.get(5).getAmount());

    }

    @Test
    void TestMaterialValuesOfIdSeven() {

        bomFacade.generateCarport(1,420,420);       //Can't create Order-object
        bomFacade.generateCarport(2, 320, 320);
        List<Material> materials = bomMapper.getOrderLineMaterials(1);
        List<Material> materials1 = bomMapper.getOrderLineMaterials(2);

        assertEquals(6, materials.get(6).getAmount());
        assertEquals(4, materials1.get(6).getAmount());

    }

    @Test
    void TestMaterialValuesOfIdTen() {

        bomFacade.generateCarport(1,420,420);       //Can't create Order-object
        bomFacade.generateCarport(2, 320, 320);
        List<Material> materials = bomMapper.getOrderLineMaterials(1);
        List<Material> materials1 = bomMapper.getOrderLineMaterials(2);

        assertEquals(5, materials.get(9).getAmount());
        assertEquals(4, materials1.get(9).getAmount());

    }

    @Test
    void TestMaterialValuesOfIdEleven() {

        bomFacade.generateCarport(1,420,420);       //Can't create Order-object
        bomFacade.generateCarport(2, 320, 320);
        List<Material> materials = bomMapper.getOrderLineMaterials(1);
        List<Material> materials1 = bomMapper.getOrderLineMaterials(2);

        assertEquals(2, materials.get(10).getAmount());
        assertEquals(1, materials1.get(10).getAmount());

    }
}

