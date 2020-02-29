package x.y.z.rabbit.leetcode.thread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * 排班计划
 *
 * 排班顺序为：早，中，晚班
 */
public class WorkPlan {

    private static final int MORNING_WORK = 1;
    private static final int AFTERNOON_WORK = 2;
    private static final int NIGHT_WORK = 3;

    private CountDownLatch second = new CountDownLatch(1);
    private CountDownLatch third = new CountDownLatch(1);

    /**
     * 用于控制多线程排班的有序性
     */
    private volatile int workFlag = 1;

    /**
     * 排班表
     */
    private File workPlanSheet;


    /**
     * 早班工人工号
     */
    private String workerIdAtMorning;

    /**
     * 午班工人工号
     */
    private String workerIdAtAfternoon;

    /**
     * 晚班工人工号
     */
    private String workerIdAtNight;

    /**
     * 排班天数
     */
    private int workDay;

    public WorkPlan() {

    }

    public WorkPlan(File workPlanSheet, int workDay, String workerIdAtMorning, String workerIdAtAfternoon,
        String workerIdAtNight) {
        this.workDay = workDay;
        this.workPlanSheet = workPlanSheet;
        this.workerIdAtNight = workerIdAtNight;
        this.workerIdAtAfternoon = workerIdAtAfternoon;
        this.workerIdAtMorning = workerIdAtMorning;
    }

    /**
     * 排早班
     */
    public void planWorkAtMorning() {
        for (int i = 0; i < workDay; i++) {
            while (MORNING_WORK != workFlag) {
            }
            writeDown(workerIdAtMorning);
            workFlag = AFTERNOON_WORK;
            System.out.println("current thread:" + Thread.currentThread().getName() + " 早班人员：" + workerIdAtMorning);
//            second.countDown();
        }

    }

    /**
     * 排早班
     */
    public void planWorkAtAfternoon() {
        for (int i = 0; i < workDay; i++) {
            while (AFTERNOON_WORK != workFlag) {
            }
//            try {
//                second.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            writeDown(workerIdAtAfternoon);
            workFlag = NIGHT_WORK;
            System.out.println("current thread:" + Thread.currentThread().getName() + " 午班人员：" + workerIdAtAfternoon);
//            third.countDown();
        }

    }

    /**
     * 排晚班
     */
    public void planWorkAtNight() {
        for (int i = 0; i < workDay; i++) {
            while (NIGHT_WORK != workFlag) {
            }
//            try {
//                third.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            writeDown(workerIdAtNight);
            workFlag = MORNING_WORK;
            System.out.println("current thread:" + Thread.currentThread().getName() + " 晚班人员：" + workerIdAtNight);
        }

    }

    /**
     * 将工人工号写入排班表
     */
    private void writeDown(String staffId) {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(workPlanSheet, true);
            fos.write(staffId.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
