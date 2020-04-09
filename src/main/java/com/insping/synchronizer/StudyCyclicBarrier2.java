package com.insping.synchronizer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: houshanping
 * @Date: 2020/03/11 9:45
 */
public class StudyCyclicBarrier2 {
    public static final int MAX = 1 << 24;
    public static final int MAX_CPU_NUM = 8;

    public static AtomicLong sum = new AtomicLong(0);

    public static void main(String[] args){
        System.out.println(MAX);
        List<Integer> nums = new ArrayList<>(MAX);
        for (int i = 0; i < MAX; i++) {
            nums.add(1);
        }

        final long startTime = System.currentTimeMillis();
        CyclicBarrier cb = new CyclicBarrier(MAX_CPU_NUM, () -> {
            System.out.println("计算结果:" + sum);
            System.out.println("时间:" + (System.currentTimeMillis() - startTime) + "ms");
        });
        int step = MAX / MAX_CPU_NUM;
        for (int i = 0; i < MAX_CPU_NUM; i++) {
            new CountThread(cb, nums, i * step, step * (i + 1)).start();
        }

        sum.set(0);
        long startTime1 = System.currentTimeMillis();
        for (Integer num : nums) {
            sum.addAndGet(num);
        }
        System.out.println("计算结果:" + sum);
        System.out.println("时间:" + (System.currentTimeMillis() - startTime1) + "ms");
    }

    static class CountThread extends Thread {
        CyclicBarrier cb;
        List<Integer> nums;
        int startIndex;
        int endIndex;

        public CountThread(CyclicBarrier cb, List<Integer> nums, int startIndex, int endIndex) {
            this.cb = cb;
            this.nums = nums;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        public void run() {
            for (int i = startIndex; i < endIndex; i++) {
                sum.addAndGet(nums.get(i));
            }
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
