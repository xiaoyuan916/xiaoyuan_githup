package com.sgcc.pda.jszp.bean;


/**
 * 物流出发列表请求实体类
 */
public class TaskItemRequestEntity extends BaseRequestEntity {

    private String taskNo;//任务编号
    private String  dpName;//途径直配点
    private String autoBrandNo;//车牌号
    private String staffName;//司机姓名
    private int pageNo;//页码
    private int pageSize;//页面尺寸

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public String getDpName() {
        return dpName;
    }

    public void setDpName(String dpName) {
        this.dpName = dpName;
    }

    public String getAutoBrandNo() {
        return autoBrandNo;
    }

    public void setAutoBrandNo(String autoBrandNo) {
        this.autoBrandNo = autoBrandNo;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
