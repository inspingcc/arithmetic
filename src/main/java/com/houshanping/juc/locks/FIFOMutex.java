package com.houshanping.juc.locks;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author: houshanping
 * @Date: 2020/03/31 18:19
 */
public class FIFOMutex {
    AtomicBoolean locked = new AtomicBoolean(false);
    Queue<Thread> waiters = new ConcurrentLinkedQueue<>();

    public void lock() {
        Thread currentThread = Thread.currentThread();
        waiters.add(currentThread);
        while (waiters.peek() != currentThread || !locked.compareAndSet(false, true)) {
            LockSupport.park(this);
        }
        waiters.remove();
    }

    public void unlock() {
        locked.set(false);
        LockSupport.unpark(waiters.peek());
    }

}
