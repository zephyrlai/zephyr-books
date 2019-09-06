package cn.zephyr.ch1;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: FakeWakeDemo
 * @Author: laizonghao
 * @Description: 虚假唤醒demo
 * @Date: 2019/9/6 16:37
 */
public class FakeWakeDemo {

    private static final List<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args){
        for (int i = 0; i < 50; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        synchronized (list) {
                            System.err.println("this is "+Thread.currentThread().getName());
                            if (list.size() < 1) {
                                list.wait();
                            }
                            System.err.println(Thread.currentThread().getName() + " is going to remove element");
                            list.remove(list.size() - 1);
                            System.err.println(Thread.currentThread().getName() + " remove element success");
                        }
                    } catch (Exception e) {
                        System.err.println("exception happened in "+Thread.currentThread().getName());
                        e.printStackTrace();

                    }
                }
            }).start();
        }
        synchronized (list) {
            list.add(1);
            System.err.println("main thread add element success");
            list.notify();
        }
    }
}
