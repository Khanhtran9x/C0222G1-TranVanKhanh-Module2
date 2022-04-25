package _23_behavior_design_pattern.exercise.strategy_pattern;

import java.util.List;

public class UserController {
    private UserStorage userStorage;

    public UserController(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public void store(List<User> users) {
        userStorage.store(users);
    }
}
