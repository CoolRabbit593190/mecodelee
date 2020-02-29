package x.y.z.rabbit.leetcode.thread;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 排班测试类
 *
 * @Author <a href="zhanghui.wj@cai-inc.com">无忌</a>
 * @Date 2020/2/27 12:04 下午 Copyright (c) 2016 政采云有限公司
 */
public class Company {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("排班计划:");
        String planCode = sc.nextLine();
        System.out.println("排班天数:");
        String workDay = sc.nextLine();
        System.out.println("排班表文件存放路径:");
        String path = sc.nextLine();
        File workPlanSheet = new File(path);
        WorkPlan workPlan = WorkPlanFactory.producePlan(planCode, Integer.parseInt(workDay), workPlanSheet, "1", "2",
            "3");
        writePlan(workPlan);
    }

    private static void writePlan(WorkPlan workPlan) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(() -> {
            workPlan.planWorkAtMorning();
        });
        service.execute(() -> {
            workPlan.planWorkAtAfternoon();
        });
        service.execute(() -> {
            workPlan.planWorkAtNight();
        });
//        new Thread(() -> workPlan.planWorkAtMorning()).start();
//        new Thread(() -> workPlan.planWorkAtAfternoon()).start();
//        new Thread(() -> workPlan.planWorkAtNight()).start();
        service.shutdown();
//        for (; ; ) {
//            service.shutdown();
//            if (service.isShutdown()) {
//                break;
//            }
//        }
    }
}


