package com.houshanping.juc.collections;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author: houshanping
 * @Date: 2020/03/14 9:41
 */
public class StudyCollections {
    public static void main(String[] args) {
        CopyOnWriteArraySet set = new CopyOnWriteArraySet();
        System.out.println(set.add(1));
        System.out.println(set.add(1));
        System.out.println(set.add(2));
        System.out.println(set);
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
    }
}
