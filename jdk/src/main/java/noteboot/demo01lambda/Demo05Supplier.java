package noteboot.demo01lambda;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @ClassName Demo05Supplier
 * @Description TODO
 * @Author 郭怀朝
 * @Date 2023/12/6 14:52
 * @Version 1.0
 **/
public class Demo05Supplier {
//    public static void main(String[] args) {
//        printMax(() -> {
//            int[] arr = {10, 20, 100, 30, 40, 50};
//            //先排序最后就是最大的
//            Arrays.sort(arr);
//            return arr[arr.length - 1];
//        });
//    }
//
//    private static void printMax(Supplier<Integer> supplier) {
//        int max = supplier.get();
//        System.out.println("max = " + max);
//    }

    public static void getMax(int[] arr) {
        int sum = 0;
        for (int n : arr) {
            sum += n;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        test(s->s.length() ==3,"TEST");
    }
private static void test(Predicate<String> predicate, String str) {
    boolean veryLong = predicate.test(str);
    System.out.println("名字很长吗：" + veryLong);
}
}
