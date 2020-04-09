package main.java.com.houshanping.arithmetic.study;

import java.io.*;
import java.security.Timestamp;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JdkStudy {


    public static void main(String[] args) throws IOException {
        List<Integer> arrayList = new ArrayList(Arrays.asList(2, 3, 4, 7, 12, 1, 0, 3));
//        Map<Integer, Integer> map = new HashMap<>(Map.of(1, 1, 2, 2, 3, 3));
        //=============================================================== 函数式接口 java.util.function
        // Supplier     不接受值    返回一个对象

        // Consumer     接收一个T   没有返回值
        // Predicate    接收一个T   返回布尔值
        // Function     接收一个T   返回一个R
        // UnaryOperator    接收一个T   返回有个T

        // BiConsumer   接收T和U   没有返回值
        // BiPredicate  接收T和U   返回布尔值
        // BiFunction   接收T和U   返回一个R
        // BinaryOperator   接收两个T   返回一个T
        //=============================================================== Stream流   java.util.stream
//        arrayList.forEach(a -> System.out.println(a));
//        map.forEach((k, v) -> System.out.println(k + ":" + v));
//        arrayList.removeIf(a -> a < 5);
//        arrayList.forEach(a -> System.out.println(a));

//        map.replaceAll((k, v) -> {
//            if (k == 1) return Integer.MAX_VALUE;
//            else return v;
//        });
//        map.forEach((k, v) -> System.out.println(k + ":" + v));
//        Supplier<Integer> stringSupplier = () -> Integer.valueOf(1);
//        arrayList.add(stringSupplier.get());
//        List<Integer> testNums = new ArrayList<>();
//        Random random = new Random();
//        for (int i = 0; i < 200000000; i++) {
//            testNums.add(random.nextInt(10));
//        }
//        long startTime = System.currentTimeMillis();
//        IntSummaryStatistics summaryStatistics = testNums.parallelStream().mapToInt(a -> Integer.valueOf(a)).summaryStatistics();
//        summaryStatistics.getMax();
//        summaryStatistics.getMin();
//        summaryStatistics.getAverage();
//        summaryStatistics.getSum();
//        summaryStatistics.getCount();
//        System.out.println(System.currentTimeMillis() - startTime);
//        startTime = System.currentTimeMillis();
//        int max = testNums.get(0);
//        int min = testNums.get(0);
//        int sum = 0;
//        for (int i = 0; i < testNums.size(); i++) {
//            if (testNums.get(i) > max) max = testNums.get(i);
//            if (testNums.get(i) < min) min = testNums.get(i);
//            sum += testNums.get(i);
//        }
//        double avg = (double) sum / testNums.size();
//        System.out.println(System.currentTimeMillis() - startTime);
//        List<Integer> a1 = arrayList.stream().collect(Collectors.toList());
//        Set<Integer> a2 = arrayList.stream().collect(Collectors.toCollection(HashSet::new));
//        String allStr = arrayList.stream().map(a -> String.valueOf(a)).collect(Collectors.joining());
//        String allStr1 = arrayList.stream().map(a -> String.valueOf(a)).collect(Collectors.joining(" "));
//        String allStr2 = arrayList.stream().map(a -> String.valueOf(a)).collect(Collectors.joining(" ","pre-","-sup"));
//        String allStr3 = arrayList.stream().collect(Collectors.mapping(a->String.valueOf(a),Collectors.joining(" ")));
//        System.out.println(allStr);
//        System.out.println(allStr1);
//        System.out.println(allStr2);

//        List<List<String>> strList = new ArrayList<>();
//        strList.add(new ArrayList<>(Arrays.asList("Hello","World","Java")));
//        strList.add(new ArrayList<>(Arrays.asList("Study","Java","stream")));
//        strList.add(new ArrayList<>(Arrays.asList("It","is","nice")));
//        strList.stream().flatMap(a->a.stream()).collect(Collectors.toList()).forEach(a-> System.out.println(a));
//        strList.stream().flatMap(a->a.stream()).flatMap(b->Stream.of(b.split("|"))).forEach(a-> System.out.println(a));
//        String str = "中华民族|123|abc";
//        Stream.of(str.split("|")).forEach(a-> System.out.print(a));
//        Stream.of(str.split("\\|")).forEach(a-> System.out.print(a+","));
//        Optional<Integer> reduce = Stream.of(1, 2, 3, 4, 5).reduce((a, b) -> a + b);
//        System.out.println(reduce.get());

        //=============================================================== 函数式接口
//        MyFunctionInterface a = () -> 1;
//        System.out.println(a.add());

        //=============================================================== Date-Time API java.time
//        System.out.println(Instant.now());
//        Instant time1 = Instant.parse("2019-09-09T00:00:01.000Z");
//        Instant time2 = Instant.parse("2019-10-09T00:00:01.000Z");
//        Instant now = Instant.now();
//        LocalDate localDate = LocalDate.now();
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(Instant.parse("2019-09-09T00:00:01.000Z"));
//        System.out.println(time1.isBefore(time2));
//        System.out.println(time2.isAfter(time1));
//        System.out.println(now.getEpochSecond());
//        System.out.println(now.getNano());
//        System.out.println(localDateTime.plusHours(1));
//        System.out.println(time1.toEpochMilli());
//        System.out.println(Instant.ofEpochMilli(1567987201000L));
//        System.out.println(localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
//        Student student = new Student("1",1);
//        student = null;
        //=============================================================== IO学习
//        System.out.println("请输出当前操作(q退出):");
//        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
//        List<String> strings = new ArrayList<>();
//        String str = "";
//        do {
//            str = read.readLine();
//            strings.add(str);
//        } while (!str.equals("q"));
//        strings.forEach(a -> {
//            try {
//                System.out.write(a.getBytes());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
        File file = new File("D://tmp/jdkStudy/1/test.txt");
//        if (!file.getParentFile().exists()) {
//            file.getParentFile().mkdirs();
//        }
//        OutputStream outputStream = new FileOutputStream(file,true);
//        for (int i = 0; i < 10; i++) {
//            outputStream.write("负责\r\n".getBytes());
//        }
//
//        outputStream.close();
        InputStream inputStream = new FileInputStream(file);
        byte[] data = new byte[1024];
        int len = inputStream.read(data);
        inputStream.close();
        System.out.println(new String(data, 0, len));
    }

    static class Student {
        public String name;
        public int age;

        public Student() {
        }

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
