package com.example.m3_exam.model;

import java.sql.Date;

public class RentalSpace {
    private int id;
    private String code;
    private String status;
    private double area;
    private int floor;
    private String type;
    private double price;
    private Date startDate;
    private Date endDate;

    public RentalSpace() {
    }

    public RentalSpace(int id, String code, String status, double area, int floor, String type, double price, Date startDate, Date endDate) {
        this.id = id;
        this.code = code;
        this.status = status;
        this.area = area;
        this.floor = floor;
        this.type = type;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
