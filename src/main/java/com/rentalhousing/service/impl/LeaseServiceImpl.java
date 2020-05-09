package com.rentalhousing.service.impl;

import com.rentalhousing.mapper.LeaseMapper;
import com.rentalhousing.po.Lease;
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

                leaseMapper.AddLease(lease);
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
        applyMap.put("landlord_id",landlord_id);
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
                if("0".equals(lease_type)){
                    applyMap.put("lease_type",0);
                    applyMap.put("lease_type2",0);
                }else{
                    applyMap.put("lease_type",1);
                    applyMap.put("lease_type2",2);
                }
                leaseList = leaseMapper.selectLeaseListByLandlordId(applyMap);
                map.put("leaseList",leaseList);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //修改租赁信息
    @Override
    public Map<String, Object> updateLease(Lease lease) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(lease.getLease_id()) || Objects.equals("",lease.getLease_id())) {
            return ResUtil.error(map,"001","传入id不能为空!");
        }
        else  if (StringUtils.isEmpty(lease.getLease_type()) || Objects.equals("",lease.getLease_type())) {
            return ResUtil.error(map,"001","传入id不能为空!");
        }
        else{
            try {
                leaseMapper.updateLease(lease);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }
}
