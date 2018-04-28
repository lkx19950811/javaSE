package forkJoin;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author leo
 * @date 2018-04-28 17:21
 * @description:
 */
public class TestFork { //
    @Test
    public void testFork(){
        long[] array = new long[400];
        fillRandom(array);
        // fork/join task:
        ForkJoinPool fjp = new ForkJoinPool(4); // 最大并发数4
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
        long startTime = System.currentTimeMillis();
        Long result = fjp.invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");

        //直接for循环计算
        startTime = System.currentTimeMillis();
        result = sum(array);
        endTime = System.currentTimeMillis();
        System.out.println("for sum: " + result + " in " + (endTime - startTime) + " ms.");
    }
    //填充随机数
    private void fillRandom(long[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++){
            array[i] = random.nextLong();
        }
    }
    private long sum(long[] arry){
        long sum = 0;
        for (int i=0; i<arry.length;i++){
            sum = sum + arry[i];
        }
        return sum;
    }
}
