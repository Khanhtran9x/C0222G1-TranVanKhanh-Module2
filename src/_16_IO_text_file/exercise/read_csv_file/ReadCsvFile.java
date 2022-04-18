package _16_IO_text_file.exercise.read_csv_file;


import java.io.*;
import java.util.Scanner;

public class ReadCsvFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path;

        do {
            System.out.println("Nhập đường dẫn file cần đọc: ");
            path = scanner.nextLine();
        } while (!readFileText(path));

        System.out.println("Danh sách các quốc gia là: ");
        readCsvFile(path);
    }

    public static void readCsvFile(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                System.out.println(arr[arr.length - 1]);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static boolean readFileText(String filePath) {
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
