package com.enkeshu.algorithm.array;

import java.util.ArrayList;
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
            } else {
                newnums[cur] = nums[i];
            }
        }
        return cur;
    }


    /**
     * 出处:https://leetcode-cn.com/problems/two-sum/
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (target == 0 && nums.length == 0) {
            return new int[]{};
        }
        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    results.add(i);
                    results.add(j);
                }
            }
        }
        return null;
    }
}
