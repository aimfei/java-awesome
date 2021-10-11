package com.enkeshu.algorithm.search;

/**
 * （自定义类描述）
 *
 * @author yemengard
 **/
public class Search {

    /**
     * 顺序查询
     *
     * @return
     */
    public static int sequenceSearch(int[] array, int value) {
        if (array.length == 0) {
            return -1;
        }
        int result = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                result = i;
            }
        }
        return result;
    }

    /**
     * 二分折半查找，属于有序查找算法
     *
     * @param array
     * @param value
     * @return
     */
    public static int binaryHalveSearch(int[] array, int value) {
        int result = -1;
        int low, high, mid;
        low = 0;
        high = array.length-1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] == value) {
                result = mid;
                break;
            } else if (array[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    /**
     * 二分递归查找 属于有序查找算法
     *
     * @param array
     * @param value
     * @return
     */

    public static int binaryRecursionSearch(int[] array, int value, int low, int high) {
        int mid = low + (high - low) / 2;
        if (array[mid] == value) return mid;
        if (array[mid] > value)
            return binaryRecursionSearch(array, value, low, mid - 1);
        if (array[mid] < value)
            return binaryRecursionSearch(array, value, mid + 1, high);
        return -1;
    }


}
