package cn.zephyr.ch1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName: FutureTaskDemo
 * @Author: laizonghao
 * @Description:
 * @Date: 2019/9/6 17:58
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new CallableTask());
        futureTask.run();
        System.err.println("==main thread do something...==");
        System.err.println("sub thread result "+futureTask.get());
    }

}

class CallableTask implements Callable<Integer>{
    public Integer call() throws Exception {
        Thread.sleep(500);
        System.err.println("===this is callable task...===");
        return 1;
    }
}
