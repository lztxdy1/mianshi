package multithreading;

/**
 * 实现多线程方法一：继承Thread类，并实现run方法，run方法内即为线程的执行体，调用start方法开启线程
 *
 * 注意：线程开启后不一定立即执行，需要CPU的调度
 */
public class TestThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("这是子线程 ：" + i);
        }
    }

    public static void main(String[] args) {
        //创建子线程
        TestThread thread = new TestThread();
        //开启子线程
        thread.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("这是主线程：" + i);
        }
    }
}
