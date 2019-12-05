package DAO;

import Entity.Account;
import Entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/dev_incubator_database";


    static final String USER = "dev";
    static final String PASSWORD = "1234";

    public List<Account> list() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Account> accounts = new ArrayList<Account>();

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            statement = connection.prepareStatement("SELECT  * FROM account");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Account account = new Account();
                account.setAccountId(resultSet.getLong("accountid"));
                account.setAccount(resultSet.getLong("account"));
                account.setUserId(resultSet.getLong("userid"));
                accounts.add(account);
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
        return accounts;
    }
}
