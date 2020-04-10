package com.houshanping.juc.synchronizer;

import java.util.concurrent.Phaser;

/**
 * @Author: houshanping
 * @Date: 2020/03/11 19:49
 */
public class StudyPhaser2 {

    public static void main(String[] args) {
        int num = 3;
        Phaser phaser = new Phaser() {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("当前阶段:" + phase + ",Parties:" + registeredParties);
                return phase + 1 > num || registeredParties == 0;
            }
        };

        for (int i = 0; i < 10; i++) {
            phaser.register();
            new Thread(new Task(phaser), "Thread-" + i).start();
        }
    }

    static class Task extends Thread {
        Phaser phaser;

        public Task(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            while (!phaser.isTerminated()) {
                int nextPhase = phaser.arriveAndAwaitAdvance();
                System.out.println(Thread.currentThread().getName() + "执行完成");
            }
        }
    }
}
