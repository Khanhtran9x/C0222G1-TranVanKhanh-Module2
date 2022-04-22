package _22_structural_design_pattern.exercise.proxy_pattern;

public class FileDownloaderProxy implements Downloader {
    @Override
    public void download() {
        FileLoader fileLoader = new FileLoader("firefox");
        fileLoader.download();
    }
}
