package com.yangli.mybatis.test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by lies on 2018/3/30.
 */
public class TestIsDefaultMethod {

    private void testMethod1(){};
    private final static void testMethod2(){};
    private final void testMethod3(){};

    private static boolean isDefaultMethod(Method method) {
        return ((method.getModifiers()& (Modifier.ABSTRACT | Modifier.PUBLIC | Modifier.STATIC)) == Modifier.PUBLIC)&& method.getDeclaringClass().isInterface();
    }

    public static void main(String[] args) {
        Method[] methods = TestIsDefaultMethod.class.getDeclaredMethods();
        System.out.println(methods.length);
        for (int i = 0 ; i < methods.length ; i++){
//            System.out.println(methods[i].toString());
            Method method = methods[i];
            System.out.println(method);
            System.out.println(Modifier.toString(method.getModifiers()));

            System.out.println("Modifier.ABSTRACT : " + Modifier.ABSTRACT); // 1024
            System.out.println("Modifier.PUBLIC : " + Modifier.PUBLIC);     // 1
            System.out.println("Modifier.STATIC : " + Modifier.STATIC);     // 8

            System.out.println(isDefaultMethod(method));
        }
    }
}
