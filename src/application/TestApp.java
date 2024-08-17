package application;

import implementation.IUser;
import implementation.UserImpl;

public class TestApp {
    public static void main(String[] args) {
        IUser user=new UserImpl();
        user.menu();
    }
}
