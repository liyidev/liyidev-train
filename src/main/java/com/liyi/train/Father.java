package com.liyi.train;

/**
 * @description:
 * @author: liyi
 * @create: 2018-10-10 19:35
 */
public class Father {
    static void a() {
        System.out.println("father A");
    }
    static void b() {
        System.out.println("father B");
    }
    {
        System.out.println("father 代码块");
    }
    static {
        System.out.println("father 静态代码块");
    }
    protected void test(){
        System.out.println("this is father's test");
    }

    public Father(){
        System.out.println("father 构造器");
    }
}
