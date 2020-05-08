package com.rentalhousing.service;

import com.rentalhousing.po.Apply;

import java.util.Map;

/**
 * @Author: 赵博林
 * @Date:2020/4/14 1:42
 * @Description:
 * @Param：
 * @return ：
 */
public interface ApplyService {

    //根据id查询申请
    Map<String,Object> selectApplyById(Integer apply_id) throws Exception;

    //新建申请
    Map<String,Object> AddApply(Apply apply) throws Exception;

    //根据租客id查询申请列表
    Map<String,Object> selectApplyListByTenantId(Integer tenant_id,Integer currIndex, Integer pageSize) throws Exception;

    //根据房东id查询申请列表
    Map<String,Object> selectApplyListByLandlordId(Integer landlord_id,Integer currIndex, Integer pageSize) throws Exception;

    //修改申请信息
    Map<String,Object> updateApply(Apply apply) throws Exception;
}
