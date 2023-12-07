package noteboot.demo01lambda;

/**
 * @ClassName Demo01LambdaIntro
 * @Description 多线程
 * @Author 郭怀朝
 * @Date 2023/12/6 13:57
 * @Version 1.0
 **/
public class Demo01LambdaIntro {
    /**
     * 传统写法
     */
//    public static void main(String[] args) {
//        // 创建线程
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("新的线程开始执行！");
//            }
//        }).start();
//    }

    /**
     * lambda写法 无参写法
     */
//    public static void main(String[] args) {
//        new Thread(() -> System.out.println("启动线程")).start();
//    }

    /**
     * （型参类型 参数名称）->{
     * 代码体
     * }
     * 无参构造可以省略
     */

//    练习无参数无返回值的Lambda
    interface Swimmable {
        // 定义一个抽象的方法
        public abstract void swimming();
    }

    public static void main(String[] args) {
        // 重写该方法
        goSwimming(new Swimmable() {
            @Override
            public void swimming() {
                System.out.println("匿名内部类游泳");
            }
        });
        // lambda重写
        goSwimming(() -> System.out.println("lambda重写该方法"));
    }

    // 固定的方法
    public static void goSwimming(Swimmable swimmable) {
        swimmable.swimming();
    }

}
