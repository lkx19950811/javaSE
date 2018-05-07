package Thread;

import org.junit.jupiter.api.Test;

/**
 * @author leo
 * @date 2018-05-04 17:23
 * @description:
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
}
