package com.example.displaycustomer;

import com.example.displaycustomer.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/Customer")
public class CustomerController extends HttpServlet {
    private static final List<Customer> customers = new ArrayList<>();
    static {
        customers.add(new Customer("Mai Văn Hoàn","1983-08-20","Hà Nội","https://freepngimg.com/thumb/customer/1-2-customer-transparent.png"));
        customers.add(new Customer("Nguyễn Văn Nam","1983-08-21","Bắc Giang","https://freepngimg.com/thumb/customer/1-2-customer-transparent.png"));
        customers.add(new Customer("Nguyễn Thái Hòa","1983-08-22","Nam Định","https://freepngimg.com/thumb/customer/1-2-customer-transparent.png"));
        customers.add(new Customer("Trần Đăng Khoa","1983-08-17","Hà Tây","https://freepngimg.com/thumb/customer/1-2-customer-transparent.png"));
        customers.add(new Customer("Nguyễn Đình Thi","1983-08-19","Hà Nội","https://freepngimg.com/thumb/customer/1-2-customer-transparent.png"));
    };
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/customer/CustomerDisplay.jsp");
        req.setAttribute("customerList", customers);
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/customer/CustomerDisplay.jsp");
        req.setAttribute("customerList", customers);
        requestDispatcher.forward(req,resp);
    }
}
