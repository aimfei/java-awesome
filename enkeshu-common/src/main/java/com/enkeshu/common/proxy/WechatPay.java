package com.enkeshu.common.proxy;

public class WechatPay implements Pay {

    @Override
    public String getPayType() {
        return "微信支付";
    }

    @Override
    public void pay() {
        System.out.println("wechat pay");
    }
}
