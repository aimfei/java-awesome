package com.enkeshu.common;

import java.util.concurrent.atomic.AtomicInteger;

public class CpuHigh {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public void cpu()  {
        while (true) {
            byte[] b=new byte[3*1024*1024];
            atomicInteger.incrementAndGet();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("==========CpuHig=" + atomicInteger.get() +"b="+b);
        }
    }
}
