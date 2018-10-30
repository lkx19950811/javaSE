package Proxy.pojo;

import java.util.Random;

/**
 * author : lee Cather <br>
 * date : 2018-10-30 17:03 <br>
 * desc : 另一个单独的类,没有实现任何接口 <br>
 */
public class WasteTime {
    public void testTime() throws InterruptedException {
        Thread.sleep(1000L);
        System.out.println("沉睡了一秒");
        int a = new Random().nextInt(100);
        Thread.sleep(a);
        System.out.println("沉睡了随机的时间:" + a);
    }
}
