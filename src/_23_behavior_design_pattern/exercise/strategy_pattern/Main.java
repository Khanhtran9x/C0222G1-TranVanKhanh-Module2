package _23_behavior_design_pattern.exercise.strategy_pattern;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        User user1 = new User(1, "Khanh", 27, true);
        User user2 = new User(2, "Nhung", 25, false);
        User user3 = new User(3, "Huyen", 27, false);
        User user4 = new User(4, "Kha", 27, true);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);


        UserController userController1 = new UserController(new XMLStorage());
        userController1.store(userList);

        UserController userController2 = new UserController(new MySQLStorage());
        userController2.store(userList);
    }
}
