package com.example.user_management.controller;

import com.example.user_management.model.Country;
import com.example.user_management.model.User;
import com.example.user_management.repository.imp.ConnectDB;
import com.example.user_management.repository.imp.CountryConnectDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "/country")
public class CountryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CountryConnectDB countryConnectDB = new CountryConnectDB();
    private ConnectDB userDAO;

    public void init() {
        userDAO = new ConnectDB();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showAddForm(request, response);
                break;
            case "createOffEdit":
                showAddFormOffEdit(request,response);
            default:
                break;
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/country/createCountry.jsp");
        dispatcher.forward(request, response);
    }
    private void showAddFormOffEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/country/createCountryOffEdit.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action="";
        }
        switch (action){
            case "create":
                try {
                    insertCountry(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "createOffEdit":
                try {
                    insertCountryOffEdit(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
    }
    private void insertCountry(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        Country country = new Country(name);
        countryConnectDB.insertCountry(country);
        request.setAttribute("countryList", countryConnectDB.selectAllCountry());
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/create.jsp");
        dispatcher.forward(request, response);
    }
    private void insertCountryOffEdit(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDAO.selectUser(id);
        request.setAttribute("user", existingUser);
        Country country = new Country(name);
        countryConnectDB.insertCountry(country);
        request.setAttribute("countryList", countryConnectDB.selectAllCountry());
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/edit.jsp");
        dispatcher.forward(request, response);
    }
}
