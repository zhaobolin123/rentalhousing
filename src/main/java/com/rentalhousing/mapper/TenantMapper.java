package com.rentalhousing.mapper;

import com.rentalhousing.po.Tenant;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

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

    //判断昵名是否唯一
    Integer isNickName(String tenant_nickname);

    //根据昵名查询租客列表
    List<Tenant> selectTenantByNickName(String tenant_nickname);

}
