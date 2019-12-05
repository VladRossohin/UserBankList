package Services;

import DAO.AccountDAO;
import Entity.Account;

import java.sql.SQLException;
import java.util.List;

public class AccountService {
    AccountDAO accountDAO = new AccountDAO();

    public List<Account> list() throws SQLException {
        return accountDAO.list();
    }
}
