package com.houshanping.parse;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: houshanping
 * @Date: 2020/04/09 9:47
 */
public class ParseTest {

    public static List<Long> diffs = new ArrayList<>();

    public static void main(String[] args) throws Exception {
//        Parse.initialize("com.playstrap.clashofrome", "jsding@parse", "http://s3001.flamingogames-tech.cn:1337/parse/");
//
//        for (int i = 0; i < 10000; i++) {
//            ParseObject o = new ParseObject("ParseTest");
//            o.put("uid", "4649a623-6748-4b16-9883-491a8d0a1969");
//            o.put("sid", 9999);
//            o.put("updateObj", "{\"food\":10000,\"wood\":10000,\"iron\":10000,\"silver\":10000}");
//            o.put("updateTime", System.currentTimeMillis());
//            o.put("reason", "Test");
//            o.saveInBackground();
//            Thread.sleep(1000);
//        }

    }


    public static void addDiff(long diff) {
        System.out.println("当前执行时间:" + diff + "ms");
//        synchronized (diffs) {
//            diffs.add(diff);
//            System.out.println("平均值:" + diffs.stream().mapToLong(Long::longValue).average());
//        }
    }
}
