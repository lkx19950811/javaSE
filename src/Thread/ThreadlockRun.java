package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author leo
 * @date 2018-05-07 11:46
 * @description:
 */
public class ThreadlockRun implements Runnable{
    //定义一个100张票
    private int tickets = 100 ;

    //定义一个具体锁对象
    private Lock lock = new ReentrantLock() ;//具体的lock锁
    //捕获异常标准格式:try...catch...finally
    //变形格式:try...finally...
    /**
     * try{
     *  可能出现问题的代码
     * }catch(SocketException e){
     *  //不需要进行处理
     *  //空处理
     * }
     */
    @Override
    public void run() {
        //模拟电影院一直有票
        while(true){
            //同步机制
            try{
                //获取锁
                lock.lock() ;
                if(tickets>0){
                    //加入延迟操作
                    try {
                        Thread.sleep(100) ;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"正在出售第"+(tickets--)+"张票");
                }else {
                    break;
                }
            }finally{
                //试图释放锁对象
                lock.unlock() ;
            }
        }
    }
}
