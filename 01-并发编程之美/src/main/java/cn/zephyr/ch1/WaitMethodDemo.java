package cn.zephyr.ch1;

/**
 * @ClassName: WaitMethodDemo
 * @Author: laizonghao
 * @Description: wait方法demo
 * @Date: 2019/9/6 15:58
 */
public class WaitMethodDemo {

    private static final Object lock01 = new Object();
    private static final Object lock02 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread01 = new Thread(new Runnable() {
            public void run() {
                try {
                    System.err.println("== thread01 try to get lock01 ==");
                    synchronized (lock01) {
                        System.err.println("== thread01 owned lock01, try to get lock02 ==");
                        synchronized (lock02) {
                            System.err.println("== thread01 owned lock02 ==");
                            System.err.println("== thread01 released lock01 ==");
                            lock01.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread02 = new Thread(new Runnable() {
            public void run() {
                try {
                    System.err.println("== thread02 try to  get lock01 ==");
                    synchronized (lock01) {
                        System.err.println("== thread02 owned lock01, try to get lock02 ==");
                        synchronized (lock02) {
                            System.err.println("== thread02 owned lock02 ==");
                            System.err.println("== thread02 release lock01 ==");
                            lock01.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread01.start();
        Thread.sleep(10);
        System.out.println("======= now thread01 owned lock02,released lock01 ==========");
        thread02.start();
    }
}
