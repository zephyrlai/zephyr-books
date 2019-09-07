package cn.zephyr.ch1;

import java.util.concurrent.*;

/**
 * @ClassName: ThreadPoolExecutorDemo
 * @Author: laizonghao
 * @Description:
 * @Date: 2019/9/7 00:10
 */
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallableTask());
        System.err.println("main thread do something...");
        System.err.println("sub thread result: "+future.get());
    }
}

class MyCallableTask implements Callable<String>{

    public String call() throws Exception {
        System.err.println("sub thread do something...");
        Thread.sleep(1000);
        return "this callable task";
    }
}
