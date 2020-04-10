package com.houshanping.juc.synchronizer;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: houshanping
 * @Date: 2020/03/11 9:45
 */
public class StudyCyclicBarrier {

    public static final int N = 5;

    public static void main(String[] args) throws Exception {
        CyclicBarrier cb = new CyclicBarrier(N, () -> {
            System.out.println("赛车手准备就绪,GO....");
        });

        for (int i = 0; i < N +3; i++) {
            Thread racer = new Racer(i + "号赛车手", cb);
            racer.start();
            if (i == 3) {
                racer.interrupt();
            }
        }

        Thread.sleep(2000);
        System.out.println("Barrier是否损坏：" + cb.isBroken());

    }

    static class Racer extends Thread {
        CyclicBarrier cb;

        public Racer(String name, CyclicBarrier cb) {
            super(name);
            this.cb = cb;
        }

        @Override
        public void run() {
            try {
//                Thread.sleep(new Random().nextInt(1000));
                System.out.println(Thread.currentThread().getName() + "已经到达");
                cb.await();
            } catch (InterruptedException e) {
//                e.printStackTrace();
                System.out.println(Thread.currentThread().getName() + ":被中断了");
            } catch (BrokenBarrierException e) {
//                e.printStackTrace();
                System.out.println(Thread.currentThread().getName() + ":抛出BrokenBarrierException");
            }

        }
    }
}
