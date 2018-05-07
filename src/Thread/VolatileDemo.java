package Thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author leo
 * @date 2018-05-07 13:44
 * @description: volatile��threadlocal
 *                 volatile:ʹ���Կɼ��ԡ��и������ǹ������ԣ�����ؼ��ֻ���ÿ���߳��ڿ�һ���ڴ棬ÿ�����̶߳�������߳������µ����Էŵ��ڴ��С�
 *                 �����и����⣬��ֻ�������µģ����磺��������ÿ���̶߳�ִ��+1������һ���߳�+1����������ͬʱ��ȡ������ԣ���ô�����2�Σ�����ֻ��һ�Σ�
 *                 �����valatile���ܱ�֤ԭ���Ե�ԭ��
 *                 threadlocal���������������ȫ�����ԡ������volatile�պ��෴��ʹȫ�ֱ���������ÿ���߳��ﶼ��һ�ݶ���������
 */
public class VolatileDemo {
    volatile static int sum = 0;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=0;i<15;i++){
            executorService.execute(()-> System.out.println(++sum));
        }
    }
}
