package noteboot.demo01lambda;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @ClassName StreamInfo
 * @Description TODO
 * @Author 郭怀朝
 * @Date 2023/12/6 15:14
 * @Version 1.0
 **/
public class StreamInfo {
    public static void main(String[] args) {
        // 一个ArrayList集合中存储有以下数据:张无忌,周芷若,赵敏,张强,张三丰
        // 需求:1.拿到所有姓张的 2.拿到名字长度为3个字的 3.打印这些数据
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰");
        // 1.拿到所有姓张的
        ArrayList<String> zhangList = new ArrayList<>(); // {"张无忌", "张强", "张三丰"}
        for (String name : list) {
            if (name.startsWith("张")) {
                zhangList.add(name);
            }
        }
        // 2.拿到名字长度为3个字的
        ArrayList<String> threeList = new ArrayList<>(); // {"张无忌", "张三丰"}
        for (String name : zhangList) {
            if (name.length() == 3) {
                threeList.add(name);
            }
        }
        // 3.打印这些数据
        for (String name : threeList) {
            System.out.println(name);
        }
    }
}
