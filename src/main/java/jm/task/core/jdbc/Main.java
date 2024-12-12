package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {

    public static void main(final String[] args) {

        Util.getConnection();

        final UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Roman", "Smirnov", (byte) 28);
        userService.saveUser("Liza", "Smirnova", (byte) 27);
        userService.saveUser("Pavel", "Nevmovenko", (byte) 30);
        userService.saveUser("Nikita", "Kologriviy", (byte) 5);

        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();


    }
}
