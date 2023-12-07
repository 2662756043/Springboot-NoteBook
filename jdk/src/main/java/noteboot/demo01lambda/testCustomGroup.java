package noteboot.demo01lambda;

import java.sql.SQLOutput;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName testCustomGroup
 * @Description TODO
 * @Author 郭怀朝
 * @Date 2023/12/6 16:08
 * @Version 1.0
 **/
public class testCustomGroup {

    /**
     * 分组
     * @param args
     */
//    public static void main(String[] args) {
//
//        Stream<Student> studentStream = Stream.of(
//                new Student("赵丽颖", 52, 95),
//                new Student("杨颖", 56, 88),
//                new Student("迪丽热巴", 56, 99),
//                new Student("柳岩", 52, 77));
//
//
//        // 按照分数进行分组
//        Map<Integer, Map<String, List<Student>>> studentMap = studentStream.collect(Collectors.groupingBy(s -> s.getAge(), Collectors.groupingBy(s -> {
//            if (s.getSocre() >= 90) {
//                return "优秀";
//            } else if (s.getSocre() >= 80 && s.getSocre() < 90) {
//                return "良好";
//            } else if (s.getSocre() >= 80 && s.getSocre() < 80) {
//                return "及格";
//            } else {
//                return "不及格";
//            }
//        })));
//
//        studentMap.forEach((k,v)->{
//            System.out.println(k + " == " + v);
//        });
//
//    }

    /**
     * 分区
     */
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 52, 95),
                new Student("杨颖", 56, 88),
                new Student("迪丽热巴", 56, 99),
                new Student("柳岩", 52, 77));

        // partitioningBy会根据值是否为true，把集合分割为两个列表，一个true列表，一个false列表。
        Map<Boolean, List<Student>> map = studentStream.collect(Collectors.partitioningBy(s ->
                s.getSocre() >= 90));

        map.forEach((k, v) -> System.out.println(k + "==" + v));
    }


}
