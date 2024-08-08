package com.example.m3_exam.controller;

import com.example.m3_exam.model.RentalSpace;
import com.example.m3_exam.service.IRentalSpaceService;
import com.example.m3_exam.service.impl.RentalSpaceService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "RentalSpaceController", value = "/rentalspace")
public class RentalSpaceController extends HttpServlet {
    private IRentalSpaceService rentalSpaceService = new RentalSpaceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RentalSpace> rentalSpaces = rentalSpaceService.getAllRentalSpaces();
        req.setAttribute("rentalSpaces", rentalSpaces);
        RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
        try {
            rd.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String status = req.getParameter("status");
        double area = Double.parseDouble(req.getParameter("area"));
        int floor = Integer.parseInt(req.getParameter("floor"));
        String type = req.getParameter("type");
        double price = Double.parseDouble(req.getParameter("price"));
        String startDateStr = req.getParameter("startDate");
        String endDateStr = req.getParameter("endDate");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date utilStartDate = null;
        java.util.Date utilEndDate = null;
        try {
            utilStartDate = sdf.parse(startDateStr);
            utilEndDate = sdf.parse(endDateStr);
        } catch (ParseException e) {
            throw new ServletException("Invalid date format", e);
        }

        java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(utilEndDate.getTime());


        rentalSpaceService.addRentalSpace(code, status, area, floor, type, price, sqlStartDate, sqlEndDate);
        resp.sendRedirect("success.jsp");

    }
}
