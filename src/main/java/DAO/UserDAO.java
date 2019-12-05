package DAO;

import Entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/dev_incubator_database";


    static final String USER = "dev";
    static final String PASSWORD = "1234";

    public List<User> list() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> users = new ArrayList<User>();

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            statement = connection.prepareStatement("SELECT  * FROM user");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getLong("userid"));
                user.setName(resultSet.getString("name"));
                user.setSurName(resultSet.getString("sureName"));
                users.add(user);
            }
        } finally {
            if (resultSet != null) try {
                resultSet.close();
            } catch (SQLException ignore) {
            }
            if (statement != null) try {
                statement.close();
            } catch (SQLException ignore) {
            }
            if (connection != null) try {
                connection.close();
            } catch (SQLException ignore) {
            }
        }
        return users;
    }
    public User getUserById(Long id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = new User();

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            statement = connection.prepareStatement("Select * FROM user WHERE userid = " + id);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                user.setUserId(resultSet.getLong("userid"));
                user.setName(resultSet.getString("name"));
                user.setSurName(resultSet.getString("sureName"));
            }
        } finally {
            if (resultSet != null) try {
                resultSet.close();
            } catch (SQLException ignore) {
            }
            if (statement != null) try {
                statement.close();
            } catch (SQLException ignore) {
            }
            if (connection != null) try {
                connection.close();
            } catch (SQLException ignore) {
            }
        }
        return user;
    }

    public List<User> getRichestUser() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> user = new ArrayList<User>();

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            statement = connection.prepareStatement("select user.userid, user.name, user.sureName from account right outer join user on user.userid=account.userid where account=(select max(account) from account)"); // search by one highest account, not by sum
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                /*user.setUserid(resultSet.getLong("userid"));
                user.setName(resultSet.getString("name"));
                user.setSurName(resultSet.getString("sureName"));
            */
                user.add(new User(resultSet.getLong("userid"), resultSet.getString("name"), resultSet.getString("sureName")));
            }
        } finally {
            if (resultSet != null) try {
                resultSet.close();
            } catch (SQLException ignore) {
            }
            if (statement != null) try {
                statement.close();
            } catch (SQLException ignore) {
            }
            if (connection != null) try {
                connection.close();
            } catch (SQLException ignore) {
            }
        }
        return user;
    }
}
