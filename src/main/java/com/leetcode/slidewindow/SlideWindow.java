package com.leetcode.slidewindow;

/**
 * @author HDU-AIOT-WuHD
 * @date 2024-04-28 9:43
 **/
public class SlideWindow {
    /**
     * 长度最小的子数组
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        while(right < len) {
            sum += nums[right];
            while(left < right && sum - nums[left] >= target) {
                sum -= nums[left];
                left++;
            }
            if(sum >= target) {
                ans = Math.min(ans,right - left);
            }
            right++;

        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
