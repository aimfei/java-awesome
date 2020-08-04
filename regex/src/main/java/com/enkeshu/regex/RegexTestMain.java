package com.enkeshu.regex;

public class RegexTestMain {
    public static void main(String[] args) {
        String repx="^/mem/1/[\\w\\d]+/details$";
        String a="/mem/31212/details";
        System.out.println(a.matches(repx));
    }
}
