package com.rentalhousing.po;

import java.math.BigInteger;
import java.util.Date;

/**
 * @Author: 赵博林
 * @Date:2020/4/14 1:18
 * @Description:
 * @Param：
 * @return ：
 */

//房东表
public class Landlord {
    private Integer landlord_id;
    private String landlord_phone;
    private String landlord_password;
    private String landlord_mail;
    private String landlord_nickname;
    private String landlord_realname;
    private String landlord_IDnumber;
    private String landlord_contact;
    private String landlord_pic;
    private Integer landlord_sex;
    private Long landlord_time;

    public Integer getLandlord_id() {
        return landlord_id;
    }

    public void setLandlord_id(Integer landlord_id) {
        this.landlord_id = landlord_id;
    }

    public String getLandlord_phone() {
        return landlord_phone;
    }

    public void setLandlord_phone(String landlord_phone) {
        this.landlord_phone = landlord_phone;
    }

    public String getLandlord_password() {
        return landlord_password;
    }

    public void setLandlord_password(String landlord_password) {
        this.landlord_password = landlord_password;
    }

    public String getLandlord_mail() {
        return landlord_mail;
    }

    public void setLandlord_mail(String landlord_mail) {
        this.landlord_mail = landlord_mail;
    }

    public String getLandlord_nickname() {
        return landlord_nickname;
    }

    public void setLandlord_nickname(String landlord_nickname) {
        this.landlord_nickname = landlord_nickname;
    }

    public String getLandlord_realname() {
        return landlord_realname;
    }

    public void setLandlord_realname(String landlord_realname) {
        this.landlord_realname = landlord_realname;
    }

    public String getLandlord_IDnumber() {
        return landlord_IDnumber;
    }

    public void setLandlord_IDnumber(String landlord_IDnumber) {
        this.landlord_IDnumber = landlord_IDnumber;
    }

    public String getLandlord_contact() {
        return landlord_contact;
    }

    public void setLandlord_contact(String landlord_contact) {
        this.landlord_contact = landlord_contact;
    }

    public String getLandlord_pic() {
        return landlord_pic;
    }

    public void setLandlord_pic(String landlord_pic) {
        this.landlord_pic = landlord_pic;
    }

    public Integer getLandlord_sex() {
        return landlord_sex;
    }

    public void setLandlord_sex(Integer landlord_sex) {
        this.landlord_sex = landlord_sex;
    }

    public Long getLandlord_time() {
        return landlord_time;
    }

    public void setLandlord_time(Long landlord_time) {
        this.landlord_time = landlord_time;
    }
}
