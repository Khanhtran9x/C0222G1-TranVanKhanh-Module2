package _22_structural_design_pattern.exercise.proxy_pattern;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class FileLoader implements Downloader {
    private String userAgent;

    public FileLoader() {
    }

    public FileLoader(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public void download(){
        URL url = null;
        if (this.userAgent.equals("firefox")){
            try {
                url = new URL("https://rebrand.ly/89fccf");
                URLConnection conn = url.openConnection();

                conn.setRequestProperty("User-Agent",
                        "Mozilla/5.0 (Windows NT 5.1; rv:19.0) Gecko/20100101 Firefox/19.0");
                conn.connect();
                BufferedReader serverResponse = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));

                String savePath = "src\\_22_structural_design_pattern\\exercise\\proxy_pattern\\Downloaded.txt";
                BufferedWriter bw = new BufferedWriter(new FileWriter(savePath));
                String line = "";
                while ((line = serverResponse.readLine()) != null){
                    bw.write(line + "\n");
                }
                serverResponse.close();
                bw.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
