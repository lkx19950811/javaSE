package ThreadPrint;
import org.junit.jupiter.api.Test;

/**
 * @author leo
 * @date 2018-05-02 16:28
 * @description:
 */
public class ThreadPrint {
    @Test
    public void twoThread(){
        ThreadTest t = new ThreadTest();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.setName("�߳�1");
        t2.setName("�߳�2");
        t1.start();
        t2.start();
    }
}
