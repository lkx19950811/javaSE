package Thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author leo
 * @date 2018-05-04 17:23
 * @description: ʵ�ְ�˳��ִ��
 */
public class ThreadSe {
    @Test
    public void s1() {
        final Thread join1 = new Thread(() -> System.out.println("join1"), "T1");

        final Thread join2 = new Thread(() -> {
            try {
                join1.join();//ȷ��join1ִ�����
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("join2");

        }, "T2");

        final Thread join3 = new Thread(() -> {
            try {
                join2.join();//ȷ��join2ִ�����
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
     *  ͨ���̳߳�������߳�
     */
    @Test
    void pool(){
        //�����̳߳ض���,ʹ��Executors������

        ExecutorService pool = Executors.newFixedThreadPool(2) ;

        //����ʹ��ExecutorService(���ٶ���첽����)һЩ����

        //ʹ��submit(Runnable target):�ύ�������
        pool.submit(new MyRunnable()) ;
        pool.submit(new MyRunnable()) ;

        //�����̳߳�

        pool.shutdown() ;

    }
}
class MyRunnable implements Runnable {
    @Override
    public void run() {
        //forѭ��
        for(int x = 0 ; x < 100 ; x ++){
            System.out.println(Thread.currentThread().getName()+":"+x);
        }
    }
}
