package Thread;


/**
 * @author leo
 * @date 2018-05-02 15:09
 * @description: �����߳�������������,�����̷ֿ߳����123,456
 */
public class ThreadTest implements Runnable {
    int i = 0;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            synchronized (this){
                if (i <= 100) {
                    System.out.println(Thread.currentThread().getName() + "������:" + i);
                    i++;
                    if (i % 3 ==0){
                        try {
                            notify();
                            System.out.println(Thread.currentThread().getName() + "����ȴ�,�ͷ���");
                            wait();
                            System.out.println(Thread.currentThread().getName() + "�����,������ʼ�ɻ�");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
