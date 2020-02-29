package x.y.z.rabbit.leetcode.thread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 工人
 *
 * @Author <a href="zhanghui.wj@cai-inc.com">无忌</a>
 * @Date 2020/2/27 9:45 上午 Copyright (c) 2016 政采云有限公司
 */
public class Worker {

    /**
     * 工号
     */
    private String staffId;

    /**
     * 打卡记录
     */
    private File workRecord;


    public Worker(File workRecord, String staffId) {
        this.workRecord = workRecord;
        this.staffId = staffId;
    }

    public Worker() {

    }

    public String getStaffId() {
        return staffId;
    }

    /**
     * 上班打卡
     * @param workRecord 打卡记录
     * @throws IOException
     */
    public void punchIn(File workRecord) throws IOException {
        System.out.println("员工---" + staffId + "---打卡");
        FileOutputStream fos = new FileOutputStream(workRecord, true);
        fos.write(staffId.getBytes());
        fos.close();
    }
}
