package x.y.z.rabbit.leetcode.two.index;

/**
 * @Author <a href="zhanghui.wj@cai-inc.com">无忌</a>
 * @Date 2020/7/20 10:14 下午 Copyright (c) 2016 政采云有限公司
 */
public class Solution167 {

    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0, index2 = numbers.length - 1;
        while (index1 < index2) {
            if (target == numbers[index1] + numbers[index2]) {
                return new int[]{index1 + 1, index2 + 1};
            }
            if (target > numbers[index1] + numbers[index2]) {
                index1++;
                continue;
            }
            if (target < numbers[index1] + numbers[index2]) {
                index2--;
            }
        }
        return new int[]{-1, -1};
    }
}
