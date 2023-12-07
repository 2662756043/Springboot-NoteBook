package noteboot.demo01lambda;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @ClassName DemoPrintRef
 * @Description TODO
 * @Author 郭怀朝
 * @Date 2023/12/6 15:02
 * @Version 1.0
 **/
public class DemoPrintRef {


    //    public static void main(String[] args) {
//        printMax(Demo05Supplier::getMax);
//    }
//    private static void printMax(Consumer<int[]> consumer) {
//        int[] arr = {10, 20, 30, 40, 50};
//        consumer.accept(arr);
//    }
    public static void main(String[] args) {
        Supplier<Long> supplier = () -> {
            return System.currentTimeMillis();
        };
        System.out.println(supplier.get());

        Supplier<Long> supp2 = System::currentTimeMillis;
        System.out.println(supp2.get());

    }

}
