package com.insping.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @Author: houshanping
 * @Date: 2020/03/10 15:41
 */
public class StudyAtomicReferenceFieldUpdater {

    public static void main(String[] args) throws Exception {
        Account account = new Account(0);
        List<Thread> people = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Thread one = new MyThread(String.valueOf(i), account);
            people.add(one);
            one.start();
        }

        for (Thread p : people) {
            p.join();
        }
        System.out.println(account);
    }

    static class MyThread extends Thread {
        Account account;

        public MyThread(String name, Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            account.incMoney();
        }
    }

    static class Account {
        public volatile int money;
        public AtomicIntegerFieldUpdater<Account> aaf = AtomicIntegerFieldUpdater.newUpdater(Account.class,"money");

        public Account(int money) {
            this.money = money;
        }

        public void incMoney() {
//            money++;
            aaf.incrementAndGet(this);
        }

        @Override
        public String toString() {
            return "Account{" +
                    "money=" + money +
                    '}';
        }
    }
}
