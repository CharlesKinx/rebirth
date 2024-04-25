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
    public static void main(String[] args) {
        int a = 'a';
        int b = 'A';


    }
}
