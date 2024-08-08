package com.example.m3_exam.service;

import com.example.m3_exam.model.RentalSpace;

import java.sql.Date;
import java.util.List;

public interface IRentalSpaceService {
    void addRentalSpace(String code, String status, double area, int floor, String type, double price, Date startDate, Date endDate);
    List<RentalSpace> getAllRentalSpaces();
    List<RentalSpace> searchRentalSpaces(String type, double minPrice, double maxPrice, int minFloor, int maxFloor);
}
