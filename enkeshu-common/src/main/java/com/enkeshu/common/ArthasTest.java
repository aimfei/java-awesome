package com.enkeshu.common;

import java.io.IOException;

public class ArthasTest {
    public static void main(String[] args) throws IOException {
       // new CpuHigh().cpu();
        Runtime.getRuntime().exec("jstat -gccapacity");
    }
}
