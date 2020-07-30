package x.y.z.rabbit.leetcode.two.index;

/**
 * @Author <a href="zhanghui.wj@cai-inc.com">无忌</a>
 * @Date 2020/7/30 12:10 下午 Copyright (c) 2016 政采云有限公司
 */
public class Solution42 {

    public int trap(int[] height) {
        int sum = 0;
        //左边最高柱
        int maxLeft = 0;
        //右边最高柱
        int maxRight = 0;
        //利用left和right指针同时从两头向中间遍历，之所以排除两头的列，是因为每一列都需要跟左右两边的最高列形成碗状结构才能积水
        //两头的列无法形成这种结构，直接排除
        int left = 1;
        int right = height.length - 2;
        for (int i = 1; i < height.length - 1; i++) {
            //从左到右更
            if (height[left - 1] < height[right + 1]) {
                maxLeft = Math.max(maxLeft, height[left - 1]);
                int min = maxLeft;
                if (min > height[left]) {
                    sum = sum + (min - height[left]);
                }
                left++;
                //从右到左更
            } else {
                maxRight = Math.max(maxRight, height[right + 1]);
                int min = maxRight;
                if (min > height[right]) {
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        int[] ints = {2, 0, 2};
        System.out.println(new Solution42().trap(ints));
    }
}
