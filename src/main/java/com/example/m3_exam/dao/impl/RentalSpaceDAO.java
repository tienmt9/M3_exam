package com.example.m3_exam.dao.impl;

import com.example.m3_exam.dao.IRentalSpaceDAO;
import com.example.m3_exam.model.RentalSpace;
import com.example.m3_exam.utils.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class RentalSpaceDAO implements IRentalSpaceDAO {
    @Override
    public void addRentalSpace(String code, String status, double area, int floor, String type, double price, Date startDate, Date endDate) {
        String sql = "{CALL AddRentalSpace(?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = JDBCConnection.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, code);
            stmt.setString(2, status);
            stmt.setDouble(3, area);
            stmt.setInt(4, floor);
            stmt.setString(5, type);
            stmt.setDouble(6, price);
            stmt.setDate(7, startDate);
            stmt.setDate(8, endDate);

            stmt.execute();
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
    }

    @Override
    public List<RentalSpace> getAllRentalSpaces() {
        String sql = "SELECT * FROM RentalSpaces ORDER BY area ASC";
        List<RentalSpace> rentalSpaces = new ArrayList<>();

        try (Connection conn = JDBCConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                RentalSpace rentalSpace = new RentalSpace(
                        rs.getInt("id"),
                        rs.getString("code"),
                        rs.getString("status"),
                        rs.getDouble("area"),
                        rs.getInt("floor"),
                        rs.getString("type"),
                        rs.getDouble("price"),
                        rs.getDate("start_date"),
                        rs.getDate("end_date")
                );
                rentalSpaces.add(rentalSpace);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rentalSpaces;
    }

    @Override
    public List<RentalSpace> searchRentalSpaces(String type, double minPrice, double maxPrice, int minFloor, int maxFloor) {
        String sql = "SELECT * FROM RentalSpaces WHERE type = ? AND price BETWEEN ? AND ? AND floor BETWEEN ? AND ? ORDER BY area ASC";
        List<RentalSpace> rentalSpaces = new ArrayList<>();

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, type);
            stmt.setDouble(2, minPrice);
            stmt.setDouble(3, maxPrice);
            stmt.setInt(4, minFloor);
            stmt.setInt(5, maxFloor);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    RentalSpace rentalSpace = new RentalSpace(
                            rs.getInt("id"),
                            rs.getString("code"),
                            rs.getString("status"),
                            rs.getDouble("area"),
                            rs.getInt("floor"),
                            rs.getString("type"),
                            rs.getDouble("price"),
                            rs.getDate("start_date"),
                            rs.getDate("end_date")
                    );
                    rentalSpaces.add(rentalSpace);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rentalSpaces;
    }
}
