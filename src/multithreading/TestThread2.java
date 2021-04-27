package multithreading;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread2 extends Thread{
    private String url;
    private String name;

    public TestThread2(String url, String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了图片："  + name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://img2.baidu.com/it/u=3355464299,584008140&fm=26&fmt=auto&gp=0.jpg", "1.jpg");
        TestThread2 t2 = new TestThread2("https://img0.baidu.com/it/u=2151136234,3513236673&fm=26&fmt=auto&gp=0.jpg", "2.jpg");
        TestThread2 t3 = new TestThread2("https://img2.baidu.com/it/u=3228549874,2173006364&fm=26&fmt=auto&gp=0.jpg", "3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }
}


//创建下载器
class WebDownloader {
    //下载方法
    public void downloader(String url, String name){
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("下载文件出现异常， downloader方法");
        }
    }
}
