package _17_IO_binary_file_serialization.exercise.copy_binary_file;

import java.io.*;
import java.util.Scanner;

public class CopyBinaryFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String sourePath;
        String destinationPath;
        CopyBinaryFile copyBinaryFile;

        do {
            System.out.println("Nhập đường dẫn file gốc cần copy: ");
            sourePath = scanner.nextLine();
            copyBinaryFile = new CopyBinaryFile();
        } while (!copyBinaryFile.readFileText(sourePath));

        File destinationFile;
        while (true){
            System.out.println("Nhập đường dẫn file đích: ");
            destinationPath = scanner.nextLine();
            destinationFile = new File(destinationPath);
            copyBinaryFile = new CopyBinaryFile();
            if (destinationFile.exists()){
                System.out.println("Đường dẫn đã tồn tại file, bạn có muốn ghi đè hay không");
                System.out.println("1. Có");
                System.out.println("2. Không");
                int choice = -1;
                choice = scanner.nextInt();
                if (choice == 1){
                    break;
                } else {
                    continue;
                }
            }
        }

        copyBinaryFile.copyFileUsingStream(sourePath, destinationPath);
        System.out.println("Copy thành công");
        System.out.println("File có độ dài: "+destinationFile.length() + " bytes");

    }

    private boolean readFileText(String filePath) {
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

    private void copyFileUsingStream(String sourcePath, String destinationPath) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(new File(sourcePath));
            os = new FileOutputStream(new File(destinationPath));
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}
