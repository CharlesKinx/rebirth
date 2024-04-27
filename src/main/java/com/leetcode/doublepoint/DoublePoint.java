package com.leetcode.doublepoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author HDU-AIOT-WuHD
 * @date 2024-04-25 10:03
 **/
public class DoublePoint {


    /**
     * 验证回文串
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        String str1 = getStr(s);
        int left = 0;
        int right = str1.length()-1;

        String str = str1.toLowerCase();
        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;

        }
        return true;
    }

    public String getStr(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<s.length();i++) {
            if((s.charAt(i) >= 65 && s.charAt(i) <= 90) || (s.charAt(i) >= 97 && s.charAt(i) <= 122) || (s.charAt(i) >= 48 && s.charAt(i) <= 57)) {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();

    }


    /**
     * 判断子序列
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();

        if(len1 > len2) {
            return false;
        }

        int ind1 = 0;
        int ind2 = 0;

        while(ind1 < len1 && ind2 < len2) {
            if(s.charAt(ind1) == t.charAt(ind2)) {
                ind1++;
            }
            ind2++;

        }
        if(ind1 == len1) {
            return true;
        }else{
            return false;
        }
    }


    /**
     * 两数之和 II - 输入有序数组
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;
        int[] ans = new int[2];

        while(left != right) {
            if(numbers[left] + numbers[right] == target) {
                ans[0] = left;
                ans[1] = right;
                break;
            }else if(numbers[left] + numbers[right] > target) {
                right--;
            }else{
                left++;
            }
        }

        return ans;

    }

    /**
     * 盛最多水的容器
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
       int ans = Integer.MIN_VALUE;

       int left = 0;
       int right = height.length - 1;
       while(left < right) {
           if(height[left] <= height[right]) {
               ans = Math.max(ans,height[left] * (right-left));
               left++;
           }else{
               ans = Math.max(ans,height[right] * (right-left));
               right--;
           }
       }
       return ans;
    }

    /**
     * 15. 三数之和
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i< len;i++) {
            int left = i+1;
            int right = len-1;
            int target = -nums[i];
            if(target < 0) {
                break;
            }
            if(i == 0 || nums[i] != nums[i-1]) {
                while(left <right) {
                    if(nums[left] + nums[right] == target) {
                        ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        while(left < right && nums[left] == nums[++left]);
                        while(left < right && nums[right] == nums[--right]);
                    }else if(nums[left] + nums[right] > target) {
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int a = 'a';
        int b = 'A';


    }
}
