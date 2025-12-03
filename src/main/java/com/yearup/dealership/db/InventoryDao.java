package com.yearup.dealership.db;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InventoryDao {
    private DataSource dataSource;

    public InventoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicleToInventory(String vin, int dealershipId) {
        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into inventory (dealership,VIN) values (?,?) "
        )) {
            preparedStatement.setInt(1,dealershipId);
            preparedStatement.setString(2,vin);

            int rows = preparedStatement.executeUpdate();

            System.out.println(rows + " vehicle(s) added successfully.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void removeVehicleFromInventory(String vin) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM inventory WHERE vin = ?")) {
            preparedStatement.setString(1, vin);

            int rows = preparedStatement.executeUpdate();

            System.out.println(rows + " vehicle(s) deleted successfully.");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
