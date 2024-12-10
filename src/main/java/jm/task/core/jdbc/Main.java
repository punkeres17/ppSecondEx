package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

public class Main {

    public static void main(final String[] args) {

        Util.getConnection();

        final UserDao userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();
        userDao.saveUser("Roman", "Smirnov", (byte) 28);
        userDao.saveUser("Liza", "Smirnova", (byte) 27);
        userDao.saveUser("Pavel", "Nevmovenko", (byte) 30);
        userDao.saveUser("Nikita", "Kologriviy", (byte) 5);

        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();


    }
}
