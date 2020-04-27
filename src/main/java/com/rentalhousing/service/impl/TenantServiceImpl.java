package com.rentalhousing.service.impl;

import com.rentalhousing.mapper.TenantMapper;
import com.rentalhousing.pojo.Tenant;
import com.rentalhousing.service.TenantService;
import com.rentalhousing.utils.ResUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: 赵博林
 * @Date:2020/4/14 1:42
 * @Description:
 * @Param：
 * @return ：
 */
@Service("TenantService")
public class TenantServiceImpl implements TenantService {

    @Autowired
    private TenantMapper tenantMapper;

    //根据id查询房东
    @Override
    public Map<String, Object> selectTenantById(Integer tenant_id) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(tenant_id) || Objects.equals("", tenant_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                Tenant tenant = tenantMapper.selectTenantById(tenant_id);
                map.put("tenant",tenant);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //注册
    @Override
    public Map<String, Object> registTenant(Tenant tenant) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(tenant.getTenant_phone()) || Objects.equals("", tenant.getTenant_phone())) {
            return ResUtil.error(map,"001","手机号不能为空!");
        }
        else if (StringUtils.isEmpty(tenant.getTenant_mail()) || Objects.equals("", tenant.getTenant_mail())) {
            return ResUtil.error(map,"001","邮箱不能为空!");
        }
        else if (StringUtils.isEmpty(tenant.getTenant_password()) || Objects.equals("", tenant.getTenant_password())) {
            return ResUtil.error(map,"001","密码不能为空!");
        }
        else{
            try {
                if (0!=tenantMapper.isTenantRegist(tenant.getTenant_phone())){
                    return ResUtil.error(map,"002","手机号已被注册！");
                }
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String nowdayTime = dateFormat.format(new Date());
                Date nowDate = dateFormat.parse(nowdayTime);
                tenant.setTenant_time(nowDate);

                tenantMapper.registTenant(tenant);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //登录
    @Override
    public Map<String, Object> loginTenant(Tenant tenant) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(tenant.getTenant_phone()) || Objects.equals("",tenant.getTenant_phone())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else if (StringUtils.isEmpty(tenant.getTenant_password()) || Objects.equals("",tenant.getTenant_password())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                if(null== tenantMapper.loginTenant(tenant)){
                    return ResUtil.error(map,"003","账号或密码错误！");
                }
                else{
                    Tenant tenant1 = tenantMapper.loginTenant(tenant);
                    map.put("Tenant",tenant1);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //修改房东信息
    @Override
    @Transactional
    public Map<String, Object> updateTenant(Tenant tenant) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(tenant.getTenant_id()) || Objects.equals("",tenant.getTenant_id())) {
            return ResUtil.error(map,"001","传入id不能为空!");
        }
        else{
            try {
                tenantMapper.updateTenant(tenant);
                Tenant tenant1 = tenantMapper.selectTenantById(tenant.getTenant_id());
                map.put("Tenant",tenant1);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }
}
