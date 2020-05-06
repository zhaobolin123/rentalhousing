package com.rentalhousing.mapper;

import com.rentalhousing.po.Tenant;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: 赵博林
 * @Date:2020/4/14 1:38
 * @Description:
 * @Param：
 * @return ：
 */
@Mapper
public interface TenantMapper {

    //根据id查询租客
    Tenant selectTenantById(Integer tenant_id);

    //注册账号
    void registTenant(Tenant tenant);

    //判断是否注册
    int isTenantRegist(String tenant_phone);

    //登录
    Tenant loginTenant(Tenant tenant);

    //修改个人信息
    void updateTenant(Tenant tenant);

}
