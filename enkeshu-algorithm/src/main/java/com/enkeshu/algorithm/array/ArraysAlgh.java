package com.enkeshu.algorithm.array;

import java.util.Currency;

/**
 * （自定义类描述）
 *
 * @author yemengard
 * @date 2021/9/18
 **/
public class ArraysAlgh {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int cur = 0;
        int[] newnums = new int[]{};
        for (int i = 0; i <= nums.length; i++) {
            if (cur == nums[i]) {
                cur++;
            }else{
                newnums[cur]=nums[i];
            }
        }
        return cur;
    }
}
