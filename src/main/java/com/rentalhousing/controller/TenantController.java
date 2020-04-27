package com.rentalhousing.controller;

import com.rentalhousing.pojo.Tenant;
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

    //根据id查询房东
    @RequestMapping(value = "selectTenantById",method = RequestMethod.POST)
    @ResponseBody
        public Map<String,Object> selectTenantById (Integer tenant_id) throws Exception{
        Map<String,Object> map = tenantService.selectTenantById(tenant_id);
        return map;
    }

    //注册房东
    @RequestMapping(value = "registTenant",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> registTenant(Tenant tenant) throws Exception{
        Map<String,Object> map = tenantService.registTenant(tenant);
        return map;
    }

    //房东登录
    @RequestMapping(value = "loginTenant",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> loginTenant(Tenant tenant) throws Exception{
        Map<String,Object> map = tenantService.loginTenant(tenant);
        return map;
    }

    //修改房东信息
    @RequestMapping(value = "updateTenant",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateTenant(Tenant tenant) throws Exception{
        Map<String,Object> map = tenantService.updateTenant(tenant);
        return map;
    }
}
