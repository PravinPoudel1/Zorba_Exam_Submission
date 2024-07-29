import java.lang.module.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RailwayReservation {

    public static void main(String[] args) {
        Connection CONNECTION = null;
        String dburl1 = "jdbc:mysql://localhost:3306/railway_reservation_db";
        String username = "root";
        String password = "Cypress@123";

        try {
            //load the mysql driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // creating connection to Mysql Database
            Connection Connection = DriverManager.getConnection(dburl1, username, password);


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}





