package main.java.com.houshanping.juc.multithread;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: houshanping
 * @Date: 2020/03/06 11:38
 */
public class ProducerConsumer {

    public static AtomicInteger dataNum = new AtomicInteger(0);

    public static void main(String[] args) {
        Factory factory = new Factory(10);
        new Producer("producer1", factory).start();
        new Producer("producer2", factory).start();
        new Producer("producer3", factory).start();
        new Consumer("consumer1", factory).start();
        new Consumer("consumer2", factory).start();
    }

    public static class Factory {
        private int dataNum = 0;
        private int maxNum;

        public Factory(int maxNum) {
            this.maxNum = maxNum;
        }

        public synchronized void put() throws InterruptedException {
            while (dataNum > maxNum) {
                System.out.println("已经生产满了," + Thread.currentThread().getName() + "进入等待消费.");
                wait();
            }
            ++dataNum;
            System.out.println(Thread.currentThread().getName() + "生产一个,库存为:" + dataNum);
            notifyAll();
        }

        public synchronized int remove() throws InterruptedException {
            while (dataNum < 1) {
                System.out.println("暂时没有可以消费" + Thread.currentThread().getName() + "进入等待");
                wait();
            }
            --dataNum;
            System.out.println(Thread.currentThread().getName() + "消费一个,库存为:" + dataNum);
            notifyAll();
            return dataNum;
        }
    }

    static class Producer extends Thread {
        public Factory factory;

        public Producer(String name, Factory factory) {
            super(name);
            this.factory = factory;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    // 生产的时间
                    Thread.sleep(new Random(System.currentTimeMillis()).nextInt(1000));
                    factory.put();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer extends Thread {
        public Factory factory;

        public Consumer(String name, Factory factory) {
            super(name);
            this.factory = factory;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    factory.remove();
                    // 消费的时间
                    Thread.sleep(new Random(System.currentTimeMillis()).nextInt(1000));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
