package main.java.com.houshanping.juc.locks;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition 实现生产者消费者
 *
 * @Author: houshanping
 * @Date: 2020/03/07 15:45
 */
public class StudyCondition {

    public static void main(String[] args) {
        FactoryData factoryData = new FactoryData();
        new Producer("producer1", factoryData).start();
        new Producer("producer2", factoryData).start();
        new Consumer("consumer1", factoryData).start();
//        new Consumer("consumer2", factoryData).start();
//        new Consumer("consumer3", factoryData).start();
    }


    private static class Producer extends Thread {
        FactoryData factoryData;

        public Producer(String name, FactoryData factoryData) {
            super(name);
            this.factoryData = factoryData;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    factoryData.put(1);
                    Thread.sleep(new Random().nextInt(1000));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Consumer extends Thread {
        FactoryData factoryData;

        public Consumer(String name, FactoryData factoryData) {
            super(name);
            this.factoryData = factoryData;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    factoryData.take();
                    Thread.sleep(new Random().nextInt(1000));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static class FactoryData {
        final Lock lock = new ReentrantLock();
        final Condition notEmpty = lock.newCondition();
        final Condition notFull = lock.newCondition();

        private int currentNum = 0;

        public void put(Integer one) throws Exception {
            lock.lock();
            try {
                while (currentNum >= 10) {
                    notFull.await();
                }
                currentNum++;
                System.out.println("生产后,当前数量为:" + currentNum);
                notEmpty.signal();
            } finally {
                lock.unlock();
            }
        }

        public int take() throws Exception {
            lock.lock();
            try {
                while (currentNum <= 0) {
                    notEmpty.await();
                }
                currentNum--;
                System.out.println("消费后,当前数量为:" + currentNum);
                notFull.signal();
                return currentNum;

            } finally {
                lock.unlock();
            }
        }
    }
}
