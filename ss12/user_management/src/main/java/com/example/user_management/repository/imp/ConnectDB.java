package com.example.user_management.repository.imp;

import com.example.user_management.DTO.UserDTO;
import com.example.user_management.model.User;
import com.example.user_management.repository.IUserDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectDB implements IUserDAO {
    private String URL = "jdbc:mysql://localhost:3306/demo1?useSSL=false";
    private String USER = "root";
    private String PASS = "Thien123@";

    private static final String INSERT_USERS_SQL = "INSERT INTO users (name, email, countryId) VALUES (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select * from users where id=?";
    private static final String SELECT_ALL_USERS = "select u.id, u.name, u.email, c.country_name as country from users u join country c on u.countryId = c.countryId;";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, countryId =? where id = ?;";

    private static final String SEARCH_COUNTRY_SQL = "select u.id, u.name, u.email, c.country_name as country from users u join country c on u.countryId = c.countryId where c.country_name like ?;";
    private static final String SORT_NAME_SQL = "select u.id, u.name, u.email, c.country_name as country from users u join country c on u.countryId = c.countryId order by u.name;";
    public ConnectDB() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setInt(3, user.getCountryId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                int idcountry = rs.getInt("countryId");
                user = new User(id, name, email, idcountry);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public List<UserDTO> selectAllUsers() {
        List<UserDTO> usersDTO = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                usersDTO.add(new UserDTO(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        finally {
            try {
                getConnection().close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return usersDTO;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setInt(3, user.getCountryId());
            statement.setInt(4, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<UserDTO> findByCountry(String countryFind) throws SQLException {
        List<UserDTO> usersDTO = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_COUNTRY_SQL);)
        {
            preparedStatement.setString(1,"%"+countryFind+"%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                usersDTO.add(new UserDTO(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        finally {
            try {
                getConnection().close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return usersDTO;
    }

    @Override
    public List<UserDTO> sortByName() throws SQLException {
        List<UserDTO> usersDTO = new ArrayList<>();
        try (
                Connection connection = getConnection();

                PreparedStatement preparedStatement = connection.prepareStatement(SORT_NAME_SQL);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
//                int countryId = rs.getInt("country");
                usersDTO.add(new UserDTO(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        finally {
            try {
                getConnection().close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return usersDTO;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
