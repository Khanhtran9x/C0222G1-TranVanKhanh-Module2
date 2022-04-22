package _22_structural_design_pattern.exercise.proxy_pattern;

public class Client {
    public void download() {
        FileDownloaderProxy fileDownloaderProxy = new FileDownloaderProxy();
        fileDownloaderProxy.download();
    }
}
