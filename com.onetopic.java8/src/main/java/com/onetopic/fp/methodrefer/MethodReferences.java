package com.onetopic.fp.methodrefer;

interface Callable { // [1]
    void call(String s);
}

class Describe {
    void show(String msg) { // [2]
        System.out.println(msg);
    }
}

public class MethodReferences {
    static void hello(String name) { // [3]
        System.out.println("Hello, " + name);
    }
    static class Description {
        String about;
        Description(String desc) { about = desc; }
        void help(String msg) { // [4]
            System.out.println(about + " " + msg);
        }
    }
    static class Helper {
        static void assist(String msg) { // [5]
            System.out.println(msg);
        }
    }
    public static void main(String[] args) {
        Describe d = new Describe();
        Callable c = d::show; // [6] show() ��ǩ�����������ͺͷ������ͣ����� Callable �� call() ��ǩ����
        c.call("call()"); // [7]

        c = MethodReferences::hello; // [8]hello() Ҳ���� call() ��ǩ��
        c.call("Bob");

        c = new Description("valuable")::help; // [9] help() Ҳ���ϣ����Ǿ�̬�ڲ����еķǾ�̬������
        c.call("information");

        c = Helper::assist; // [10] assist() �Ǿ�̬�ڲ����еľ�̬����
        c.call("Help!");
    }
}
