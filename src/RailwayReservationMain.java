import Reversation.Reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class RailwayReservationMain {
  public static void main(String[] args) {

      String dburl1 = "jdbc:mysql://localhost:3306/railway_reservation_db";
      String username = "root";
      String password = "Cypress@123";

      Connection connection = null;
      try {
          // Load the MySQL driver
          Class.forName("com.mysql.cj.jdbc.Driver");

          // Creating connection to MySQL Database
          connection = DriverManager.getConnection(dburl1, username, password);

          // Connection successful
          System.out.println("Connected to the database!");

          String sql = "INSERT INTO railway_reservation (passenger_name, passenger_age, chosen_seat, reservation_type, is_senior_citizen, amount_paid) VALUES (?, ?, ?, ?, ?, ?)";
          try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

              Reservation reservation = new Reservation("Sanju Sharma", 30, "A1", "First Class", false, 100.0);

              pstmt.setString(1, reservation.getPassengerName());
              pstmt.setInt(2, reservation.getPassengerAge());
              pstmt.setString(3, reservation.getChosenSeat());
              pstmt.setString(4, reservation.getTypeOfReservation());
              pstmt.setBoolean(5, reservation.isSeniorCitizen());
              pstmt.setDouble(6, reservation.getAmountPaid());
              pstmt.executeUpdate();
          } catch (SQLException e) {
              e.printStackTrace();
              System.out.println(e.getMessage());
          }

      } catch (ClassNotFoundException | SQLException e) {
          e.printStackTrace();
      } finally {
          if (connection != null) {
              try {
                  connection.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }
      }
  }

    public void updateSeniorCitizenStatus(String passengerName, boolean isSeniorCitizen) {
        String dburl1 = "jdbc:mysql://localhost:3306/railway_reservation_db";
        String username = "root";
        String password = "Cypress@123";

        String sql = "UPDATE railway_reservation SET is_senior_citizen = ? WHERE passenger_name = ?";
        try (Connection conn = DriverManager.getConnection(dburl1, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setBoolean(1, isSeniorCitizen);
            pstmt.setString(2, passengerName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAmountPaid(String passengerName, double amountPaid) {
        String dburl1 = "jdbc:mysql://localhost:3306/railway_reservation_db";
        String username = "root";
        String password = "Cypress@123";

        String sql = "UPDATE railway_reservation SET amount_paid = ? WHERE passenger_name = ?";
        try (Connection conn = DriverManager.getConnection(dburl1, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, amountPaid);
            pstmt.setString(2, passengerName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

            System.out.println(e.getMessage());
        }
    }
}






