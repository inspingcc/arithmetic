package com.inspingJDK.javaNIOStudy;

/**
 * @Author: houshanping
 * @Date: 2020/02/28 11:32
 */
public class Test {
    public static void main(String[] args) {
        int i = 1;
        labal:
        while (true) {
            System.out.println(i++);
            if (i % 2 == 1) break labal;
        }
        System.out.println("end");
    }
}
