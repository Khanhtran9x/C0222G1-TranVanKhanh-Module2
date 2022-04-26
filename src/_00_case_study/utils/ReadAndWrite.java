package _00_case_study.utils;


import _00_case_study.model.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReadAndWrite {
    public static void write(List<Customer> list, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Customer customer : list) {

            }
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object read(String path) {
        List<Object> objectList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            objectList = (List<Object>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objectList;
    }

}
