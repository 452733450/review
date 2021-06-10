package com.jack.review.test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/01/15:13
 */
public class MainClass {
    public static void main(String[] args) {
        // 基本类型都有type属性，可以得到这个基本类型的类型，比如
        Class c1 = Integer.TYPE;

        test5();
    }

    // 根据一个字符串得到一个类
    public static void test1() {
        String name = "Huanglinqing";
        Class c1 = name.getClass();
        System.out.println(c1.getName());
    }

    // 获取java.lang.String的类名
    public static void test2() {
        String name = "java.lang.String";
        Class cl = null;
        try {
            cl = Class.forName(name);
            System.out.println(cl.getName());
            System.out.println(cl.getSuperclass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void test3() {
        // 获取类的所有构造方法
        Test test = new Test();
        Class c2 = test.getClass();
        Constructor[] constructors;
        constructors = c2.getDeclaredConstructors();

        // 得到了类中所有构造方法和构造方法中的参数
        for (Constructor constructor : constructors) {
            System.out.println(Modifier.toString(constructor.getModifiers()) + "参数：");
            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class c : parameterTypes) {
                System.out.println(c.getName() + "," + c.getTypeName());
            }
        }
    }

    public static void test4() {
        // 获取类的所有构造方法
        /*Test test = new Test();*/
        Class test = null;
        try {
            test = Class.forName("com.jack.review.test.reflect.Test");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class c2 = test.getClass();
        Constructor constructor;
        /*constructors = c2.getDeclaredConstructors();*/

        Class[] c3 = {int.class, String.class, int.class};
        try {
            constructor = c2.getDeclaredConstructor(c3);
            System.out.println(Modifier.toString(constructor.getModifiers()) + "参数：");
            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class c : parameterTypes) {
                System.out.println(c.getName());
            }
            // 调用构造方法
            // 调用私有构造方法
            constructor.setAccessible(true);
            constructor.newInstance(1, "jack", 2);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    // 调用类的私有方法
    public static void test5() {
        /*getDeclaredMethod：获取当前类的所有声明的方法，包括public、protected和private修饰的方法。
        需要注意的是，这些方法一定是在当前类中声明的，从父类中继承的不算，实现接口的方法由于有声明所以包括在内。

        getMethod：获取当前类和父类的所有public的方法。这里的父类，指的是继承层次中的所有父类。比如说，A继承B，B继承C，那么B和C都属于A的父类。*/
        try {
            Class clz = Class.forName("com.jack.review.test.reflect.Test");
            Class[] parameterTypes = {String.class};
            Method method = clz.getDeclaredMethod("welcome", parameterTypes);
            method.setAccessible(true);
            Constructor constructor = clz.getDeclaredConstructor();
            Object object = constructor.newInstance();
            method.invoke(object,"welcome");
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void test6(){

    }
}
