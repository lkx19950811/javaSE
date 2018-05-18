package Thread;

import java.util.Date;

/**
 * @author leo
 * @date 2018-05-14 17:31
 * @description:
 */
public class LockTest {
    public static String obj1 = "筷子1";
    public static String obj2 = "筷子2";
    public static void main(String[] args) {
        LockA la = new LockA();
        new Thread(la).start();
        LockB lb = new LockB();
        new Thread(lb).start();
    }
}
class LockA implements Runnable{
    public void run() {
        try {
            System.out.println(new Date().toString() + " 老王 开始抢夺筷子");
            while(true){
                synchronized (LockTest.obj1) {
                    System.out.println(new Date().toString() + " 老王 拿到 筷子1");
                    Thread.sleep(3000); // 此处等待是给老李能锁住机会
                    synchronized (LockTest.obj2) {
                        System.out.println(new Date().toString() + " 老王 拿到 筷子2");
                        Thread.sleep(60 * 1000); // 为测试，占用了就不放
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class LockB implements Runnable{
    public void run() {
        try {
            System.out.println(new Date().toString() + " 老李 开始抢筷子");
            while(true){
                synchronized (LockTest.obj2) {
                    System.out.println(new Date().toString() + " 老李 拿到 筷子2");
                    Thread.sleep(3000); // 此处等待是给老王能锁住机会
                    synchronized (LockTest.obj1) {
                        System.out.println(new Date().toString() + " 老李 拿到 筷子1");
                        Thread.sleep(60 * 1000); // 为测试，占用了就不放
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
