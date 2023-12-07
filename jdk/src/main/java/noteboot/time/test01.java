package noteboot.time;

import java.time.LocalDate;

/**
 * @ClassName test01
 * @Description 时间
 * @Author 郭怀朝
 * @Date 2023/12/6 17:32
 * @Version 1.0
 **/
public class test01 {
    // 创建指定日期
    public static void main(String[] args) {
        LocalDate of = LocalDate.of(1937, 9, 13);
        System.out.println(of);
        LocalDate now = LocalDate.now();
        System.out.println(now);
    }
}
