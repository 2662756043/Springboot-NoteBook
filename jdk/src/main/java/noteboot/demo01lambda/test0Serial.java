package noteboot.demo01lambda;


import java.util.stream.Stream;

/**
 * @ClassName test0Serial
 * @Description
 * @Author 郭怀朝
 * @Date 2023/12/6 17:09
 * @Version 1.0
 **/
public class test0Serial {
    // 串行流 单线程
    public static void main(String[] args) {
        long count = Stream.of(4, 5, 3, 9, 1, 2, 6).filter(
                s -> {
                    System.out.println(Thread.currentThread() + ", s = " + s);
                    return true;
                }
        ).count();
        System.out.println("count = " + count);
    }
}
