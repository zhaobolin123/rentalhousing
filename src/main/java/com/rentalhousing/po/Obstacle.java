package com.rentalhousing.po;

import java.util.Date;

/**
 * @Author: 赵博林
 * @Date:2020/4/14 1:21
 * @Description:
 * @Param：
 * @return ：
 */

//报障表
public class Obstacle {
    private Integer obstacle_id;
    private Integer tenant_id;
    private Integer housingresources_id;
    private String obstacle_detail;
    private Integer obstacle_state;
    private Date obstacle_time;
    private Date obstacle_completiontime;
    private String obstacle_pic;

    public Integer getObstacle_id() {
        return obstacle_id;
    }

    public void setObstacle_id(Integer obstacle_id) {
        this.obstacle_id = obstacle_id;
    }

    public Integer getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(Integer tenant_id) {
        this.tenant_id = tenant_id;
    }

    public Integer getHousingresources_id() {
        return housingresources_id;
    }

    public void setHousingresources_id(Integer housingresources_id) {
        this.housingresources_id = housingresources_id;
    }

    public String getObstacle_detail() {
        return obstacle_detail;
    }

    public void setObstacle_detail(String obstacle_detail) {
        this.obstacle_detail = obstacle_detail;
    }

    public Integer getObstacle_state() {
        return obstacle_state;
    }

    public void setObstacle_state(Integer obstacle_state) {
        this.obstacle_state = obstacle_state;
    }

    public Date getObstacle_time() {
        return obstacle_time;
    }

    public void setObstacle_time(Date obstacle_time) {
        this.obstacle_time = obstacle_time;
    }

    public Date getObstacle_completiontime() {
        return obstacle_completiontime;
    }

    public void setObstacle_completiontime(Date obstacle_completiontime) {
        this.obstacle_completiontime = obstacle_completiontime;
    }

    public String getObstacle_pic() {
        return obstacle_pic;
    }

    public void setObstacle_pic(String obstacle_pic) {
        this.obstacle_pic = obstacle_pic;
    }
}
