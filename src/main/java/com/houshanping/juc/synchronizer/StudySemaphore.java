package main.java.com.houshanping.juc.synchronizer;

import java.util.concurrent.Semaphore;

/**
 * @Author: houshanping
 * @Date: 2020/03/11 15:46
 */
public class StudySemaphore {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        new Thread(() -> {
            try {
                semaphore.acquire(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }).start();
    }
}
