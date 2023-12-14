package com.pdf.word.反射;

import java.lang.reflect.Method;

/**
 * @author fulin
 * @since 2023/3/11 16:55
 */
public class ReflectExample {

    public String stringMethod(String s) {
        return s + "|" + s;
    }

    public static void main(String[] args) throws Throwable {
        ReflectExample example = new ReflectExample();
        Method stringMethod = ReflectExample.class.getMethod("stringMethod", String.class);
        String reflect = (String) stringMethod.invoke(example, "reflect");// reflect|reflect

        String name = ReflectExample.class.getName();
        System.out.println(reflect);
    }
}
