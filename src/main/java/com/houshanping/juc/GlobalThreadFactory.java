package main.java.com.houshanping.juc;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: houshanping
 * @Date: 2020/03/27 10:59
 */
public class GlobalThreadFactory implements ThreadFactory {
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String prefix;

    public GlobalThreadFactory(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, prefix + "-Thread-" + threadNumber.getAndIncrement());
    }
}
