package com.yearup.dealership.db;

import com.yearup.dealership.models.Vehicle;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private DataSource dataSource;

    public VehicleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicle(Vehicle vehicle) {
        try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into vehicles (vin,make,model, year, sold, color, vehicleType,odometer,price) " +
                        " values (?,?,?,?,?,?,?,?,?)"
        )) {
            preparedStatement.setString(1,vehicle.getVin());
            preparedStatement.setString(2,vehicle.getMake());
            preparedStatement.setString(3,vehicle.getModel());
            preparedStatement.setInt(4,vehicle.getYear());
            preparedStatement.setBoolean(5,vehicle.isSold());
            preparedStatement.setString(6,vehicle.getColor());
            preparedStatement.setString(7,vehicle.getVehicleType());
            preparedStatement.setInt(8,vehicle.getOdometer());
            preparedStatement.setDouble(9, vehicle.getPrice());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeVehicle(String VIN) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM vehicles WHERE vin = ?")) {
            preparedStatement.setString(1, VIN);

            int rows = preparedStatement.executeUpdate();

            System.out.println(rows + " vehicle deleted successfully: " + VIN);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Vehicle> searchByPriceRange(double minPrice, double maxPrice) {

        List<Vehicle> vehiclesByPriceRange = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * from vehicles WHERE price > ? AND price < ?"
        )){
            preparedStatement.setDouble(1,minPrice);
            preparedStatement.setDouble(2,maxPrice);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    do{
                        vehiclesByPriceRange.add(createVehicleFromResultSet(resultSet));
                    } while (resultSet.next());

                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehiclesByPriceRange;
    }

    public List<Vehicle> searchByMakeModel(String make, String model) {
        List<Vehicle> vehiclesByMakeModel = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * from vehicles WHERE make = ? AND model = ?"
            )){
            preparedStatement.setString(1,make);
            preparedStatement.setString(2,model);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    do{
                        vehiclesByMakeModel.add(createVehicleFromResultSet(resultSet));
                    } while (resultSet.next());

                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehiclesByMakeModel;
    }

    public List<Vehicle> searchByYearRange(int minYear, int maxYear) {
        List<Vehicle> vehiclesByYearRange = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * from vehicles WHERE year > ? AND year < ?"
            )){
            preparedStatement.setInt(1,minYear);
            preparedStatement.setInt(2,maxYear);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    do{
                        vehiclesByYearRange.add(createVehicleFromResultSet(resultSet));
                    } while (resultSet.next());

                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehiclesByYearRange;
    }

    public List<Vehicle> searchByColor(String color) {
        List<Vehicle> vehiclesByColor = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * from vehicles WHERE color = ?"
            )){
            preparedStatement.setString(1,color);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    do{
                        vehiclesByColor.add(createVehicleFromResultSet(resultSet));
                    } while (resultSet.next());

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehiclesByColor;
    }

    public List<Vehicle> searchByMileageRange(int minMileage, int maxMileage) {
        List<Vehicle> vehiclesByMileageRange = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * from vehicles WHERE odometer > ? AND odometer < ?"
            )){
            preparedStatement.setInt(1,minMileage);
            preparedStatement.setInt(2,maxMileage);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    do{
                        vehiclesByMileageRange.add(createVehicleFromResultSet(resultSet));
                    } while (resultSet.next());

                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehiclesByMileageRange;
    }

    public List<Vehicle> searchByType(String type) {
        List<Vehicle> vehiclesByType = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * from vehicles WHERE color = ?"
            )){
            preparedStatement.setString(1,type);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    do{
                        vehiclesByType.add(createVehicleFromResultSet(resultSet));
                    } while (resultSet.next());

                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehiclesByType;
    }

    private Vehicle createVehicleFromResultSet(ResultSet resultSet) throws SQLException {
        Vehicle vehicle = new Vehicle();
        vehicle.setVin(resultSet.getString("VIN"));
        vehicle.setMake(resultSet.getString("make"));
        vehicle.setModel(resultSet.getString("model"));
        vehicle.setYear(resultSet.getInt("year"));
        vehicle.setSold(resultSet.getBoolean("SOLD"));
        vehicle.setColor(resultSet.getString("color"));
        vehicle.setVehicleType(resultSet.getString("vehicleType"));
        vehicle.setOdometer(resultSet.getInt("odometer"));
        vehicle.setPrice(resultSet.getDouble("price"));
        return vehicle;
    }
}
