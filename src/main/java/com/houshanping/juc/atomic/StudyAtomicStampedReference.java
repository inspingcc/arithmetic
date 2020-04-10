package com.houshanping.juc.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author: houshanping
 * @Date: 2020/03/10 14:32
 */
public class StudyAtomicStampedReference {

    public static void main(String[] args) throws Exception {
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(new Integer(0), 0);
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new MyThread("Thread-" + i, atomicStampedReference);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(atomicStampedReference.getReference());
    }

    static class MyThread extends Thread {
        AtomicStampedReference<Integer> atomicStampedReference;

        public MyThread(String name, AtomicStampedReference<Integer> atomicStampedReference) {
            super(name);
            this.atomicStampedReference = atomicStampedReference;
        }

        @Override
        public void run() {
            while (true) {
                int[] stamps = new int[1];
                Integer oldValue = atomicStampedReference.get(stamps);
                int oldStamp = stamps[0];
                if (atomicStampedReference.compareAndSet(oldValue, oldValue + 1, oldStamp, oldStamp + 1)) {
                    break;
                }
            }
        }
    }


}
