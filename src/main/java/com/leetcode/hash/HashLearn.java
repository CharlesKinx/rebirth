package com.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

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

    }
}
