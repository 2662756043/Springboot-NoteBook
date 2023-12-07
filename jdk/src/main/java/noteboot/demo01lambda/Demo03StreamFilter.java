package noteboot.demo01lambda;

import java.util.*;
import java.util.stream.Stream;

/**
 * @ClassName Demo03StreamFilter
 * @Description
 * @Author 郭怀朝
 * @Date 2023/12/6 15:16
 * @Version 1.0
 **/
public class Demo03StreamFilter {
//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("张无忌");
//        list.add("周芷若");
//        list.add("赵敏");
//        list.add("张强");
//        list.add("张三丰");
//
//        // 使用stream循环
//        list.stream()
//                .filter(s -> s.startsWith("张")) // 过滤张开头的
//                .filter(s->s.length() == 3)
//                .forEach(System.out::println);
//    }

//    public static void main(String[] args) {
//        List<String> one = new ArrayList<>();
//        Collections.addAll(one, "迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子");
//        // 循环
//        one.forEach((String s) -> {
//            System.out.println(s);
//        });
//        System.out.println("------------------");
//        //简写
//        one.stream().forEach(s -> System.out.println(s));
//        System.out.println(one.stream().count());
//
//    }

    public static void main(String[] args) {
        // 去重
        Stream.of(33, 22, 66, 66).distinct().forEach(s -> System.out.println(s));
        //找最大
        Optional<Integer> max = Stream.of(12, 12312, 312, 1231).max((o1, o2) -> o1 - o2);
        System.out.println(max.get());
        //找最小
        Optional<Integer> min = Stream.of(12, 22, 12, 1, 34).min((o1, o2) -> o1 - o2);
        System.out.println(min.get());

        //使用reduce进行求和
        Integer reduce = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).reduce(0, (x, y) -> {
            return Integer.sum(x, y);
        });
        System.out.println(reduce);

        //Stream流的concat方法
        //如果有两个流，希望合并成为一个流，那么可以使用 Stream 接口的静态方法 concat ：
        Stream<String> streamA = Stream.of("张三");
        Stream<String> streamB = Stream.of("李四");
        Stream<String> concat = Stream.concat(streamA, streamB);
        concat.forEach(s -> System.out.println(s));
    }


}
