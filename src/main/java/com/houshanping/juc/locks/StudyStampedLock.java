package main.java.com.houshanping.juc.locks;

import java.util.concurrent.locks.StampedLock;

/**
 * @Author: houshanping
 * @Date: 2020/03/09 14:25
 */
public class StudyStampedLock {


    public static class Point {
        private double x, y;
        private StampedLock lock = new StampedLock();

        void move(double newX, double newY) {
            long stamp = lock.writeLock();
            try {
                x = newX;
                y = newY;
            } finally {
                lock.unlockWrite(stamp);
            }
        }

        double distanceFromOrigin() {
            long stamp = lock.tryOptimisticRead();
            double currentX = x, currentY = y;
            if (!lock.validate(stamp)) {
                stamp = lock.readLock();
                try {
                    currentX = x;
                    currentY = y;
                } finally {
                    lock.unlockRead(stamp);
                }
            }
            return Math.sqrt(Math.pow(currentX, 2.0) + Math.pow(currentY, 2.0));
        }

        void moveIfAtOrigin(double newX, double newY) {
            long stamp = lock.readLock();
            try {
                while (x == 0.0 && y == 0.0) {
                    long ws = lock.tryConvertToWriteLock(stamp);
                    if (ws != 0L) {
                        stamp = ws;
                        x = newX;
                        y = newY;
                        break;
                    } else {
                        lock.unlockRead(stamp);
                        stamp = lock.writeLock();
                    }
                }
            } finally {
                lock.unlock(stamp);
            }
        }
    }
}
