package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author leo
 * @date 2018-05-07 11:46
 * @description:
 */
public class ThreadlockRun implements Runnable{
    //����һ��100��Ʊ
    private int tickets = 100 ;

    //����һ������������
    private Lock lock = new ReentrantLock() ;//�����lock��
    //�����쳣��׼��ʽ:try...catch...finally
    //���θ�ʽ:try...finally...
    /**
     * try{
     *  ���ܳ�������Ĵ���
     * }catch(SocketException e){
     *  //����Ҫ���д���
     *  //�մ���
     * }
     */
    @Override
    public void run() {
        //ģ���ӰԺһֱ��Ʊ
        while(true){
            //ͬ������
            try{
                //��ȡ��
                lock.lock() ;
                if(tickets>0){
                    //�����ӳٲ���
                    try {
                        Thread.sleep(100) ;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"���ڳ��۵�"+(tickets--)+"��Ʊ");
                }else {
                    break;
                }
            }finally{
                //��ͼ�ͷ�������
                lock.unlock() ;
            }
        }
    }
}
