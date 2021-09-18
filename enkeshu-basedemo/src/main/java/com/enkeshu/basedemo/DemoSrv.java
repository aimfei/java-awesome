package com.enkeshu.basedemo;

import java.io.StringBufferInputStream;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

public class DemoSrv {
    public static void main(String[] args) {


        StringBuilder builder=new StringBuilder();
        final StringBuffer buffer = new StringBuffer();
        System.out.println(10 >> 1);
    }

    public static final int tableSizeFor(int cap) {
        int n = cap - 1;
        System.out.println(n);
        n |= n >>> 1;
        System.out.println(n);
        n |= n >>> 2;
        System.out.println(n);
        n |= n >>> 4;
        System.out.println(n);
        n |= n >>> 8;
        System.out.println(n);
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
    }
}
