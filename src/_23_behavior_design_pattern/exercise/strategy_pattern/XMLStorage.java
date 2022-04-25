package _23_behavior_design_pattern.exercise.strategy_pattern;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class XMLStorage implements UserStorage{
    String path = "src\\_23_behavior_design_pattern\\exercise\\strategy_pattern\\UserList.xml";
    @Override
    public void store(List<User> users) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.close();
            fos.close();
            System.out.println("store to xml file successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
