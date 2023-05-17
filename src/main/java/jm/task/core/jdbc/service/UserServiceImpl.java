package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
//    UserDao userDaoJDBC = new UserDaoJDBCImpl();
    UserDao userDaoHibernater = new UserDaoHibernateImpl();


    public void createUsersTable() throws SQLException {
        userDaoHibernater.createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
        userDaoHibernater.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        userDaoHibernater.saveUser(name, lastName, age);
        System.out.println("Пользователь с именем " + name + " добавлен в базу данных");

    }

    public void removeUserById(long id) throws SQLException {
        userDaoHibernater.removeUserById(id);

    }

    public List<User> getAllUsers() throws SQLException {
        return userDaoHibernater.getAllUsers();
    }

    public void cleanUsersTable() throws SQLException {
        userDaoHibernater.cleanUsersTable();

    }


}
