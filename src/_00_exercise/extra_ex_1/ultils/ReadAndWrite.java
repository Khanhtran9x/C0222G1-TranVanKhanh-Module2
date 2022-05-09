package _00_exercise.extra_ex_1.ultils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ReadAndWrite {
    public static List<String[]> readCsvFile(String path) {
        List<String[]> listStr = new ArrayList<>();

        try (FileReader fileReader = new FileReader(new File(path));
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null && !line.equals("")) {
                String[] arrStr = line.split(",");
                listStr.add(arrStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listStr;
    }

    public static <T> void writeCsvFile(Collection<T> collection, String path) {
        try (FileWriter fileWriter = new FileWriter(new File(path));
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (T t : collection) {
                bufferedWriter.write(t.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
