package com.practice.sm.dao;

import com.practice.sm.user.User;

import java.sql.*;

public abstract class UserDao {

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection conn = getConnection();

        PreparedStatement ps = conn.prepareStatement("insert into users(name, password) values(?,?)");
        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());

        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    public User get(int id) throws ClassNotFoundException, SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from users where id = ?");
        ps.setInt(1,id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        conn.close();

        return user;

    }

    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
}
