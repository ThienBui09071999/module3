package com.example.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculateDiscountServlet",value = "/display-discount")
public class CalculateDiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int listPrice = Integer.parseInt(req.getParameter("listPrice"));
        int discountPercent = Integer.parseInt(req.getParameter("discountPercent"));
        String product = req.getParameter("productDescription");
        double discountAmount = listPrice*discountPercent*0.01;
        double discountPrice = listPrice-discountAmount;
        req.setAttribute("productDescription",product);
        req.setAttribute("discountAmount",discountAmount);
        req.setAttribute("discountPrice",discountPrice);
        RequestDispatcher requestDispatcher  =req.getRequestDispatcher("result.jsp");
        requestDispatcher.forward(req,resp);
    }
}
