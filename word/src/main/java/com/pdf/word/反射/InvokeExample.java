package com.pdf.word.反射;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author fulin
 * @since 2023/3/11 16:57
 */
public class InvokeExample {

    public int stringMethod(String s) {
        return (s + "|" + s).length();
    }

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        InvokeExample example = new InvokeExample();
        // 获取方法的句柄并绑定 this 对象后执行
        Object r = lookup.findVirtual(InvokeExample.class,
                        "stringMethod",
                        MethodType.methodType(int.class, String.class)
                )// 获取方法类型
                .bindTo(example) // 绑定 this 对象
                .invoke("invoke stringMethod"); // 方法参数
        System.out.println(r);
    }
}

