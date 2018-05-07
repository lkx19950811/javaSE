package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author leo
 * @date 2018-05-07 15:04
 * @description: AtomicInteger：支持原子性计数器。
 */
public class AtomicIntegerDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=0;i<10;i++){
            executorService.execute(()->{
                System.out.println(atomicInteger.addAndGet(1));
            });
        }
    }
}
