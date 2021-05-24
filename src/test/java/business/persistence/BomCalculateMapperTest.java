package business.persistence;

import business.entities.CalculateNumbers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BomCalculateMapperTest {
    private final static String DATABASE = "carport";  // Change this to your own database
    private final static String TESTDATABASE = DATABASE + "_test";
    private final static String USER = "root";
    private final static String PASSWORD = "herr1234";
    private final static String URL = "jdbc:mysql://localhost:3306/" + TESTDATABASE + "?serverTimezone=CET&useSSL=false";

    private static Database database;
    private static BomCalculateMapper bomCalculateMapper;

    @BeforeAll
    public static void setUpClass() {
        try {
            database = new Database(USER, PASSWORD, URL);
            bomCalculateMapper = new BomCalculateMapper(database);
        } catch (ClassNotFoundException e) {   // kan ikke finde driveren i database klassen
            fail("Database connection failed. Missing jdbc driver");
        }
    }

    @Test
    void getDistance() {
        CalculateNumbers calculateNumbers = bomCalculateMapper.getCalculateNumbers();
        assertEquals(0.55, calculateNumbers.getDistanceMeasure());
    }


    @Test
    void getScrews() {
        CalculateNumbers calculateNumbers = bomCalculateMapper.getCalculateNumbers();
        assertEquals(200, calculateNumbers.getScrewPackageNumbers());
        assertEquals(13, calculateNumbers.getScrewKvm());
    }

    @Test
    void getPosts() {
        CalculateNumbers calculateNumbers = bomCalculateMapper.getCalculateNumbers();
        assertEquals(401, calculateNumbers.getPostPerLength());
        assertEquals(4, calculateNumbers.getMinimumPosts());
        assertEquals(6, calculateNumbers.getMaximumPosts());
    }
}