package com.practice.sm;

import com.practice.sm.dao.ConnectionMaker;
import com.practice.sm.dao.NConnectionMaker;
import com.practice.sm.dao.UserDao;

public class DaoFactory {
    public UserDao getUserDao() {
        return new UserDao(getConnectionMaker());
    }

    private ConnectionMaker getConnectionMaker() {
        return new NConnectionMaker();
    }
}
