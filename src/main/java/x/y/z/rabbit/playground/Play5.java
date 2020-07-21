package x.y.z.rabbit.playground;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author <a href="zhanghui.wj@cai-inc.com">无忌</a>
 * @Date 2020/7/12 4:03 下午 Copyright (c) 2016 政采云有限公司
 */
public class Play5 {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            result.add(count);
        }
        return result;
    }

    public static void main(String[] args) {
        TimeInterval timer = DateUtil.timer();
        System.out.println(new Play5().countSmaller(new int[]{5, 2, 6, 1}).toString());
        System.out.println(timer.intervalRestart());
    }
}
