package x.y.z.rabbit.leetcode.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author <a href="zhanghui.wj@cai-inc.com">无忌</a>
 * @Date 2020/2/20 8:54 下午 Copyright (c) 2016 政采云有限公司
 */
public class Solution1 {

    public static int findRepeatNumber(int[] nums) {
        Set<Integer> filterSet = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (!filterSet.add(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int[] nums2 = {1, 2, 3, 0, 5};
        List<Integer> filterList = new ArrayList();
        List<Integer> filterList2 = new ArrayList();
        for (int num : nums) {
            filterList.add(num);
        }
        for (int i : nums2) {
            filterList2.add(i);
        }
        filterList.removeAll(filterList2);
        System.out.println(filterList.get(0));
    }
}
