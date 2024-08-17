package implementation;

import entities.User;

import java.util.List;

public interface IUser {
    public void addUser();
    public void findUser();
    public User findUserById(int id);
    public User findUserByTelephone(String telephone);
    public void updateUser() ;
    public List<User> addUserInList(User u);
    public void menu();
    public void displayUsers();
    public void deleteUser();
}
