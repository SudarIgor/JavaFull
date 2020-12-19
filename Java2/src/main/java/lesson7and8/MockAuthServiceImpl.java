package lesson7and8;

import java.util.HashMap;

public class MockAuthServiceImpl  implements AuthService{

    private static MockAuthServiceImpl sample;
    private HashMap<String, String> userDao;


    public MockAuthServiceImpl() {
        userDao = new HashMap<>();
        userDao.put("user","pass");
    }

    public HashMap<String, String> getUserDao() {
        return userDao;
    }

    public static MockAuthServiceImpl getSample() {
        if (sample == null){
            sample = new MockAuthServiceImpl();
        }
        return sample;
    }

    @Override
    public void addUser(String name, String pass) {
        userDao.put(name, pass);
    }

    @Override
    public boolean auth(String name, String pass) {
        System.out.println(name +" " + pass);
        try {
            return userDao.get(name).equals(pass);
        }catch (Exception e){
            return false;
        }


    }
}
