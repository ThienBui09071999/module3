package com.example.user_management.repository.imp;

import com.example.user_management.model.Country;
import com.example.user_management.model.User;
import com.example.user_management.repository.ICountryRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryConnectDB implements ICountryRepository {
    private String URL = "jdbc:mysql://localhost:3306/demo1?useSSL=false";
    private String USER = "root";
    private String PASS = "Thien123@";

    private static final String INSERT_COUNTRY_SQL="INSERT INTO country(country_name) VALUE (?)";

    private static final String SELECT_ALL_COUNTRY = "select * from country";

    public CountryConnectDB() {
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
    public void insertCountry(Country country) throws SQLException {
        System.out.println(INSERT_COUNTRY_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COUNTRY_SQL)) {
            preparedStatement.setString(1, country.getName());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public List<Country> selectAllCountry() {
        List<Country> countries = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COUNTRY);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("countryId");
                String name = rs.getString("country_name");
                countries.add(new Country(id, name));
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
        return countries;
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
