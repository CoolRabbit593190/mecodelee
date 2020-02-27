package x.y.z.rabbit.leetcode.thread;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author <a href="zhanghui.wj@cai-inc.com">无忌</a>
 * @Date 2020/2/27 12:04 下午 Copyright (c) 2016 政采云有限公司
 */
public class Company {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("工作计划");
        int workDay = sc.nextInt();
        System.out.println("工作天数");
        int workDay = sc.nextInt();
        System.out.println("签到文件路径:");
        String path = sc.nextLine();
        File file = new File(path);
        Worker designer = new Worker(file, "1");
        Worker engineer = new Worker(file, "2");
        Worker test = new Worker(file, "3");
        WorkPlan workPlanA = new WorkPlan(file, designer, engineer, test);
        WorkPlan workPlanB = new WorkPlan(file, designer, engineer, test);
        WorkPlan workPlanC = new WorkPlan(file, designer, engineer, test);
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < workDay; i++) {
            pool.execute(() -> workPlanA.workAtMorning());
            pool.execute(() -> workPlanA.workAtAfternoon());
            pool.execute(() -> workPlanA.workAtNight());
        }


    }


}
