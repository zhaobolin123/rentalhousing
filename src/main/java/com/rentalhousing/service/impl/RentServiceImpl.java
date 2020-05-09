package com.rentalhousing.service.impl;

import com.rentalhousing.mapper.RentMapper;
import com.rentalhousing.po.Rent;
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
                    map.put("rentList",rentList);
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
                map.put("rentList",rentList);
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
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String nowdayTime = dateFormat.format(new Date());
                Date nowDate = dateFormat.parse(nowdayTime);
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
}
