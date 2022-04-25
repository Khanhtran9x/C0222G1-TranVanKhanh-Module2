package _23_behavior_design_pattern.exercise.strategy_pattern;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String name;
    private int age;
    private boolean gender = true;

    public User(int id, String name, int age, boolean gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
