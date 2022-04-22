package _16_IO_text_file.exercise.read_csv_file;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadCsvFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path;

        do {
            System.out.println("Nhập đường dẫn file cần đọc: ");
            path = scanner.nextLine();
        } while (!checkFilePath(path));

        System.out.println("Danh sách các quốc gia là: ");
        List<String []> listStringArr = readCsvFile(path);
        displayCountry(listStringArr);
    }

    public static List<String []> readCsvFile(String path) {
        List<String []> listStringArr = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                listStringArr.add(arr);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  listStringArr;
    }

    public static void displayCountry(List<String[]> listStringArr){
        List<Country> countryList = new ArrayList<>();
        Country country;
        for (String[] item: listStringArr) {
            country = new Country(Integer.parseInt(item[0]), item[1], item[2]);
            countryList.add(country);
        }
        for (Country item: countryList) {
            System.out.println(item.toString());
        }
    }

    public static boolean checkFilePath(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            return true;
        } catch (FileNotFoundException e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
            return false;
        }
    }
}
