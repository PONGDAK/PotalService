package com.practice.sm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConnectionManager {
    public Connection getConnection() throws ClassNotFoundException, SQLException;
}