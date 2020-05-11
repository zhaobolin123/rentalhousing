package com.rentalhousing.controller;

import com.rentalhousing.po.Tenant;
import com.rentalhousing.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author: 赵博林
 * @Date:2020/4/14 1:50
 * @Description:
 * @Param：
 * @return ：
 */
@Controller
public class TenantController {
    @Autowired
    private TenantService tenantService;

    //根据id查询租客
    @RequestMapping(value = "selectTenantById",method = RequestMethod.POST)
    @ResponseBody
        public Map<String,Object> selectTenantById (Integer tenant_id) throws Exception{
        Map<String,Object> map = tenantService.selectTenantById(tenant_id);
        return map;
    }

    //注册租客
    @RequestMapping(value = "registTenant",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> registTenant(Tenant tenant) throws Exception{
        Map<String,Object> map = tenantService.registTenant(tenant);
        return map;
    }

    //租客登录
    @RequestMapping(value = "loginTenant",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> loginTenant(Tenant tenant) throws Exception{
        Map<String,Object> map = tenantService.loginTenant(tenant);
        return map;
    }

    //修改租客信息
    @RequestMapping(value = "updateTenant",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateTenant(Tenant tenant) throws Exception{
        Map<String,Object> map = tenantService.updateTenant(tenant);
        return map;
    }

    //判断昵名是否唯一
    @RequestMapping(value = "isNickName",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> isNickName(String tenant_nickname) throws Exception{
        Map<String,Object> map = tenantService.isNickName(tenant_nickname);
        return map;
    }

    //根据昵名查询租客列表
    @RequestMapping(value = "selectTenantByNickName",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectTenantByNickName(String tenant_nickname) throws Exception{
        Map<String,Object> map = tenantService.selectTenantByNickName(tenant_nickname);
        return map;
    }
}
