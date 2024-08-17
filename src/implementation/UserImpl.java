package implementation;

import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserImpl implements IUser{
    private  List<User> users = new ArrayList<>();

    private Scanner sc = new Scanner(System.in);

    public  void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("No users in the list.");
        } else {
            System.out.println("Users in the list:");
            for (User user : users) {
                System.out.println(user);
            }
        }
    }
    @Override
    public void addUser() {
        System.out.println("Enter user Id: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.println("Enter user firstname: ");
        String firstName = sc.nextLine();

        System.out.println("Enter user lastname: ");
        String lastName = sc.nextLine();

        System.out.println("Enter user telephone: ");
        String telephone = sc.nextLine();

        users.add(new User(id, firstName,lastName,telephone));
        System.out.println("User added successfully.");
    }

    @Override
    public void findUser() {
      String keySearch = null;
      User u=null;
      System.out.println("Menu");
      do{
         System.out.println("1.Search By Id");
          System.out.println("2.Search By Telephone");
          switch (keySearch){
              case "1":
                  System.out.println("Entrer l' Id");
                  u=findUserById(Integer.parseInt(sc.nextLine()));
                  if(u!=null){
                      System.out.println("The User is"+u);
                  }else{
                      System.out.println("No User found with id entered");
                  }
                  break;
              case"2": System.out.println("Entrer le tel...");
                u=findUserByTelephone(sc.nextLine());
                  if(u!=null){
                      System.out.println("The User By Tel... is"+u);
                  }else{
                      System.out.println("No User found with Tel... entered");
                  }
                  break;
              case "3":
                  System.out.println("Exit search");
                break;
              default:
                  System.out.println("Invalid entry");

          }
      }while (keySearch.equals("3"));

    }

    @Override
    public User findUserById(int id) {
        for(User u:users){
            if(u.getId()==id){
                return u;
            }else{
                System.out.println("User not found");
            }
        }
        return null;
    }

    @Override
    public User findUserByTelephone(String telephone) {
        for(User u:users){
            if(u.getTelephone().equalsIgnoreCase(telephone)){
                return u;
            }else{
                System.out.println("User not found!");
            }
        }
        return null;
    }



    @Override
    public void deleteUser() {
        System.out.println("Enter the Id of the user to delete: ");
        int id = Integer.parseInt(sc.nextLine());
        User user = findUserById(id);

        if (user != null) {
            users.remove(user);
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    @Override
    public void updateUser() {
        System.out.println("Enter the Id of the user to update: ");
        int id = Integer.parseInt(sc.nextLine());
        User user = findUserById(id);

        if (user != null) {

            System.out.println("Enter user firstname: ");
            String firstName = sc.nextLine();

            System.out.println("Enter user lastname: ");
            String lastName = sc.nextLine();

            System.out.println("Enter user telephone: ");
            String telephone = sc.nextLine();
            User u=new User();
            users.set(users.indexOf(id),new User(id, firstName,lastName,telephone) );

            System.out.println("User added successfully.");
            System.out.println("User updated successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    @Override
    public List<User> addUserInList(User u) {
        return null;
    }

    @Override
    public void menu() {
        String choice;
      do{
          System.out.println("\n Menu de choix.");
          System.out.println("1.Add One or More User(s)");
          System.out.println("2. Find User.");
          System.out.println("3.Fin User By Id");
          System.out.println("4.Find User By Telephone");
          System.out.println("5.Display List");
          System.out.println("6.Update User in the List");
          System.out.println("7.Delete User in the List");
          System.out.println("8.Quit the Programme");

          System.out.println("Entrer votre choix:");
          choice=sc.nextLine();

          switch (choice){
              case "1":addUser();
                break;
              case "2":findUser();
                  break;
              case "3":
                  System.out.println("User Id");
                  findUserById(Integer.parseInt(sc.nextLine()));
                  break;
              case "4":
                  System.out.println("User Tel...");
                  findUserByTelephone(sc.nextLine());
                  break;
              case "5":displayUsers();
                  break;
              case "6":updateUser();
                  break;
              case "7":deleteUser();
                  break;
              case "8": System.out.println("Exiting program.");;
                  break;
              default:
                  System.out.println("Invalid choice. Please try again.");;
          }
      }while (!choice.equals("8"));
       // scanner.close();
    }

}
