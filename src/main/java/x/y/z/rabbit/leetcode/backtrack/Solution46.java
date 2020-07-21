package x.y.z.rabbit.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @Author <a href="zhanghui.wj@cai-inc.com">无忌</a>
 * @Date 2020/6/13 12:56 下午 Copyright (c) 2016 政采云有限公司
 */
public class Solution46 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
//        Vector<Integer> tracks = new Vector<>(nums.length);
//        backtrack(nums, tracks);
//        return result;
        List<List<Integer>> res = new LinkedList();

        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int num : nums)
            output.add(num);

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;

    }

    private void backtrack(int[] nums, Vector<Integer> tracks) {
        for (int num : nums) {
            if (tracks.size() == nums.length) {
                result.add(new ArrayList<>(tracks));
                break;
            }
            if (tracks.contains(num)) {
                continue;
            }
            tracks.add(num);
            backtrack(nums, tracks);
            tracks.removeElementAt(tracks.size() - 1);
        }
    }

    public void backtrack(int n,
        ArrayList<Integer> output,
        List<List<Integer>> res,
        int first) {
        // 所有数都填完了
        if (first == n)
            res.add(new ArrayList<>(output));
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 5};
        List<List<Integer>> result = new Solution46().permute(array);
        System.out.println(result);
        System.out.println(result.size());
    }
}
