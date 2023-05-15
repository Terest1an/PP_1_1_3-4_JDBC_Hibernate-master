package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {



    public UserDaoJDBCImpl() {

    }
    Util util = new Util();

    public void createUsersTable() throws SQLException {
        try (Connection connection = util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS users(id MEDIUMINT NOT NULL AUTO_INCREMENT, name VARCHAR(45) NOT NULL, lastname VARCHAR(45) NOT NULL, age TINYINT NOT NULL, PRIMARY KEY(id));");
        }


    }

    public void dropUsersTable() throws SQLException {
        try (Connection connection = util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS users;");
        }

    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        String sql = "INSERT INTO users" + "(name, lastname, age) VALUES" + "(?,?,?)";
        try (Connection connection = util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();

        }

    }

    public void removeUserById(long id) throws SQLException {
        String sql = "DELETE FROM users (id) VALUES" + "(?)";
        try (Connection connection = util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
        }

    }

    public List<User> getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        try (Connection connection = util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getByte("age"));
                userList.add(user);

            }
        }
        return userList;
    }

    public void cleanUsersTable() throws SQLException {
        try (Connection connection = util.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "TRUNCATE TABLE users;";
            statement.executeUpdate(sql);

        }

    }


}
