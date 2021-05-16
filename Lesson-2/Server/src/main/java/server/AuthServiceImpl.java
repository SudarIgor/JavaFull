package server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class AuthServiceImpl implements AuthService {

    private AuthServiceHandler userDao;

    public AuthServiceImpl() throws SQLException, ClassNotFoundException {
       userDao = new AuthServiceHandler();
    }


    public AuthServiceHandler getUserDao() {
        return userDao;
    }

    @Override
    public void addUser(String name, String pass) {
        try {
            userDao.updateUser(new User(name, pass));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean auth(String name, String pass) {
        System.out.println(name +" " + pass);
        try {
            if(userDao.userExists(name) && pass.equals(userDao.getUserByLogin(name).getPassword()) ){
             return true;
            }
        } catch (SQLException throwables) {
            return false;
        }

        return false;

    }
    @Autowired
    public void setUserDao(AuthServiceHandler userDao) {
        this.userDao = userDao;
    }
}
