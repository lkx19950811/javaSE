package Thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author leo
 * @date 2018-05-07 13:08
 * @description:     countdownLatch��cyclicbarrier�������������߳̿��ƺܺ��ã������лᾭ���õ���
 *                    countdownLatch�����߳�������������߳�countdown��0�����߳�ִ�У�
 *                    cyclicbarrier������̵߳ȴ����������ڵȴ�״̬��һ��ִ�У����������ܻ��ƣ�
 */
public class CountDown {
    @Test
    void countDown() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(()->{
            System.out.println("�߳�һ");
            countDownLatch.countDown();
        }).start();
        new Thread(()->{
            System.out.println("�̶߳�");
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
        System.out.println("ǰ�������߳�ִ�������,��ִ�����߳�(countDownΪ0ʱ)");
    }

    /**
     *  �������̶߳��ȴ����,��һ�����
     */
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        new Thread(()->{
            try {
                long st = System.currentTimeMillis();
                Thread.sleep(1000);
                cyclicBarrier.await();
                System.out.println("�߳�һ�ȴ���: " + (System.currentTimeMillis() - st)/1000 + "��");
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
                System.out.println("�̶߳�");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
