package main.java.com.houshanping.juc.synchronizer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Phaser;

/**
 * @Author: houshanping
 * @Date: 2020/03/11 19:37
 */
public class StudyPhaser1 {

    public static void main(String[] args) throws Exception {
        Phaser phaser = new Phaser(1);
        for (int i = 0; i < 10; i++) {
            phaser.register();
            new Thread(new MyThread(phaser), "Thread-" + i).start();
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();

        phaser.arriveAndDeregister();
        System.out.println("主线程开启");
    }

    static class MyThread extends Thread {
        Phaser phaser;

        public MyThread(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            int nextPhase = phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + ",执行完成,下个阶段:" + nextPhase);
        }
    }
}
