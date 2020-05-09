package com.rentalhousing.service;

import com.rentalhousing.po.Lease;

import java.util.Map;

/**
 * @Author: 赵博林
 * @Date:2020/4/14 1:42
 * @Description:
 * @Param：
 * @return ：
 */
public interface LeaseService {

    //根据id查询租赁
    Map<String,Object> selectLeaseById(Integer lease_id) throws Exception;

    //新建租赁
    Map<String,Object> AddLease(Lease lease) throws Exception;

    //根据房东id查询租赁列表
    Map<String,Object> selectLeaseListByLandlordId(Integer landlord_id,String lease_type,Integer currIndex, Integer pageSize) throws Exception;

    //修改租赁信息
    Map<String,Object> updateLease(Lease lease) throws Exception;
}
