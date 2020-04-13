package com.rentalhousing.service;

import com.rentalhousing.pojo.Landlord;

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
}
