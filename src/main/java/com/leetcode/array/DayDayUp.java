package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HDU-AIOT-WuHD
 * @date 2024-04-04 13:19
 **/
public class DayDayUp {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {

        int[][] path = new int[n][n];

        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                path[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            path[to][from] = 1;
        }

        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                for(int k = 0;k<n;k++) {
                    if(path[i][j] + path[j][k] < path[i][k]) {
                        path[i][k] = 1;
                    }
                }
            }
        }


        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0;i<n;i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0;j<n;j++) {
                if(path[i][j] != Integer.MAX_VALUE) {
                    list.add(j);
                }
            }
            ans.add(list);
        }

        return ans;
    }
}
