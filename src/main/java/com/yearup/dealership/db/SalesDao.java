package com.yearup.dealership.db;

import com.yearup.dealership.models.SalesContract;

import javax.sql.DataSource;
import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalesDao {
    private DataSource dataSource;

    public SalesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addSalesContract(SalesContract salesContract) {
        try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into sales_contracts (vin,sale_date,price) values (?,?,?)"
        )) {
            preparedStatement.setString(1,salesContract.getVin());
            preparedStatement.setDate(2, Date.valueOf(salesContract.getSaleDate()));
            preparedStatement.setDouble(3, salesContract.getPrice());
            int rows = preparedStatement.executeUpdate();

            System.out.println(rows + " contract(s) added successfully.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
