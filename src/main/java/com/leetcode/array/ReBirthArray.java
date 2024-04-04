package com.leetcode.array;

/**
 * @author HDU-AIOT-WuHD
 * @date 2024-04-02 10:52
 **/

/**
 * 面试经典100题之数组
 */
public class ReBirthArray {


    /**
     * 合并两个有序数组
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int tail = n + m - 1;

        while (index2 >= 0 || index1 >= 0) {
            int cur = 0;
            if (index1 == -1) {
                cur = nums2[index2];
                index2--;
            } else if (index2 == -1) {
                cur = nums1[index1];
                index1--;
            } else if (nums1[index1] >= nums2[index2]) {
                cur = nums1[index1];
                index1--;
            } else {
                cur = nums2[index2];
                index2--;
            }

            nums1[tail] = cur;
            tail--;
        }
    }

    /**
     * 移除元素
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int right = nums.length - 1;
        int left = 0;

        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    /**
     * 删除有序数组中的重复项
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int len = nums.length;

        int low = 1;
        for(int i = 1;i<len;i++) {
            if(nums[i] != nums[i-1]) {
                nums[low] = nums[i];
                low++;
            }
        }
        return low;
    }

    /**
     * 80. 删除有序数组中的重复项 II
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for(int i = 0;i<len;i++) {
            if(ans < 2 || nums[ans - 2] != nums[i]) {
                nums[ans] = nums[i];
                ans++;
            }
        }
        return ans;
    }

}
