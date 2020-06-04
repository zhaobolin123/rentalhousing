package com.rentalhousing.service.impl;

import com.rentalhousing.mapper.HousingresourcesMapper;
import com.rentalhousing.mapper.LandlordMapper;
import com.rentalhousing.mapper.RentMapper;
import com.rentalhousing.mapper.TenantMapper;
import com.rentalhousing.po.Housingresources;
import com.rentalhousing.po.Landlord;
import com.rentalhousing.po.Rent;
import com.rentalhousing.po.Tenant;
import com.rentalhousing.service.RentService;
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
@Service("RentService")
public class RentServiceImpl implements RentService {

    @Autowired
    private RentMapper rentMapper;
    @Autowired
    private LandlordMapper landlordMapper;
    @Autowired
    private TenantMapper tenantMapper;
    @Autowired
    private HousingresourcesMapper housingresourcesMapper;

    //根据id查询租金
    @Override
        public Map<String, Object> selectRentById(Integer rent_id) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(rent_id) || Objects.equals("", rent_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                Rent rent = rentMapper.selectRentById(rent_id);
                map.put("rent",rent);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //新建租金
    @Override
    public Map<String, Object> AddRent(Rent rent) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(rent.getTenant_id()) || Objects.equals("", rent.getTenant_id())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else if (StringUtils.isEmpty(rent.getLandlord_id()) || Objects.equals("", rent.getLandlord_id())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                rentMapper.AddRent(rent);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //根据租客id查询租金列表
        @Override
        public Map<String, Object> selectRentListByTenantId(Integer tenant_id,Integer rent_type,Integer currIndex, Integer pageSize) throws Exception {
            Map<String,Object> map = new HashMap<>();
            List<Rent> rentList = new ArrayList<Rent>();
            Map<String,Object> rentMap = new HashMap<>();
            ArrayList rentInfoList = new ArrayList<>();
            rentMap.put("tenant_id",tenant_id);
            rentMap.put("rent_type",rent_type);
            rentMap.put("currIndex",(currIndex-1)*pageSize);
            rentMap.put("pageSize",pageSize);

            if (StringUtils.isEmpty(tenant_id) || Objects.equals("",tenant_id)) {
                return ResUtil.error(map,"001","传入参数不能为空!");
            }
            else{
                try {
                    rentList = rentMapper.selectRentListByTenantId(rentMap);
                    Integer count = rentMapper.selectRentListByTenantIdCount(rentMap);
                    if(rentList != null) {
                        for (Rent rent : rentList) {
                            Map<String,Object> rentInfoMap = new HashMap<>();
                            rentInfoMap.clear();
                            rentInfoMap.put("rent", rent);
                            Tenant tenant = tenantMapper.selectTenantById(tenant_id);
                            rentInfoMap.put("tenant", tenant);
                            Landlord landlord = landlordMapper.selectById(rent.getLandlord_id());
                            rentInfoMap.put("landlord", landlord);
                            rentInfoList.add(rentInfoMap);
                        }
                    }
                    map.put("count",count);
                    map.put("rentInfoList",rentInfoList);
                } catch (Exception e) {
                    e.printStackTrace();
                    return ResUtil.error(map,"005","异常,请联系管理员！");
                }
            }
            return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //根据房东id查询租金列表
    @Override
    public Map<String, Object> selectRentListByLandlordId(Integer landlord_id,Integer rent_type,Integer currIndex, Integer pageSize) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<Rent> rentList = new ArrayList<Rent>();
        Map<String,Object> rentMap = new HashMap<>();
        ArrayList rentInfoList = new ArrayList<>();
        rentMap.put("landlord_id",landlord_id);
        rentMap.put("rent_type",rent_type);
        rentMap.put("currIndex",(currIndex-1)*pageSize);
        rentMap.put("pageSize",pageSize);

        if (StringUtils.isEmpty(landlord_id) || Objects.equals("",landlord_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                rentList = rentMapper.selectRentListByLandlordId(rentMap);
                Integer count = rentMapper.selectRentListByLandlordIdCount(rentMap);
                if(rentList != null) {
                    for (Rent rent : rentList) {
                        Map<String,Object> rentInfoMap = new HashMap<>();
                        rentInfoMap.clear();
                        rentInfoMap.put("rent", rent);
                        Tenant tenant = tenantMapper.selectTenantById(rent.getTenant_id());
                        rentInfoMap.put("tenant", tenant);
                        Landlord landlord = landlordMapper.selectById(landlord_id);
                        rentInfoMap.put("landlord", landlord);
                        rentInfoList.add(rentInfoMap);
                    }
                }
                map.put("count",count);
                map.put("rentInfoList",rentInfoList);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //修改租金信息
    @Override
    public Map<String, Object> updateRent(Rent rent) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(rent.getRent_id()) || Objects.equals("",rent.getRent_id())) {
            return ResUtil.error(map,"001","传入id不能为空!");
        }
        else{
            try {
                rentMapper.updateRent(rent);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //缴纳租金
    @Override
    public Map<String, Object> payRent(Integer rent_id) throws Exception {
        Map<String,Object> map = new HashMap<>();
        Rent rent = new Rent();

        if (StringUtils.isEmpty(rent_id) || Objects.equals("",rent_id)) {
            return ResUtil.error(map,"001","传入id不能为空!");
        }
        else{
            try {
                long nowDate = System.currentTimeMillis();
                rent.setRent_endtime(nowDate);
                rent.setRent_type(1);
                rent.setRent_id(rent_id);
                rentMapper.updateRent(rent);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //删除租金
    @Override
    public Map<String, Object> deleteRent(Integer rent_id) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(rent_id) || Objects.equals("", rent_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                rentMapper.deleteRent(rent_id);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }
}
