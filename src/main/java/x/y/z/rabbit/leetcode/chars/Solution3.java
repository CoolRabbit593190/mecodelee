package x.y.z.rabbit.leetcode.chars;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

/**
 * @formatter:off
 * //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * //
 * // 示例 1:
 * //
 * // 输入: "abcabcbb"
 * //输出: 3
 * //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * //
 * //
 * // 示例 2:
 * //
 * // 输入: "bbbbb"
 * //输出: 1
 * //解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * //
 * //
 * // 示例 3:
 * //
 * // 输入: "pwwkew"
 * //输出: 3
 * //解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * //     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * //
 * // Related Topics 哈希表 双指针 字符串 Sliding Windo
 *
 * @Author <a href="zhanghui.wj@cai-inc.com">无忌</a>
 * @Date 2020/6/3 9:26 下午 Copyright (c) 2016 政采云有限公司
 *
 * int left = 0, right = 0;
 *
 * while (right < s.size()) {`
 *     // 增大窗口
 *     window.add(s[right]);
 *     right++;
 *
 *     while (window needs shrink) {
 *         // 缩小窗口
 *         window.remove(s[left]);
 *         left++;
 *     }
 * }
 *
 *
 * void slidingWindow(string s, string t) {
 *     unordered_map<char, int> need, window;
 *     for (char c : t) need[c]++;
 *
 *     int left = 0, right = 0;
 *     int valid = 0;
 *     while (right < s.size()) {
 *         // c 是将移入窗口的字符
 *         char c = s[right];
 *         // 右移窗口
 *         right++;
 *         // 进行窗口内数据的一系列更新
 *         ...
 *
 *         // debug 输出的位置
 *         printf("window: [%d, %d)\n", left, right);
 *
 *
 *         // 判断左侧窗口是否要收缩
 *         while (window needs shrink) {
 *             // d 是将移出窗口的字符
 *             char d = s[left];
 *             // 左移窗口
 *             left++;
 *             // 进行窗口内数据的一系列更新
 *             ...
 *         }
 *     }
 * }
 *
 *@formatter:on
 */
public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int max = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < length; end++) {
            char element = s.charAt(end);
            if (map.containsKey(element)) {
                //end游标的字符可能与前一个窗口中的字符相同，所以这里需做max处理
                start = Math.max(map.get(element) + 1, start); //map.get()的地方进行+1操作
            }
            max = Math.max(max, end - start + 1);
            map.put(element, end);
        }
        return max;
    }

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        for (int i = 0; i < 10; i++) {
            semaphore.acquire();
            System.out.println(i);
            semaphore.release();
        }
    }

}
