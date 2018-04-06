package com.practice.sm;

import com.practice.sm.dao.NConnectionManager;
import com.practice.sm.dao.UserDao;
import com.practice.sm.user.User;

import java.sql.SQLException;

public class testDao {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao dao = new UserDao(new NConnectionManager);
        User user = new User();
        user.setName("신규인원");
        user.setPassword("3214");

        dao.add(user);

        System.out.println(user.getName() + "등록성공");

        User user2 = dao.get(1);
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + "조회성공");
    }
}
