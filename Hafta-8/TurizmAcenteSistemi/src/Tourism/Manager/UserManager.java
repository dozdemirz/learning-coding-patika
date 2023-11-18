package Tourism.Manager;

import Tourism.Dao.UserDao;
import Tourism.Model.User;

public class UserManager {
    private final UserDao userDao;

    public UserManager() {
        this.userDao = new UserDao();
    }

    public User findByLogin(String username, String password){
        return this.userDao.findByLogin(username, password);
    }
}
