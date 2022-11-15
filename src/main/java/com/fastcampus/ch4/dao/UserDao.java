package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.*;

import java.sql.SQLException;

public interface UserDao {
    User selectUser(String id) throws SQLException;
    int deleteUser(String id) throws SQLException;
    int insertUser(User user) throws SQLException;
    int updateUser(User user) throws SQLException;
    int count() throws SQLException;
    void deleteAll() throws SQLException;
}