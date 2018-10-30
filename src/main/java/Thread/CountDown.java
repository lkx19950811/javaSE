package Thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author leo
 * @date 2018-05-07 13:08
 * @description:     countdownLatch和cyclicbarrier（这两个做多线程控制很好用，工作中会经常用到）
 *                    countdownLatch：主线程阻塞，当多个线程countdown到0，主线程执行；
 *                    cyclicbarrier：多个线程等待，当都处于等待状态了一起执行（类似于赛跑机制）
 */
public class CountDown {
    @Test
    void countDown() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(()->{
            System.out.println("线程一");
            countDownLatch.countDown(); //countDown数量减一
        }).start();
        new Thread(()->{
            System.out.println("线程二");
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
        System.out.println("前面两个线程执行完毕了,才执行主线程(countDown为0时)");
    }

    /**
     *  当所有线程都等待完毕,再一起出发
     */
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        new Thread(()->{
            try {
                long st = System.currentTimeMillis();
                Thread.sleep(1000);
                cyclicBarrier.await();
                System.out.println("线程一等待了: " + (System.currentTimeMillis() - st)/1000 + "秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                Thread.sleep(5000);
                cyclicBarrier.await();
                System.out.println("线程二");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
