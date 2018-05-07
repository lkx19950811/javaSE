package forkJoin;
import java.util.concurrent.RecursiveTask;

/**
 * @author leo
 * @date 2018-04-28 17:19
 * @description:
 */
public class SumTask extends RecursiveTask<Long> {

    static final int THRESHOLD = 100;
    long[] array;
    int start;
    int end;

    SumTask(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    /**
     * 编写这个Fork/Join任务的关键在于，在执行任务的compute()方法内部，先判断任务是不是足够小，
     * 如果足够小，就直接计算并返回结果（注意模拟了1秒延时），否则，把自身任务一拆为二，分别计算两个子任务，
     * 再返回两个子任务的结果之和。
     * @return
     */
    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            // 如果任务足够小,直接计算:
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            try {
                //Thread.sleep(1000);
            } catch (Exception e) {
            }
            System.out.println(String.format("compute %d~%d = %d", start, end, sum));
            return sum;
        }
        // 任务太大,一分为二:
        int middle = (end + start) / 2;
        System.out.println(String.format("split %d~%d ==> %d~%d, %d~%d", start, end, start, middle, middle, end));
        SumTask subtask1 = new SumTask(this.array, start, middle);
        SumTask subtask2 = new SumTask(this.array, middle, end);
        invokeAll(subtask1, subtask2);
        Long subresult1 = subtask1.join();
        Long subresult2 = subtask2.join();
        Long result = subresult1 + subresult2;
        System.out.println("result = " + subresult1 + " + " + subresult2 + " ==> " + result);
        return result;
    }
}
