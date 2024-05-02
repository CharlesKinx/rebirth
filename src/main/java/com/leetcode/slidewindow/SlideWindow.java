package com.leetcode.slidewindow;

import sun.misc.Queue;

import java.util.*;

/**
 * @author HDU-AIOT-WuHD
 * @date 2024-04-28 9:43
 **/
public class SlideWindow {
    /**
     * 长度最小的子数组
     *
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
        while (right < len) {
            sum += nums[right];
            while (left < right && sum - nums[left] >= target) {
                sum -= nums[left];
                left++;
            }
            if (sum >= target) {
                ans = Math.min(ans, right - left);
            }
            right++;

        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    /**
     * 无重复字符的最长子串
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[130];
        int len = s.length();
        int left = 0;
        int right = 0;
        int ans = Integer.MIN_VALUE;
        while (right < len) {

            while (left < right && arr[s.charAt(right)] != 0) {
                arr[s.charAt(left)] = 0;
                left++;
            }
            arr[s.charAt(right)] = 1;
            ans = Math.max(ans, right - left + 1);
            right++;
        }

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }

    /**
     * 串联所有单词的子串
     *
     * @param s
     * @param words
     * @return
     */
    public static List<List<String>> list;

    public List<Integer> findSubstring(String s, String[] words) {
        int len = s.length();
        Map<String, Integer> hashMap = new HashMap<>();
        for (String s1 : words) {
            hashMap.put(s1, hashMap.getOrDefault(s1, 0) + 1);
        }
        int len1 = words.length;
        int len2 = words[0].length();

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < len2; i++) {
            Map<String, Integer> temp = new HashMap<>();
            for (int j = i; j + len2 <= len; j += len2) {
                String sub = s.substring(j, j + len2);
                temp.put(sub, temp.getOrDefault(sub, 0) + 1);

                if (j >= i + (len1 * len2)) {
                    int indx = j - len1 * len2;
                    String prev = s.substring(indx, indx + len2);

                    if (temp.get(prev) == 1) {
                        temp.remove(prev);
                    } else {
                        temp.put(prev, temp.get(prev) - 1);
                    }

                    if (!hashMap.equals(temp)) {
                        continue;
                    }
                }
                if (!temp.getOrDefault(sub, 0).equals(hashMap.getOrDefault(sub, 0))) {
                    continue;
                }
                if (temp.equals(hashMap)) {
                    ans.add(j - (len1 - 1) * len2);
                }
            }
        }

        return ans;
    }

    public static void backTrace(String[] words, List<String> strings, int[] visited) {
        if (strings.size() == words.length) {
            list.add(new ArrayList<>(strings));
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i] != 0 || (i > 0 && words[i].equals(words[i - 1]) && visited[i - 1] == 0)) {
                continue;
            }
            strings.add(words[i]);
            visited[i] = 1;
            backTrace(words, strings, visited);
            visited[i] = 0;
            strings.remove(strings.size() - 1);
        }

    }

    /**
     * 最小覆盖子串
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        int[] cnt1 = new int[128];
        int[] cnt2 = new int[128];
        int lens = s.length();
        int lent = t.length();

        for (int i = 0; i < lent; i++) {
            cnt1[t.charAt(i)]++;
        }
        int ansLeft = -1;
        int ansRight = lens;
        int left = 0;
        for (int r = 0; r < lens; r++) {
            char c = s.charAt(r);
            if(cnt1[c] == 0) {
                continue;
            }
            cnt2[c]++;
            while(isMatch(cnt1,cnt2)) {
                if(r - left < ansRight- ansLeft) {
                    ansLeft = left;
                    ansRight = r;
                }
                if(cnt2[s.charAt(left)] != 0) {
                    cnt2[s.charAt(left)]--;
                }
                left++;
            }
        }
        return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight + 1);

    }

    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String s2 = "ABC";
        String s = minWindow(s1, s2);
        System.out.println(s);
    }
    public static boolean isMatch(int[] cnt1,int[] cnt2) {

        for(int i = 'A';i<='Z';i++) {
            if(cnt1[i] > cnt2[i]) {
                return false;
            }
        }

        for(int i = 'a';i<='z';i++) {
            if(cnt1[i] > cnt2[i]) {
                return false;
            }
        }

        return true;
    }


}
