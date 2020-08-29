package htwz;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:   使用多线程完成1+2+...+1000000000
 *                 彻底理解多线程与并发：线程与并发没有必然的联系，并发用锁解决线程安全问题，
 *                 线程可以提高CPU利用率，多线程程序可能存在并发问题，只是可能。
 *
 * @Author wangy
 * @Date 2020/8/28 23:14
 * @Version V1.0.0
 **/
public class Main {

    private static Integer count = 0;

    private static Integer ticket = 0;

    private static Integer ticket2 = 0;

    /**
     *
     * 499999999500000000
     *
     * 124999999250000001
     * 194999999050000001
     * 179999999900000000
     * 499999998200000002
     */


    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.currentTimeMillis());
        Long sum = 0L;
        for (int i = 1; i < 499999999; i++) {
            sum += i;
        }
        System.out.println(System.currentTimeMillis());
        System.out.println(sum);

        //将这个数分成3部分计算 1-499999999  500000000-799999999 800000000-1000000000
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ExecutorService executorService2 = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Long[] s = {1L, 499999999L, 500000000L, 799999999L, 800000000L, 1000000000L};
        List<Future<Long>> r = new ArrayList<>();
        System.out.println(System.currentTimeMillis());
        AtomicInteger a = new AtomicInteger(0);
        for (int i = 0; i < 3; i++) {
            Callable<Long> call = () -> {
                System.out.println(Thread.currentThread() + "---" +ticket++);
                //Long result = sum(s[count++], s[count++]);
                Long result = sum(s[a.getAndAdd(1)], s[a.getAndAdd(1)]);
                //countDownLatch.countDown();
                return result;
            };
            Future<Long> submit = executorService.submit(call);
            r.add(submit);
        }
        Long sum2 = 0L;
        try {
            countDownLatch.await();
            for (Future future : r) {
                sum2 += (Long) future.get();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis());
        System.out.println(sum2);
        executorService.shutdown();
        for (int i = 0; i < 3; i++) {
            Callable c = () -> {
                System.out.println(ticket2++);
                return 0L;
            };
            executorService2.submit(c);
        }
    }

    private static Long sum(Long start, Long end) {
        System.out.println(start + "---" + end);
        long sum = 0L;
        for (; start < end; start++) {
            sum += start;
        }
        System.out.println("+++++" + sum);
        return sum;
    }
}

class Sum {
    private Long start;

    private Long end;

    private CountDownLatch countDownLatch;

    public Sum(Long start, Long end, CountDownLatch countDownLatch) {
        this.start = start;
    }
}
