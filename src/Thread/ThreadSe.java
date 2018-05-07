package Thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author leo
 * @date 2018-05-04 17:23
 * @description: 实现按顺序执行
 */
public class ThreadSe {
    @Test
    public void s1() {
        final Thread join1 = new Thread(() -> System.out.println("join1"), "T1");

        final Thread join2 = new Thread(() -> {
            try {
                join1.join();//确定join1执行完毕
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("join2");

        }, "T2");

        final Thread join3 = new Thread(() -> {
            try {
                join2.join();//确定join2执行完毕
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("join3");
        }, "T3");

        join3.start();
        join1.start();
        join2.start();
    }

    /**
     *  通过线程池来获得线程
     */
    @Test
    void pool(){
        //创建线程池对象,使用Executors工厂类

        ExecutorService pool = Executors.newFixedThreadPool(2) ;

        //下来使用ExecutorService(跟踪多个异步任务)一些方法

        //使用submit(Runnable target):提交多个任务
        pool.submit(new MyRunnable()) ;
        pool.submit(new MyRunnable()) ;

        //结束线程池

        pool.shutdown() ;

    }
}
class MyRunnable implements Runnable {
    @Override
    public void run() {
        //for循环
        for(int x = 0 ; x < 100 ; x ++){
            System.out.println(Thread.currentThread().getName()+":"+x);
        }
    }
}
