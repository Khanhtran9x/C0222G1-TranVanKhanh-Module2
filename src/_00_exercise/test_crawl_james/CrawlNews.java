package _00_exercise.test_crawl_james;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlNews {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://james.codegym.vn/course/view.php?id=541&section=17");

            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content1 = scanner.next();

            scanner.close();
            content1 = content1.replaceAll("\\n+", "");
            String content2 = "";

            Pattern p = Pattern.compile("instancename\">(.*?)<");
            Matcher m = p.matcher(content1);
            while (m.find()) {
                content2 += m.group(1);
            }

            Pattern pp = Pattern.compile("](.*?)<");
            Matcher mm = pp.matcher(content2);
            while (mm.find()) {
                System.out.println(mm.group(1));
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
