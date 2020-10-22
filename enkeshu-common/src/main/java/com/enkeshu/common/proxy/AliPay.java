package com.enkeshu.common.proxy;

public class AliPay implements Pay {
    @Override
    public String getPayType() {
        return "alipay";
    }

    @Override
    public void pay() {
        System.out.println("ali pay");
    }
}
