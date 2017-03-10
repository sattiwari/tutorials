package leetcode;

import java.util.Arrays;

/**
 * Created by stiwari on 2/17/2017 AD.
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[]{0, 0};

        int i = 0;
        int len = nums.length;

        while(i < len) {
            int j = i+1;
            while(j < len) {
                if(nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
                j++;
            }
            i++;
        }


        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 7, 11, 15};
        int[] res = twoSum(input, 9);

        assert(Arrays.equals(res, new int[]{0, 1}));
    }




}
