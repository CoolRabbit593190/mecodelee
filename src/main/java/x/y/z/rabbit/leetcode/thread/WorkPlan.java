package x.y.z.rabbit.leetcode.thread;

import java.io.File;
import java.io.IOException;

/**
 * 排班计划
 *
 * @Author <a href="zhanghui.wj@cai-inc.com">无忌</a>
 * @Date 2020/2/27 3:23 下午 Copyright (c) 2016 政采云有限公司
 */
public class WorkPlan {

    private static final int MORNING_WORK_TIME = 6;
    private static final int AFTERNOON_WORK_TIME = 12;
    private static final int NIGHT_WORK_TIME = 19;

    /**
     * 打卡记录
     */
    private File workRecord;

    /**
     * 上岗时间点
     */
    private volatile int workTime;

    private Worker workerAtMorning;

    private Worker workerAtAfternoon;

    private Worker workerAtNight;

    public WorkPlan() {

    }

    public WorkPlan(File workRecord, Worker workerAtMorning, Worker workerAtAfternoon, Worker workerAtNight) {
        this.workRecord = workRecord;
        this.workerAtNight = workerAtNight;
        this.workerAtAfternoon = workerAtAfternoon;
        this.workerAtMorning = workerAtMorning;
    }

    public void workAtMorning() {
        try {
            workerAtMorning.punchIn(workRecord);
        } catch (IOException e) {
            e.printStackTrace();
        }
        workTime = AFTERNOON_WORK_TIME;
    }

    public void workAtAfternoon() {
        while (AFTERNOON_WORK_TIME != workTime) {
        }
        try {
            workerAtAfternoon.punchIn(workRecord);
        } catch (IOException e) {
            e.printStackTrace();
        }
        workTime = NIGHT_WORK_TIME;
    }

    public void workAtNight() {
        while (NIGHT_WORK_TIME != workTime) {

        }
        try {
            workerAtNight.punchIn(workRecord);
        } catch (IOException e) {
            e.printStackTrace();
        }
        workTime = MORNING_WORK_TIME;
    }


}
