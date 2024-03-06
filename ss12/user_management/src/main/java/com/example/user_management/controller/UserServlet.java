package com.example.user_management.controller;

import com.example.user_management.DTO.UserDTO;
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
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ConnectDB userDAO;

    public void init() {
        userDAO = new ConnectDB();
    }
    CountryConnectDB countryConnectDB = new CountryConnectDB();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertUser(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
                default:
                    listUser(request,response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "find":
                    listUserFindByCountry(request, response);
                    break;
                case "sortByName":
                    listUserSortByName(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<UserDTO> listUser = userDAO.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("countryList", countryConnectDB.selectAllCountry());
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDAO.selectUser(id);
        request.setAttribute("countryList", countryConnectDB.selectAllCountry());
        request.setAttribute("user", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/edit.jsp");
        dispatcher.forward(request, response);

    }

    private void listUserSortByName(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<UserDTO> listUser = userDAO.sortByName();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void listUserFindByCountry(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String countryName = request.getParameter("countryName");
        List<UserDTO> listUser = userDAO.findByCountry(countryName);
        request.setAttribute("listUser", listUser);
//        request.setAttribute("countryName",countryName);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int countryId = Integer.parseInt(request.getParameter("countryId"));
        User newUser = new User(name, email, countryId);
        userDAO.insertUser(newUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int countryId = Integer.parseInt(request.getParameter("countryId"));

        User newUser = new User(id, name, email, countryId);
        userDAO.updateUser(newUser);
        User existingUser = userDAO.selectUser(id);
        request.setAttribute("countryList", countryConnectDB.selectAllCountry());
        request.setAttribute("user", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteUser(id);

        List<UserDTO> listUser = userDAO.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/list.jsp");
        dispatcher.forward(request, response);
    }

}
