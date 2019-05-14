package com.siniak.finaltask;

import com.siniak.finaltask.command.CommandEnum;
import com.siniak.finaltask.connection.ConnectionPool;
import com.siniak.finaltask.connection.ProxyConnection;
import com.siniak.finaltask.constant.Constant;
import com.siniak.finaltask.exception.ConnectionPoolException;

public class Runner {
    public static void main(String[] args) throws ConnectionPoolException {
        CommandEnum commandEnum = CommandEnum.valueOf("empty".toUpperCase());
        ConnectionPool pool = ConnectionPool.getInstance();
        ProxyConnection connection = pool.getConnection();
        System.out.println(connection);
        System.out.println(Constant.PHOTO_PARAMETR);
    }
}
