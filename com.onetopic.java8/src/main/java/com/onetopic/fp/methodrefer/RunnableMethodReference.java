package com.onetopic.fp.methodrefer;

// functional/RunnableMethodReference.java

// 方法引用与 Runnable 接口的结合使用

class Go {
    static void go() {
        System.out.println("Go::go()");
    }
}

public class RunnableMethodReference {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            public void run() {
                System.out.println("Anonymous");
            }
        }).start();

        new Thread(
                () -> System.out.println("lambda")
        ).start();

        new Thread(Go::go).start(); //Thread 对象将 Runnable 作为其构造函数参数
    }
}
