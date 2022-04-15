package _16_IO_text_file.exercise.copy_file_text;

import java.io.*;
import java.util.Scanner;

public class CopyFileText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sourePath;
        String destinationPath;
        CopyFileText copyFileText;

        do {
            System.out.println("Nhập đường dẫn file gốc cần copy: ");
            sourePath = scanner.nextLine();
            copyFileText = new CopyFileText();
        } while (!copyFileText.readFileText(sourePath));

        do {
            System.out.println("Nhập đường dẫn file đích: ");
            destinationPath = scanner.nextLine();
            copyFileText = new CopyFileText();
        } while (!copyFileText.readFileText(destinationPath));

        copyFileText.copyToNewFile(sourePath, destinationPath);
    }

    public boolean readFileText(String filePath) {
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

    public void copyToNewFile(String sourceFile, String destinationFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(sourceFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(destinationFile));
            String line = "";
            int countChar = 0;
            while ((line = br.readLine()) != null) {
                countChar += line.length();
                bw.write(line + "\n");
            }
            br.close();
            bw.close();
            System.out.println("Đã copy thành công, số kí tự trong tệp là: " + countChar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
