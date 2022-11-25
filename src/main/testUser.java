package main;
import module.User;
import java.util.ArrayList;
import dao.userDAO;

public class testUser {
    public static void main(String[] args) {
        // test insert
        // User u1 =  new User("manhmafia113@gmail.com", "manhz2k3", "Nguyễn Mafia Ba Vì");
        // userDAO.getInstance().insert(u1);

        // test update
        // User u = new User("manhthenguyen113@gmail.com", "0987739823asD", "Nguyễn Mạnh");
        // userDAO.getInstance().update(u);

        // test delete
        // User u = new User("manhz2003", null, null);
        // userDAO.getInstance().delete(u);

        // test truy vấn theo id
        // User find =  new User("manhz2003", "manhz2k3", "Nguyễn Thế Mạnh");
        // find.setUserName("manhthenguyen113@gmail.com");
        // User u = userDAO.getInstance().selectById(find);
        // System.out.println(u);
        
        // test truy vấn all
        // ArrayList<User> user = userDAO.getInstance().selectAll();
        // for (User u : user) {
        //     System.out.println(u);
        // }

        // test truy vấn theo điều kiện bất kì
        // String condition1 = "passWord= 'manhz2k3'";
        // String condition2 = "userName= 'manhthenguyen113@gmail.com'";
        // String condition3 = "fullName= 'Lương Thị Lan Anh'";
        // ArrayList<User> user = userDAO.getInstance().selectByCondition(condition2);
        //         for (User u : user) {
        //             System.out.println(u.toString());
        //         }

    }
}
