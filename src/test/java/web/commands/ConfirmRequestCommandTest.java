package web.commands;

import business.entities.Order;
import business.persistence.Database;
import business.persistence.UserMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;

import static java.time.Instant.now;
import static org.junit.jupiter.api.Assertions.*;

class ConfirmRequestCommandTest {
    private final static String DATABASE = "carport";  // Change this to your own database
    private final static String TESTDATABASE = DATABASE + "_test";
    private final static String USER = "root";
    private final static String PASSWORD = "herr1234";
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


            stmt.execute("drop table if exists orders" );
            stmt.execute("create table " + TESTDATABASE + ".orders LIKE " + DATABASE + ".orders;" );
            stmt.execute(
                    "insert into orders values " +
                            "(1,NULL ,900,1,1,300,450,NULL,NULL,NULL,NULL)," +
                            "(2,NULL ,5600,2,2,600,250,NULL,NULL,NULL,NULL)");


        } catch (SQLException ex) {
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }

    @Test
    void insertOrder() {

        Timestamp timestamp = Timestamp.from(Instant.now());
        Order order = new Order(3,timestamp,800,1,"",0);

        assertEquals(3, order.getOrder_id());

    }
}