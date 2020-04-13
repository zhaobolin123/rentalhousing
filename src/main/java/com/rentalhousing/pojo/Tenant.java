package com.rentalhousing.pojo;

import java.util.Date;

/**
 * @Author: 赵博林
 * @Date:2020/4/14 1:19
 * @Description:
 * @Param：
 * @return ：
 */

//租客表
public class Tenant {
    private Integer tenant_id;
    private String tenant_phone;
    private String tenant_password;
    private String tenant_mail;
    private String tenant_nickname;
    private String tenant_realname;
    private String tenant_IDnumber;
    private String tenant_contact;
    private String tenant_pic;
    private Integer tenant_sex;
    private Date tenant_time;

    public Integer getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(Integer tenant_id) {
        this.tenant_id = tenant_id;
    }

    public String getTenant_phone() {
        return tenant_phone;
    }

    public void setTenant_phone(String tenant_phone) {
        this.tenant_phone = tenant_phone;
    }

    public String getTenant_password() {
        return tenant_password;
    }

    public void setTenant_password(String tenant_password) {
        this.tenant_password = tenant_password;
    }

    public String getTenant_mail() {
        return tenant_mail;
    }

    public void setTenant_mail(String tenant_mail) {
        this.tenant_mail = tenant_mail;
    }

    public String getTenant_nickname() {
        return tenant_nickname;
    }

    public void setTenant_nickname(String tenant_nickname) {
        this.tenant_nickname = tenant_nickname;
    }

    public String getTenant_realname() {
        return tenant_realname;
    }

    public void setTenant_realname(String tenant_realname) {
        this.tenant_realname = tenant_realname;
    }

    public String getTenant_IDnumber() {
        return tenant_IDnumber;
    }

    public void setTenant_IDnumber(String tenant_IDnumber) {
        this.tenant_IDnumber = tenant_IDnumber;
    }

    public String getTenant_contact() {
        return tenant_contact;
    }

    public void setTenant_contact(String tenant_contact) {
        this.tenant_contact = tenant_contact;
    }

    public String getTenant_pic() {
        return tenant_pic;
    }

    public void setTenant_pic(String tenant_pic) {
        this.tenant_pic = tenant_pic;
    }

    public Integer getTenant_sex() {
        return tenant_sex;
    }

    public void setTenant_sex(Integer tenant_sex) {
        this.tenant_sex = tenant_sex;
    }

    public Date getTenant_time() {
        return tenant_time;
    }

    public void setTenant_time(Date tenant_time) {
        this.tenant_time = tenant_time;
    }
}
