package com.houshanping.juc.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: houshanping
 * @Date: 2020/03/10 14:32
 */
public class StudyAtomicReference {


    public static void main(String[] args) throws Exception {
        AtomicReference<Integer> ar = new AtomicReference<>(new Integer(1000));
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new MyThread("Thread-" + i, ar);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(ar.get());
    }


    static class MyThread extends Thread {
        AtomicReference<Integer> ar;

        public MyThread(String name, AtomicReference ar) {
            super(name);
            this.ar = ar;
        }

        @Override
        public void run() {
            while (true) {
                Integer oldV = ar.get();
                if (ar.compareAndSet(oldV, oldV + 1)) {
                    break;
                }
            }
        }
    }
}
