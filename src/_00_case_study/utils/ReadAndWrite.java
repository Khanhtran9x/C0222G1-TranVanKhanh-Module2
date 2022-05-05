package _00_case_study.utils;
import java.io.*;
import java.util.*;

public class ReadAndWrite {

    public static <T> void writeListCsv(List<T> list, String path) {
        try (FileWriter fileWriter = new FileWriter(new File(path));
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (T t : list) {
                bufferedWriter.write(t.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> void writeSetCsv(Set<T> set, String path) {
        try (FileWriter fileWriter = new FileWriter(new File(path));
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (T t : set) {
                bufferedWriter.write(t.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String[]> readListCsv(String path) {
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

    public static <T> void writeMapCsv(Map<T, Integer> facilityIntegerMap, String path) {
        try (FileWriter fileWriter = new FileWriter(new File(path));
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Map.Entry<T, Integer> t : facilityIntegerMap.entrySet()) {
                bufferedWriter.write(t.getKey().toString() + "," + t.getValue() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
