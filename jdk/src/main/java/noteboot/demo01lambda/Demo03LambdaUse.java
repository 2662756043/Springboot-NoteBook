package noteboot.demo01lambda;

import java.util.*;
import java.util.function.Consumer;

/**
 * @ClassName Demo03LambdaUse
 * @Description 练习有参数有返回值的lambda
 * @Author 郭怀朝
 * @Date 2023/12/6 14:13
 * @Version 1.0
 **/
public class Demo03LambdaUse {
    /**
     * 传统写法
     */
//    public static void main(String[] args) {
//        List<Person> persons = new ArrayList<>();
//        persons.add(new Person("刘德华", 10, 174));
//        persons.add(new Person("张三", 58, 174));
//        persons.add(new Person("李四", 20, 17214));
//        persons.add(new Person("王五", 30, 1724));
//        persons.add(new Person("赵六", 60, 174));
//
//        // 按照年龄来进行排序 重写其中的方法
//        Collections.sort(persons, new Comparator<Person>() {
//            // 重写 从小到大排
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });
//
//        for (Person person : persons) {
//            System.out.println(person);
//        }
//
//    }

    /**
     * lambda写法
     */
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("刘德华", 10, 174));
        persons.add(new Person("张三", 58, 174));
        persons.add(new Person("李四", 20, 17214));
        persons.add(new Person("王五", 30, 1724));
        persons.add(new Person("赵六", 60, 174));
        // 排序lambda
        Collections.sort(persons, (o1, o2) -> {
            return o1.getAge() - o2.getAge();
        });
        for (Person person : persons) {
            System.out.println(person);
        }
        System.out.println("-----------------");

        List<Integer> list = Arrays.asList(32, 22, 33, 44);
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        System.out.println("-----------------");

        list.forEach((s -> {
            System.out.println(s);
        }));
    }
    /**
     * (参数列表)->{
     *     方法体
     * }
     */

    /**
     * （int a）->{
     * return new Integer();
     * }
     */
    //1. 小括号内参数的类型可以省略
    //2. 如果小括号内有且仅有一个参数，则小括号可以省略
    //3. 如果大括号内有且仅有一个语句，可以同时省略大括号、return关键字及语句分号
    //a -> new Person()



}
