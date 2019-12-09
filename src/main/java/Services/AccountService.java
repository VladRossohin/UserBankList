package Services;

import DAO.AccountDAO;
import Entity.Account;

import java.sql.SQLException;
import java.util.List;

public class AccountService {
    AccountDAO accountDAO = new AccountDAO();

    public AccountService() {
    }

    public List<Account> list() throws SQLException {
        return accountDAO.list();
    }

    public Long getSumOfAccounts() throws SQLException {
        return accountDAO.getSumOfAccounts();
    }
}
