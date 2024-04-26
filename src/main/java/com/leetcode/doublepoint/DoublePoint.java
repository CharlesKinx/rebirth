package com.leetcode.doublepoint;

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

    public static void main(String[] args) {
        int a = 'a';
        int b = 'A';


    }
}
