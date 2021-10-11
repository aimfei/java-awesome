package com.enkeshu.algorithm.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * （自定义类描述）
 *
 * @author yemengard
 * @date 2021/10/11
 **/
public class SearchTest {

    @Test
    public void sequenceSearchTest() {
        int i = Search.sequenceSearch(new int[]{1, 2, 3, 4, 5}, 3);
        System.out.format("-->sequenceSearch找到对应数位置 %s开始查找%n", "2");
        assertEquals(2, i);
        // System.out.println("");
        int i1 = Search.sequenceSearch(new int[]{1, 2, 3, 4, 5}, 6);
        System.out.format("--->sequenceSearch未找到对应数位置 %s开始查找<---", "-1");
        assertEquals(-1, i1);
    }

    @Test
    public void binaryHalveSearchTest() {

        int i = Search.binaryHalveSearch(new int[]{1, 2, 3, 4, 5}, 3);
        System.out.format("-->binaryHalveSearch 找到对应数位置 %s开始查找%n", "2");
        assertEquals(2, i);
        // System.out.println("");
        int i1 = Search.binaryHalveSearch(new int[]{1, 2, 3, 4, 5}, 6);
        System.out.format("-->binaryHalveSearch未找到对应数位置 %s开始查找<---", "-1");
        assertEquals(-1, i1);
    }

    @Test
    public void binaryRecursionSearchTest() {
        int i = Search.binaryRecursionSearch(new int[]{1, 2, 3, 4, 5}, 3,0,5);
        System.out.format("-->binaryRecursionSearch找到对应数位置 %s开始查找%n", "2");
        assertEquals(2, i);
        // System.out.println("");
        int i1 = Search.binaryRecursionSearch(new int[]{1, 2, 3, 4, 5}, 6,0,5);
        System.out.format("--->binaryRecursionSearch未找到对应数位置 %s开始查找<---", "-1");
        assertEquals(-1, i1);
    }
}
