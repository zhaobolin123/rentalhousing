package com.rentalhousing.service;

import com.rentalhousing.po.Rent;

import java.util.Map;

/**
 * @Author: 赵博林
 * @Date:2020/4/14 1:42
 * @Description:
 * @Param：
 * @return ：
 */
public interface RentService {

    //根据id查询租金
    Map<String,Object> selectRentById(Integer rent_id) throws Exception;

    //新建租金
    Map<String,Object> AddRent(Rent rent) throws Exception;

    //根据租客id查询租金列表
    Map<String,Object> selectRentListByTenantId(Integer tenant_id,Integer rent_type, Integer currIndex, Integer pageSize) throws Exception;

    //根据房东id查询租金列表
    Map<String,Object> selectRentListByLandlordId(Integer landlord_id,Integer rent_type, Integer currIndex, Integer pageSize) throws Exception;

    //修改租金信息
    Map<String,Object> updateRent(Rent rent) throws Exception;

    //缴纳租金
    Map<String,Object> payRent(Integer rent_id) throws Exception;

    //删除租金
    Map<String,Object> deleteRent(Integer rent_id) throws Exception;
}
