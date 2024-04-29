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


    /**
     * 无重复字符的最长子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[130];
        int len = s.length();
        int left = 0;
        int right = 0;
        int ans = Integer.MIN_VALUE;
        while(right < len) {

            while(left < right && arr[s.charAt(right)] != 0) {
                arr[s.charAt(left)] = 0;
                left++;
            }
            arr[s.charAt(right)] = 1;
            ans = Math.max(ans,right-left+1);
            right++;
        }

        return ans==Integer.MIN_VALUE ? 0 : ans;
    }
}
