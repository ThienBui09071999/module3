package com.example.user_management.repository;



import com.example.user_management.model.Country;
import com.example.user_management.model.User;

import java.sql.SQLException;
import java.util.List;

public interface ICountryRepository {
    public void insertCountry(Country country) throws SQLException;
    public List<Country> selectAllCountry();
}
