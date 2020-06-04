package com.rentalhousing.po;

import java.math.BigInteger;
import java.util.Date;

/**
 * @Author: 赵博林
 * @Date:2020/4/14 1:21
 * @Description:
 * @Param：
 * @return ：
 */

//租金表
public class Rent {
    private Integer rent_id;
    private Integer landlord_id;
    private Integer tenant_id;
    private String rent_price;
    private Long rent_time;
    private Long rent_endtime;
    private Integer rent_type;

    public Integer getRent_id() {
        return rent_id;
    }

    public void setRent_id(Integer rent_id) {
        this.rent_id = rent_id;
    }

    public Integer getLandlord_id() {
        return landlord_id;
    }

    public void setLandlord_id(Integer landlord_id) {
        this.landlord_id = landlord_id;
    }

    public Integer getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(Integer tenant_id) {
        this.tenant_id = tenant_id;
    }

    public String getRent_price() {
        return rent_price;
    }

    public void setRent_price(String rent_price) {
        this.rent_price = rent_price;
    }

    public Long getRent_time() {
        return rent_time;
    }

    public void setRent_time(Long rent_time) {
        this.rent_time = rent_time;
    }

    public Long getRent_endtime() {
        return rent_endtime;
    }

    public void setRent_endtime(Long rent_endtime) {
        this.rent_endtime = rent_endtime;
    }

    public Integer getRent_type() {
        return rent_type;
    }

    public void setRent_type(Integer rent_type) {
        this.rent_type = rent_type;
    }
}
