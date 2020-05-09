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
    private String housingresources_renttype;
    private String contract_price;
    private String contract_begintime;
    private String contract_endtime;

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

    public String getHousingresources_renttype() {
        return housingresources_renttype;
    }

    public void setHousingresources_renttype(String housingresources_renttype) {
        this.housingresources_renttype = housingresources_renttype;
    }

    public String getContract_price() {
        return contract_price;
    }

    public void setContract_price(String contract_price) {
        this.contract_price = contract_price;
    }

    public String getContract_begintime() {
        return contract_begintime;
    }

    public void setContract_begintime(String contract_begintime) {
        this.contract_begintime = contract_begintime;
    }

    public String getContract_endtime() {
        return contract_endtime;
    }

    public void setContract_endtime(String contract_endtime) {
        this.contract_endtime = contract_endtime;
    }
}
