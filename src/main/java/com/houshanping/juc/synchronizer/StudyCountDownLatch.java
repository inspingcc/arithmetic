package main.java.com.houshanping.juc.synchronizer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: houshanping
 * @Date: 2020/03/10 18:29
 */
public class StudyCountDownLatch {
    public static final int MAX = 1 << 24;
    public static final int MAX_CPU_NUM = 8;

    public static AtomicLong sum = new AtomicLong(0);

    public static void main(String[] args) throws Exception {
        System.out.println(MAX);
        List<Integer> nums = new ArrayList<>(MAX);
        for (int i = 0; i < MAX; i++) {
            nums.add(1);
        }

        long startTime = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(MAX_CPU_NUM);
        int step = MAX / MAX_CPU_NUM;
        for (int i = 0; i < MAX_CPU_NUM; i++) {
            new CountThread(countDownLatch, nums, i * step, step * (i + 1)).start();
        }
        countDownLatch.await();
        System.out.println("计算结果:" + sum);
        System.out.println("时间:" + (System.currentTimeMillis() - startTime) + "ms");
        sum.set(0);
        startTime = System.currentTimeMillis();
        for (Integer num : nums) {
            sum.addAndGet(num);
        }
        System.out.println("计算结果:" + sum);
        System.out.println("时间:" + (System.currentTimeMillis() - startTime) + "ms");
    }

    static class CountThread extends Thread {
        CountDownLatch countDownLatch;
        List<Integer> nums;
        int startIndex;
        int endIndex;

        public CountThread(CountDownLatch countDownLatch, List<Integer> nums, int startIndex, int endIndex) {
            this.countDownLatch = countDownLatch;
            this.nums = nums;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        public void run() {
            for (int i = startIndex; i < endIndex; i++) {
                sum.addAndGet(nums.get(i));
            }
            countDownLatch.countDown();
        }
    }
}
