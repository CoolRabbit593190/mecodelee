package x.y.z.rabbit.leetcode.thread;

import java.io.File;
import java.util.Objects;

/**
 * 排班计划工厂
 *
 * 现有工人工号 1，2，3
 *
 * A计划排班 -- 早班：1 午班：2 晚班：3
 * B计划排班 -- 早班：3 午班：2 晚班：1
 * C计划排班 -- 早班：3 午班：1 晚班：2
 *
 * @Author <a href="zhanghui.wj@cai-inc.com">无忌</a>
 * @Date 2020/2/27 7:44 下午 Copyright (c) 2016 政采云有限公司
 */
public class WorkPlanFactory {

    public enum PlanEnum {
        PLAN_A("A", "排班计划A"),
        PLAN_B("B", "排班计划B"),
        PLAN_C("C", "排班计划C");

        private PlanEnum(String code, String name) {
            this.code = code;
            this.name = name;
        }

        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static PlanEnum fromCode(String Code) {
            for (PlanEnum planEnum : PlanEnum.values()) {
                if (Objects.equals(Code, planEnum.getCode())) {
                    return planEnum;
                }
            }
            return null;
        }


    }

    public static WorkPlan producePlan(String planCode, int workDay, File workPlanSheet,
        String workerId1, String workerId2, String workerId3) {
        switch (PlanEnum.fromCode(planCode)) {
            case PLAN_A:
                return new WorkPlan(workPlanSheet, workDay, workerId1, workerId2, workerId3);
            case PLAN_B:
                return new WorkPlan(workPlanSheet, workDay, workerId3, workerId2, workerId1);
            case PLAN_C:
                return new WorkPlan(workPlanSheet, workDay, workerId3, workerId1, workerId2);
            default:
                return null;
        }
    }
}

