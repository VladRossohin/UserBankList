package Services;

import DAO.UserDAO;
import Entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    UserDAO userDAO = new UserDAO();

    public UserService() {
    }

    public List<User> list() throws SQLException {
        return userDAO.list();
    }

    public User getUserById(Long id) throws SQLException {
        return userDAO.getUserById(id);
    }

    public User getRichestUser() throws  SQLException {
        return userDAO.getRichestUser();
    }
}
