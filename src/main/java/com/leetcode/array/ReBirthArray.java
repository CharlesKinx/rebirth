package com.leetcode.array;

/**
 * @author HDU-AIOT-WuHD
 * @date 2024-04-02 10:52
 **/

import java.util.*;

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
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[low] = nums[i];
                low++;
            }
        }
        return low;
    }

    /**
     * 80. 删除有序数组中的重复项 II
     *
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (ans < 2 || nums[ans - 2] != nums[i]) {
                nums[ans] = nums[i];
                ans++;
            }
        }
        return ans;
    }

    /**
     * 买卖股票的最佳时机
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;

        int[] maxV = new int[len];
        maxV[len - 1] = prices[len - 1];

        for (int i = len - 2; i >= 0; i--) {
            maxV[i] = Math.max(prices[i], maxV[i + 1]);
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans, maxV[i] - prices[i]);
        }

        return ans;
    }


    public int maxProfit1(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 0; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

    /**
     * 跳跃游戏
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {

        int len = nums.length;
        int maxP = 0;
        for (int i = 0; i < len && i <= maxP; i++) {
            if (i + nums[i] >= len - 1) {
                return true;
            }
            if (i + nums[i] > maxP) {
                maxP = i + nums[i];
            }
        }
        return false;
    }

    /**
     * 跳跃游戏 II
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {

        int ans = 0;
        int len = nums.length;
        int maxP = 0;
        int end = 0;
        for (int i = 0; i < len - 1; i++) {
            maxP = Math.max(maxP, i + nums[i]);

            if (i == end) {
                end = maxP;
                ans++;
            }
        }
        return ans;
    }

    /**
     * H 指数
     *
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        int len = citations.length;
        Arrays.sort(citations);

        int ans = 0;
        int temp = 0;
        for (int i = len - 1; i >= 0; i++) {
            if (citations[i] > temp) {
                temp++;
            } else {
                ans = Math.max(ans, temp);
                temp = 0;
            }
        }
        return ans;
    }


    /**
     * O(1) 时间插入、删除和获取随机元素
     */
    class RandomizedSet {


        private Set<Integer> hashSet;

        public RandomizedSet() {
            hashSet = new HashSet<>();
        }

        public boolean insert(int val) {
            if (hashSet.contains(val)) {
                return false;
            }
            hashSet.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (hashSet.contains(val)) {
                hashSet.remove(val);
                return true;
            } else {
                return false;
            }
        }

        public int getRandom() {
            int len = hashSet.size();
            Random random = new Random();
            int index = random.nextInt(len);
            int in = 0;
            int ans = 0;
            for (Integer num : hashSet) {
                if (in == index) {
                    num = ans;
                    break;
                }
                in++;
            }
            return ans;
        }
    }

    /**
     * 除自身以外数组的乘积
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];

        left[0] = nums[0];
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i];
        }

        int right = 1;
        for (int i = len - 1; i > 0; i--) {
            left[i] = left[i - 1] * right;
            right *= nums[i];
        }

        left[0] = right;
        return left;
    }


    /**
     * 加油站
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int len = gas.length;

        int minSum = Integer.MAX_VALUE;
        int minIndex = 0;
        int gasSum = 0;
        for (int i = 0; i < len; i++) {
            gasSum += gas[i] - cost[i];

            if (gasSum < minSum) {
                minSum = gasSum;
                minIndex = i;
            }
        }

        if (minSum > 0) {
            return 0;
        }

        return gasSum < 0 ? -1 : (minIndex + 1) % len;

    }

    /**
     * 135. 分发糖果
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int len = ratings.length;
        int ans = 1;
        int inc = 1;
        int des = 1;
        int pre = 1;
        for (int i = 1; i < len; i++) {
            if(ratings[i] >= ratings[i-1]) {
                pre = ratings[i] == ratings[i-1] ? 1 : pre+1;
                ans += pre;
                inc = pre;
                des = 0;
            }else{
                des++;
                if(des == inc) {
                    des++;
                }
                ans += des;
                pre = 1;
            }
        }
        return ans;
    }

    /**
     * 接雨水
     * @param height
     * @return
     */
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int len = height.length;
        int ans = 0;

        for(int i = 0;i<len;i++) {

            while(!stack.empty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if(stack.empty()){
                    break;
                }

                int left = stack.peek();
                int k = i - left - 1;
                int h = Math.min(height[left],height[i]) - height[top];

                ans += k * h;
            }

            stack.push(i);
        }

        return ans;
    }

    /**
     * 罗马数字转整数
     * @param s
     * @return
     */
    public int romanToInt(String s) {

        Map<Character,Integer> hashmap = new HashMap<>();
        hashmap.put('I',1);
        hashmap.put('V',5);
        hashmap.put('X',10);
        hashmap.put('L',50);
        hashmap.put('C',100);
        hashmap.put('D',500);
        hashmap.put('M',1000);

        int ans = 0;
        int len = s.length();
        int maxV = 0;

        for(int i = len-1; i>=0;i--) {
            if(maxV <= hashmap.get(s.charAt(i))) {
                ans += hashmap.get(s.charAt(i));
                maxV = hashmap.get(s.charAt(i));
            }else{
                ans -= hashmap.get(s.charAt(i));
            }
        }

        return ans;
    }

    /**
     * 整数转罗马数字
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        int[] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0;i<value.length;i++) {
            int v = value[i];
            String s = symbol[i];

            while(num >= v) {
                num -= v;
                stringBuffer.append(s);
            }

            if(num == 0) {
                break;
            }
        }
        return  stringBuffer.toString();
    }

    /**
     * 最长公共前缀
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder("");

        int len = strs.length;
        if(len == 0) {
            return "";
        }
        int index = 0;
        for(int i = 0;i<strs[0].length();i++) {
            char c = strs[0].charAt(i);
            boolean isValid = true;
            for(int j = 1; j<len;j++) {
                if(strs[j].length() > i && strs[j].charAt(i) == c) {
                    continue;
                }else{
                    isValid = false;
                    break;
                }
            }
            if(isValid) {
                stringBuilder.append(c);
            }else{
                break;
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Z 字形变换
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {

        if(numRows < 2) {
            return s;
        }
        List<StringBuilder> stringBuilders = new ArrayList<>();
        for(int i = 0;i<numRows;i++) {
            stringBuilders.add(new StringBuilder());
        }

        int index = 0;
        int flag = -1;
        for(char c : s.toCharArray()) {
            stringBuilders.get(index).append(c);
            if(index == 0 || index == numRows - 1) {
                flag = -flag;
            }
            index += flag;
        }

        StringBuilder ans = new StringBuilder();
        for(int i = 0;i<numRows;i++) {
            ans.append(stringBuilders.get(i));
        }
        return ans.toString();
    }


    /**
     *  找出字符串中第一个匹配项的下标
     * @param haystack
     * @param needle
     * @return
     */

    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if(len2 > len1) {
            return -1;
        }

        int ans = -1;
        int index1 = 0;
        int index2 = 0;

        for(int i =0; i< index1;i++) {
            int t = i;
            for(int j = 0;j < index2;j++) {
                if(haystack.charAt(t) == needle.charAt(j)) {
                    t++;
                }
            }
            if(t - i == index2) {
                ans = i;
                break;
            }
        }
        return ans;
    }


    /**
     * 文本左右对齐
     * @param words
     * @param maxWidth
     * @return
     */
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> ans = new ArrayList<>();
        int index = 0;
        int len = 0;
        List<StringBuilder> stringBuilders = new ArrayList<>();
        for(int i = 0;i< words.length;i++) {
            if(len + words[i].length() < maxWidth) {
                len += words[i].length();
                stringBuilders.add(new StringBuilder(words[i]));
                continue;
            }else{
                int intv = i - index;
                int t = maxWidth - len;
                if(intv == 1) {
                    while(t > 0) {
                        stringBuilders.get(0).append(" ");
                        t--;
                    }
                }else{
                    int temp = 0;
                    while(temp < t) {
                        stringBuilders.get(temp % (intv-1)).append(" ");
                        temp++;
                    }
                }

                StringBuilder s = new StringBuilder();
                for(StringBuilder st : stringBuilders) {
                    s.append(st);
                }
                ans.add(s.toString());
                index = i;
                len = 0;
                stringBuilders = new ArrayList<>();
                i--;
            }
        }
        StringBuilder s = new StringBuilder();
        for(int i = 0;i<stringBuilders.size() - 1;i++) {
            s.append(stringBuilders.get(i));
            s.append(" ");
        }
        s.append(stringBuilders.get(stringBuilders.size() - 1));
        ans.add(s.toString());
        return ans;
    }
}
