package Thread;

/**
 * @author leo
 * @date 2018-05-07 11:47
 * @description:
 */
public class ThreadLockTest {
    public static void main(String[] args) {

        //������Դ����
        ThreadlockRun st = new ThreadlockRun() ;

        //�����̶߳���
        Thread t1 = new Thread(st, "����1") ;
        Thread t2 = new Thread(st, "����2") ;
        Thread t3 = new Thread(st, "����3") ;

        //�����߳�
        t1.start() ;
        t2.start() ;
        t3.start() ;
    }
}
