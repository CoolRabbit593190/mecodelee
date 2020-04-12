package x.y.z.rabbit.playground;

/**
 * @Author <a href="zhanghui.wj@cai-inc.com">无忌</a>
 * @Date 2020/4/1 3:54 下午 Copyright (c) 2016 政采云有限公司
 */
public class Play3 {


    public synchronized void lock() {
        System.out.println("locking");
    }

    public synchronized void unlock() {
        System.out.println("unlocking");
    }


    public static void main(String[] args) {
        Play3 play3 = new Play3();
        play3.lock();
        play3.unlock();
    }
}
