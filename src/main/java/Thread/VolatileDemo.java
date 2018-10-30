package Thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author leo
 * @date 2018-05-07 13:44
 * @description: volatile和threadlocal
 *                 volatile:使属性可见性。有个属性是共享属性，这个关键字会在每个线程内开一块内存，每次子线程都会从主线程拿最新的属性放到内存中。
 *                 但是有个问题，他只是拿最新的，比如：计数器，每个线程都执行+1操作。一个线程+1，另外两个同时读取这个属性，那么不会加2次，而是只加一次，
 *                 这就是valatile不能保证原子性的原因。
 *                 threadlocal：用于做方法外的全局属性。这个跟volatile刚好相反，使全局变量独立，每个线程里都有一份独立副本。
 */
public class VolatileDemo {
    volatile static int sum = 0;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=0;i<15;i++){
            executorService.execute(()-> System.out.println(++sum));
        }
    }
}
