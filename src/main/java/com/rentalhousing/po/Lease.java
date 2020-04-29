package com.rentalhousing.po;

import java.util.Date;

/**
 * @Author: 赵博林
 * @Date:2020/4/14 1:20
 * @Description:
 * @Param：
 * @return ：
 */

//租赁表
public class Lease {
    private Integer lease_id;
    private Integer tenant_id;
    private Integer landlord_id;
    private Date lease_time;
    private String lease_type;

    public Integer getLease_id() {
        return lease_id;
    }

    public void setLease_id(Integer lease_id) {
        this.lease_id = lease_id;
    }

    public Integer getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(Integer tenant_id) {
        this.tenant_id = tenant_id;
    }

    public Integer getLandlord_id() {
        return landlord_id;
    }

    public void setLandlord_id(Integer landlord_id) {
        this.landlord_id = landlord_id;
    }

    public Date getLease_time() {
        return lease_time;
    }

    public void setLease_time(Date lease_time) {
        this.lease_time = lease_time;
    }

    public String getLease_type() {
        return lease_type;
    }

    public void setLease_type(String lease_type) {
        this.lease_type = lease_type;
    }
}
