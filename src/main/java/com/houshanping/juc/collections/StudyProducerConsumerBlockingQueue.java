package com.houshanping.juc.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: houshanping
 * @Date: 2020/03/14 10:59
 */
public class StudyProducerConsumerBlockingQueue {

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(5);
        Channel<Data> channel = new Channel<>(blockingQueue);

        new Thread(new Producer(channel),"Producer1").start();
        new Thread(new Consumer(channel),"Consumer1").start();
        new Thread(new Consumer(channel),"Consumer2").start();
    }

    static class Data {
        String value;

        public Data(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }

    static class Channel<E> {
        BlockingQueue blockingQueue;

        public Channel(BlockingQueue blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        public void put(E e) throws Exception {
            blockingQueue.put(e);
        }

        public E take() throws Exception {
            return (E) blockingQueue.take();
        }

        public E peek() {
            return (E) blockingQueue.peek();
        }
    }

    static class Producer extends Thread {
        Channel channel;

        public Producer(Channel channel) {
            this.channel = channel;
        }

        @Override
        public void run() {
            while (true) {
                String v = String.valueOf(ThreadLocalRandom.current().nextInt());
                try {
                    Data data = new Data(v);
                    channel.put(data);
                    System.out.println(Thread.currentThread().getName() + "生产了:" + data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer extends Thread {
        Channel channel;

        public Consumer(Channel channel) {
            this.channel = channel;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Data data = (Data) channel.take();
                    System.out.println(Thread.currentThread().getName() + "当前消费了:" + data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

