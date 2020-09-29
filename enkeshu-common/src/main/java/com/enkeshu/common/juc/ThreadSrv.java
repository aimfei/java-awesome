package com.enkeshu.common.juc;

public class ThreadSrv {


    public static volatile boolean flag=false;
    public static void main(String[] args) {

        new Thread(()->{
           while (flag){
               System.out.println("初始化数据");
               try {
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }).start();

        new Thread(()->{
            System.out.println("准备修改flag");
            flag=true;
            System.out.println("已经修改完flag");
        }).start();
    }

}
