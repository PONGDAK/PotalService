package com.practice.sm.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {

    public Connection getConnection() throws ClassNotFoundException, SQLException;
}