package x.y.z.rabbit.playground;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Author <a href="zhanghui.wj@cai-inc.com">无忌</a>
 * @Date 2020/4/3 5:58 下午 Copyright (c) 2016 政采云有限公司
 */
public class Play4 {

    public static void main(String[] args) {
//        new Random(47).ints(20, 0, 4000).forEach(System.out::println);

        long sourceDuration = System.nanoTime();
        System.out.println(sourceDuration);
        System.out.println(MILLISECONDS.convert(sourceDuration, NANOSECONDS));
    }

}
