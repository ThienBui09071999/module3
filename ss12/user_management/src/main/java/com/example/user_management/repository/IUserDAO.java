package com.example.user_management.repository;

import com.example.user_management.DTO.UserDTO;
import com.example.user_management.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<UserDTO> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;
    public List<UserDTO> findByCountry(String countryFind)throws SQLException;
    public List<UserDTO> sortByName()throws SQLException;
}
