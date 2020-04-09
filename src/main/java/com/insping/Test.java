package com.insping;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: houshanping
 * @Date: 2020/03/07 17:41
 */
public class Test {
    public static final int THREAD_NUM = 1000;

    public static void main(String[] args) throws Exception {
        Map<Integer, Action> map = new ConcurrentHashMap<>();
        map.put(1, new Action("1", 1));
        CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUM);
        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(() -> {
                synchronized (map) {
                    Action data = map.get(1);
                    data.v.put("1", Integer.valueOf(String.valueOf(data.v.get("1"))) + 1);
                    countDownLatch.countDown();
                }
            }, "Thread-" + i).start();
        }
        countDownLatch.await();
        System.out.println("结果:"+map.get(1).v);
    }

    public static class Action {
        Map<String, Object> v = new HashMap<>();

        public Action(String k, Object v) {
            this.v.put(k, v);
        }
    }
}
