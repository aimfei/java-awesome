package com.enkeshu.common.proxy;

import java.lang.reflect.Proxy;

public class ProxySrv {
    public static void main(String[] args) {
        Pay pay=new AliPay();
        PayProxy payProxy=new PayProxy(pay);
        Pay pay1= (Pay) Proxy.newProxyInstance(payProxy.getClass().getClassLoader(),pay.getClass().getInterfaces(),payProxy);
        pay1.pay();
    }
}
