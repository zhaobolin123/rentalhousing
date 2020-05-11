package com.rentalhousing.service;

import com.rentalhousing.po.Tenant;

import java.util.Map;

/**
 * @Author: 赵博林
 * @Date:2020/4/14 1:42
 * @Description:
 * @Param：
 * @return ：
 */
public interface TenantService {

    //根据id查询租客
    Map<String,Object> selectTenantById(Integer tenant_id) throws Exception;

    //注册租客
    Map<String,Object> registTenant(Tenant tenant) throws Exception;

    //租客登录
    Map<String,Object> loginTenant(Tenant tenant) throws Exception;

    //修改租客信息
    Map<String,Object> updateTenant(Tenant tenant) throws Exception;

    //判断昵名是否唯一
    Map<String,Object> isNickName(String tenant_nickname) throws Exception;

    //根据昵名查询租客列表
    Map<String,Object> selectTenantByNickName(String tenant_nickname) throws Exception;
}
