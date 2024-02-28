package com.example.product_manage_mvc.controller;

import com.example.product_manage_mvc.model.Product;
import com.example.product_manage_mvc.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(value = "/Product")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action ==null){
            action = "";
        }
        switch (action){
            case "add":
                showAddForm(req,resp);
                // thêm mới
                break;
            case "delete":
                showFormDelete(req,resp);
                // xoá
                break;
            case "update":
                showFormUpdate(req,resp);
                break;
            default:
                // hiểj thị danh sách
                showList(req,resp);

        }
    }
    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/add.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void save(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        Product product = new Product(name, price, quantity);
        boolean isSuccess = productService.add(product);
        String mess = "Them moi khong thanh cong";
        if (!isSuccess) {
            mess = "Them moi thanh cong";
        }
        try {
            resp.sendRedirect("/Product?mess=" + mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormDelete(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        boolean isSuccess = this.productService.delete(name);
        String mess = "Xoá khong thanh cong";
        if (isSuccess) {
            mess = "Them moi thanh cong";
        }
        try {
            resp.sendRedirect("/Product?mess=" +mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name =request.getParameter("name");
        Product product= productService.findProduct(name);
        request.setAttribute("product",product);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/view/update.jsp");
        requestDispatcher.forward(request,response);
    }
    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name=request.getParameter("name");
        int quantity=Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        Product product=productService.findProduct(name);
        product.setName(name);
        product.setQuantity(quantity);
        product.setPrice(price);
        boolean isSuccess = productService.update(product);
        String mess = "Cap nhat khong thanh cong";
        if (isSuccess) {
            mess = "Cap nhat thanh cong";
        }
        try {
            response.sendRedirect("/Product?mess=" + mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action ==null){
            action = "";
        }
        switch (action){
            case "add":
                save(req,resp);
                // thêm mới
                break;
            case "update":
                update(req, resp);
                break;
            default:
                break;

        }
    }
    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/list.jsp");
        req.setAttribute("productList", productService.findAll());
        req.setAttribute("myDate", new Date());
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
