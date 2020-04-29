package com.rentalhousing.po;

import java.util.Date;

/**
 * @Author: 赵博林
 * @Date:2020/4/14 1:21
 * @Description:
 * @Param：
 * @return ：
 */

//合同表
public class Contract {
    private Integer contract_id;
    private Integer tenant_id;
    private Integer landlord_id;
    private Integer housingresources_id;
    private String lease_type;
    private String contract_price;
    private Date contract_begintime;
    private Date contract_endtime;

    public Integer getContract_id() {
        return contract_id;
    }

    public void setContract_id(Integer contract_id) {
        this.contract_id = contract_id;
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

    public Integer getHousingresources_id() {
        return housingresources_id;
    }

    public void setHousingresources_id(Integer housingresources_id) {
        this.housingresources_id = housingresources_id;
    }

    public String getLease_type() {
        return lease_type;
    }

    public void setLease_type(String lease_type) {
        this.lease_type = lease_type;
    }

    public String getContract_price() {
        return contract_price;
    }

    public void setContract_price(String contract_price) {
        this.contract_price = contract_price;
    }

    public Date getContract_begintime() {
        return contract_begintime;
    }

    public void setContract_begintime(Date contract_begintime) {
        this.contract_begintime = contract_begintime;
    }

    public Date getContract_endtime() {
        return contract_endtime;
    }

    public void setContract_endtime(Date contract_endtime) {
        this.contract_endtime = contract_endtime;
    }
}
