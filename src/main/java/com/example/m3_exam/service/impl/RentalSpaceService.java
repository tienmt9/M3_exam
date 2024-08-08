package com.example.m3_exam.service.impl;

import com.example.m3_exam.dao.IRentalSpaceDAO;
import com.example.m3_exam.dao.impl.RentalSpaceDAO;
import com.example.m3_exam.model.RentalSpace;
import com.example.m3_exam.service.IRentalSpaceService;

import java.sql.Date;
import java.util.List;

public class RentalSpaceService implements IRentalSpaceService {
    private IRentalSpaceDAO rentalSpaceDAO = new RentalSpaceDAO();

    @Override
    public void addRentalSpace(String code, String status, double area, int floor, String type, double price, Date startDate, Date endDate) {
        rentalSpaceDAO.addRentalSpace(code, status, area, floor, type, price, startDate, endDate);
    }

    @Override
    public List<RentalSpace> getAllRentalSpaces() {
        return rentalSpaceDAO.getAllRentalSpaces();
    }

    @Override
    public List<RentalSpace> searchRentalSpaces(String type, double minPrice, double maxPrice, int minFloor, int maxFloor) {
        return rentalSpaceDAO.searchRentalSpaces(type, minPrice, maxPrice, minFloor, maxFloor);
    }
}
