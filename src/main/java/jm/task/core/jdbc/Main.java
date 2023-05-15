package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        UserService service = new UserServiceImpl();
        service.createUsersTable();
        service.saveUser("Roman", "Popov", (byte) 20);
        service.saveUser("Serega", "Sidorov", (byte) 25);
        service.saveUser("Masha", "Andreeva", (byte) 31);
        service.saveUser("Lena", "Pushkina", (byte) 38);
        service.getAllUsers();
        service.cleanUsersTable();
        service.dropUsersTable();


    }
}
