package com.enkeshu.algorithm.arrayandstr;

/**
 * （自定义类描述）
 *
 * @author yemengard
 * @date 2021/9/16
 **/
public class ArrayAndString {

    /**
     * 二维数组中查找
     *
     * @param matrix
     * @param target
     * @return true
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int x = 0;
        int y = matrix.length - 1;
        while (matrix[0].length > x && y >= 0) {
            if (matrix[x][y] > target) {
                y--;
            } else if (matrix[x][y] < target) {
                x++;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     *
     */
    public String replaceSpace(String s) {

        StringBuilder buffer = new StringBuilder(s.length());

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                buffer.append("%20");
            } else {
                buffer.append(c);
            }
        }
        return buffer.toString();
    }
}
