package com.rentalhousing.po;

import java.util.Date;

/**
 * @Author: 赵博林
 * @Date:2020/4/14 1:20
 * @Description:
 * @Param：
 * @return ：
 */

//申请表
public class Apply {
    private Integer apply_id;
    private Integer tenant_id;
    private Integer housingresources_id;
    private Integer apply_type;
    private Date apply_time;
    private String apply_remake;
    private String apply_liaison;
    private String apply_contact;
    private Integer apply_state;

    public Integer getApply_id() {
        return apply_id;
    }

    public void setApply_id(Integer apply_id) {
        this.apply_id = apply_id;
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

    public Integer getApply_type() {
        return apply_type;
    }

    public void setApply_type(Integer apply_type) {
        this.apply_type = apply_type;
    }

    public Date getApply_time() {
        return apply_time;
    }

    public void setApply_time(Date apply_time) {
        this.apply_time = apply_time;
    }

    public String getApply_remake() {
        return apply_remake;
    }

    public void setApply_remake(String apply_remake) {
        this.apply_remake = apply_remake;
    }

    public String getApply_liaison() {
        return apply_liaison;
    }

    public void setApply_liaison(String apply_liaison) {
        this.apply_liaison = apply_liaison;
    }

    public String getApply_contact() {
        return apply_contact;
    }

    public void setApply_contact(String apply_contact) {
        this.apply_contact = apply_contact;
    }

    public Integer getApply_state() {
        return apply_state;
    }

    public void setApply_state(Integer apply_state) {
        this.apply_state = apply_state;
    }
}
