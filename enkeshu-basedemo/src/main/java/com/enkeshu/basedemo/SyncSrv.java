package com.enkeshu.basedemo;

public class SyncSrv {
    public static void main(String[] args) {
        Object o = new Object();
        synchronized (o){
            System.out.println("111");
            method();
        }
        System.out.println("测试完成");
    }
    public static synchronized void method(){
        System.out.println("hello");
    }
}
