package lesson2;

import chat.AuthService;

import java.sql.SQLException;

public class AuthServiceImpl implements AuthService {

    private static AuthServiceImpl sample;
    private AuthServiceHandler userDao;

    public AuthServiceImpl() throws SQLException, ClassNotFoundException {
       userDao = new AuthServiceHandler();
    }

    public static AuthServiceImpl getSample() throws SQLException, ClassNotFoundException {
        if (sample == null){
            sample = new AuthServiceImpl();
        }
        return sample;
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
}
