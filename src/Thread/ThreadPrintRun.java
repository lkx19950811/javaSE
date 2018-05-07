package Thread;


/**
 * @author leo
 * @date 2018-05-02 15:09
 * @description: 两个线程争夺锁的例子,两个线程分开输出123,456
 */
public class ThreadPrintRun implements Runnable {
    int i = 0;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            synchronized (this){
                if (i <= 100) {
                    System.out.println(Thread.currentThread().getName() + "运行中:" + i);
                    i++;
                    if (i % 3 ==0){
                        try {
                            notify();
                            System.out.println(Thread.currentThread().getName() + "进入等待,释放锁");
                            wait();
                            System.out.println(Thread.currentThread().getName() + "获得锁,继续开始干活");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
