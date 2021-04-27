package multithreading;

/**
 * 创建线程的第二种方法：实现Runnable接口，并重写run方法，执行线程需要丢入Runnable接口实现类，调用start方法
 */
public class TestThread3 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("这是子线程 ：" + i);
        }
    }

    public static void main(String[] args) {
        //创建子线程
        TestThread3 thread = new TestThread3();
        //通过线程对象开启我们的线程， 代理
        new Thread(thread).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("这是主线程：" + i);
        }
    }
}
