package com.leetcode.hash;

import java.util.*;

/**
 * @author HDU-AIOT-WuHD
 * @date 2024-05-07 9:43
 **/
public class HashLearn {

    /**
     * 赎金信
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] ls = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            ls[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            ls[ransomNote.charAt(i) - 'a']--;

            if (ls[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 同构字符串
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {

        int[] map = new int[128];
        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if(map[s.charAt(i)] == 0) {
                map[s.charAt(i)] = t.charAt(i);
                map[t.charAt(i)] = s.charAt(i);
            }else{
                if(map[s.charAt(i)] != t.charAt(i) || map[t.charAt(i)] != s.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 单词规律
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {

        String[] strings = s.split(" ");
        if(pattern.length() != strings.length) {
            return false;
        }
        HashMap<Character,String> hashMap1 = new HashMap<>();
        HashMap<String,Character> hashMap2 = new HashMap<>();

        for(int i = 0;i<strings.length;i++) {
            if(!hashMap1.containsKey(pattern.charAt(i))) {
                hashMap1.put(pattern.charAt(i),strings[i]);
            }else{
                if(!hashMap1.get(pattern.charAt(i)).equals(strings[i])) {
                    return false;
                }
            }

            if(!hashMap2.containsKey(strings[i])) {
                hashMap2.put(strings[i],pattern.charAt(i));
            }else{
                if(hashMap2.get(strings[i]) != pattern.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }


    /**
     * 有效的字母异位词
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        if(s.length() != t.length()) {
            return false;
        }

        for(int i = 0;i<s.length();i++) {
            arr[s.charAt(i)-'a']++;
        }

        for(int i = 0;i<s.length();i++) {
            arr[t.charAt(i)-'a']++;

            if(arr[t.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 字母异位词分组
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hashMap = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0;i<strs.length;i++) {
            char[] t = strs[i].toCharArray();
            Arrays.sort(t);
            String temp = new String(t);

            List<String> list = hashMap.getOrDefault(temp,new ArrayList<>());
            list.add(strs[i]);
            hashMap.put(temp,list);
        }

        return new ArrayList<>(hashMap.values());
    }


    /**
     * 两数之和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int[] ans = new int[2];
        for(int i = 0;i< nums.length;i++) {
            if(hashMap.containsKey(target-nums[i])) {
                ans[0] = hashMap.get(target-nums[i]);
                ans[1] = i;
                return ans;
            }else{
                hashMap.put(nums[i],i);
            }
        }
        return ans;
    }

    /**
     * 存在重复元素 II
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for(int i = 0;i< nums.length;i++) {

            if(hashMap.containsKey(nums[i]) && Math.abs(hashMap.get(nums[i]) - i) <= k ) {
                return true;
            }
            hashMap.put(nums[i],i);

        }
        return false;
    }


    /**
     * 快乐数
     * @param n
     * @return
     */

    public int getSum(int n) {
        int sum = 0;

        while(n > 0) {
            int t = n % 10;
            n = n/10;
            sum += t*t;
        }
        return sum;
    }
    public boolean isHappy(int n) {

        HashSet<Integer> hashSet = new HashSet<>();

        while(n != 1 && !hashSet.contains(n)) {
            hashSet.add(n);
            n = getSum(n);
        }
        return n==1;
    }

    /**
     * 最长连续序列
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int ans = 0;
        for(int i = 0;i< nums.length;i++) {
            hashSet.add(nums[i]);
        }

        for(int i = 0;i<nums.length;i++) {
            int num = nums[i];

            if(!hashSet.contains(num-1)) {
                int t = 0;

                while(hashSet.contains(num)) {
                    t++;
                    num += 1;
                }

                ans = Math.max(ans,t);
            }
        }

        return ans;
    }
}




































