package com.rentalhousing.service;

import com.rentalhousing.po.Landlord;

import java.util.Map;

/**
 * @Author: 赵博林
 * @Date:2020/4/14 1:42
 * @Description:
 * @Param：
 * @return ：
 */
public interface LandlordService {

    //根据id查询房东
    Map<String,Object> selectById(Integer landlord_id) throws Exception;

    //注册房东
    Map<String,Object> registLandlord(Landlord landlord) throws Exception;

    //房东登录
    Map<String,Object> loginLandlord(Landlord landlord) throws Exception;

    //修改房东信息
    Map<String,Object> updateLandlord(Landlord landlord) throws Exception;
}
