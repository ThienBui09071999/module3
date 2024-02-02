package com.example.calculator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float result ;
        String choice = req.getParameter("operation");
        float op1 = Float.parseFloat(req.getParameter("op1"));
        float op2 = Float.parseFloat(req.getParameter("op2"));

        switch (choice) {
            case "add" :
                result = op1 + op2;
                break;
            case "subtract":
                result = op1 - op2;
                break;
            case "multiply":
                result = op1 * op2;
                break;
            case "divide":
                result = op1 / op2;
                break;
            default:
                result = 0;
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/result.jsp");
        req.setAttribute("result",result);
        requestDispatcher.forward(req,resp);
    }
}
