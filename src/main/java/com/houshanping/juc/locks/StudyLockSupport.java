package main.java.com.houshanping.juc.locks;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * LockSupport 工具类的使用
 * 简单化的公平锁ReentrantLock
 *
 * @Author: houshanping
 * @Date: 2020/03/09 9:55
 */
public class StudyLockSupport {
    public static void main(String[] args) throws Exception {
        FIFOMutex mutex = new FIFOMutex();
        Lock reentrantLock = new ReentrantLock(true);
        MyThread a1 = new MyThread("a1", mutex, reentrantLock);
        MyThread a2 = new MyThread("a2", mutex, reentrantLock);
        MyThread a3 = new MyThread("a3", mutex, reentrantLock);
        a1.start();
        a2.start();
        a3.start();

        a1.join();
        a2.join();
        a3.join();

        assert MyThread.count == 300;
        System.out.println("Finished");
    }


    public static class MyThread extends Thread {
        String name;
        FIFOMutex mutex;
        Lock lock;
        public static int count = 0;

        public MyThread(String name, FIFOMutex mutex, Lock lock) {
            super(name);
            this.mutex = mutex;
            this.lock = lock;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                count++;
                System.out.println("name:" + Thread.currentThread().getName() + "  count:" + count);
                lock.unlock();
            }
        }
    }

    public static class FIFOMutex {
        AtomicBoolean locked = new AtomicBoolean(false);
        Queue<Thread> waiters = new ConcurrentLinkedDeque<>();

        public void lock() {
            Thread currentThread = Thread.currentThread();
            waiters.add(currentThread);
            while (waiters.peek() != currentThread || !locked.compareAndSet(false, true)) {
                LockSupport.park(this);
            }
            waiters.remove();
        }

        public void unlock() {
            locked.compareAndSet(true, false);
            LockSupport.unpark(waiters.peek());
        }
    }
}
