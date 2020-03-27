package x.y.z.rabbit.playground;

/**
 * @Author <a href="zhanghui.wj@cai-inc.com">无忌</a>
 * @Date 2020/3/26 2:26 下午 Copyright (c) 2016 政采云有限公司
 */
public class Play1 {

    public static void main(String[] args) {
        synchronized (Play1.class) {
            System.out.println("cool!");
        }
    }

}
