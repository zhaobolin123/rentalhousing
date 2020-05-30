package com.rentalhousing.service.impl;

import com.rentalhousing.mapper.HousingresourcesMapper;
import com.rentalhousing.mapper.LandlordMapper;
import com.rentalhousing.mapper.LeaseMapper;
import com.rentalhousing.mapper.TenantMapper;
import com.rentalhousing.po.Housingresources;
import com.rentalhousing.po.Landlord;
import com.rentalhousing.po.Lease;
import com.rentalhousing.po.Tenant;
import com.rentalhousing.service.LeaseService;
import com.rentalhousing.utils.ResUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: 赵博林
 * @Date:2020/4/14 1:42
 * @Description:
 * @Param：
 * @return ：
 */
@Service("LeaseService")
public class LeaseServiceImpl implements LeaseService {

    @Autowired
    private LeaseMapper leaseMapper;
    @Autowired
    private HousingresourcesMapper housingresourcesMapper;
    @Autowired
    private LandlordMapper landlordMapper;
    @Autowired
    private TenantMapper tenantMapper;

    //根据id查询租赁
    @Override
        public Map<String, Object> selectLeaseById(Integer lease_id) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(lease_id) || Objects.equals("", lease_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                Lease lease = leaseMapper.selectLeaseById(lease_id);
                map.put("lease",lease);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //新建租赁
    @Override
    public Map<String, Object> AddLease(Lease lease) throws Exception {
        Map<String,Object> map = new HashMap<>();
        Housingresources housingresources = new Housingresources();

        if (StringUtils.isEmpty(lease.getTenant_id()) || Objects.equals("", lease.getTenant_id())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else if (StringUtils.isEmpty(lease.getHousingresources_id()) || Objects.equals("", lease.getHousingresources_id())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String nowdayTime = dateFormat.format(new Date());
                Date nowDate = dateFormat.parse(nowdayTime);
                lease.setLease_time(nowDate);
                housingresources.setHousingresources_id(lease.getHousingresources_id());
                housingresources.setHousingresources_state(1);
                leaseMapper.AddLease(lease);
                housingresourcesMapper.updateHousingresourcesinfo(housingresources);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //根据房东id查询租赁列表
    @Override
    public Map<String, Object> selectLeaseListByLandlordId(Integer landlord_id,String lease_type,Integer currIndex, Integer pageSize) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<Lease> leaseList = new ArrayList<Lease>();
        Map<String,Object> applyMap = new HashMap<>();
        Map<String,Object> leaseInfoMap = new HashMap<>();
        ArrayList leaseInfoList = new ArrayList<>();
        applyMap.put("landlord_id",landlord_id);
        applyMap.put("lease_type",lease_type);
        applyMap.put("currIndex",(currIndex-1)*pageSize);
        applyMap.put("pageSize",pageSize);

        if (StringUtils.isEmpty(landlord_id) || Objects.equals("",landlord_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else if (StringUtils.isEmpty(lease_type) || Objects.equals("",lease_type)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                leaseList = leaseMapper.selectLeaseListByLandlordId(applyMap);
                if(leaseList != null) {
                    for (Lease lease : leaseList) {
                        leaseInfoMap.clear();
                        leaseInfoMap.put("lease", lease);
                        Tenant tenant = tenantMapper.selectTenantById(lease.getTenant_id());
                        leaseInfoMap.put("tenant", tenant);
                        Housingresources housingresources = housingresourcesMapper.selectHousingresourcesById(lease.getHousingresources_id());
                        Landlord landlord = landlordMapper.selectById(housingresources.getLandlord_id());
                        leaseInfoMap.put("landlord", landlord);
                        leaseInfoList.add(leaseInfoMap);
                    }
                }
                map.put("leaseInfoList",leaseInfoList);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //根据租客id查询租赁列表
    @Override
    public Map<String, Object> selectLeaseListByTenantId(Integer tenant_id) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<Lease> leaseList = new ArrayList<Lease>();
        Map<String,Object> leaseInfoMap = new HashMap<>();
        ArrayList leaseInfoList = new ArrayList<>();

        if (StringUtils.isEmpty(tenant_id) || Objects.equals("",tenant_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                leaseList = leaseMapper.selectLeaseListByTenantId(tenant_id);
                if(leaseList != null) {
                    for (Lease lease : leaseList) {
                        leaseInfoMap.clear();
                        leaseInfoMap.put("lease", lease);
                        Tenant tenant = tenantMapper.selectTenantById(tenant_id);
                        leaseInfoMap.put("tenant", tenant);
                        Housingresources housingresources = housingresourcesMapper.selectHousingresourcesById(lease.getHousingresources_id());
                        Landlord landlord = landlordMapper.selectById(housingresources.getLandlord_id());
                        leaseInfoMap.put("landlord", landlord);
                        leaseInfoList.add(leaseInfoMap);
                    }
                }
                map.put("leaseInfoList",leaseInfoList);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //退房
    @Override
    public Map<String, Object> updateLease(Lease lease) throws Exception {
        Map<String,Object> map = new HashMap<>();
        Housingresources housingresources = new Housingresources();

        if (StringUtils.isEmpty(lease.getLease_id()) || Objects.equals("",lease.getLease_id())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else if (StringUtils.isEmpty(lease.getHousingresources_id()) || Objects.equals("",lease.getHousingresources_id())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                housingresources.setHousingresources_id(lease.getHousingresources_id());
                housingresources.setHousingresources_state(0);
                leaseMapper.updateLease(lease.getLease_id());
                housingresourcesMapper.updateHousingresourcesinfo(housingresources);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }
}
