package LeetCode;

import java.util.Arrays;

/**
 * 只出现一次的数字
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        Arrays.sort(nums);
        int count = 1;

        for(int i = 0; i < nums.length; i ++) {

        }

        return 0;
    }
}
