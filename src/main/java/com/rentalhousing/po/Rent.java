package com.rentalhousing.po;

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
    private String landlord_id;
    private String tenant_id;
    private String rent_price;
    private String rent_time;
    private Date rent_endtime;
    private Integer rent_type;

    public Integer getRent_id() {
        return rent_id;
    }

    public void setRent_id(Integer rent_id) {
        this.rent_id = rent_id;
    }

    public String getLandlord_id() {
        return landlord_id;
    }

    public void setLandlord_id(String landlord_id) {
        this.landlord_id = landlord_id;
    }

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    public String getRent_price() {
        return rent_price;
    }

    public void setRent_price(String rent_price) {
        this.rent_price = rent_price;
    }

    public String getRent_time() {
        return rent_time;
    }

    public void setRent_time(String rent_time) {
        this.rent_time = rent_time;
    }

    public Date getRent_endtime() {
        return rent_endtime;
    }

    public void setRent_endtime(Date rent_endtime) {
        this.rent_endtime = rent_endtime;
    }

    public Integer getRent_type() {
        return rent_type;
    }

    public void setRent_type(Integer rent_type) {
        this.rent_type = rent_type;
    }
}
