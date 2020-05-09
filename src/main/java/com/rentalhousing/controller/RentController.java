package com.rentalhousing.controller;

import com.rentalhousing.po.Rent;
import com.rentalhousing.service.RentService;
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
public class RentController {
    @Autowired
    private RentService rentService;

    //根据id查询租金
    @RequestMapping(value = "selectRentById",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectRentById(Integer rent_id) throws Exception{
    Map<String,Object> map = rentService.selectRentById(rent_id);
    return map;
    }

    //新建租金
    @RequestMapping(value = "AddRent",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> AddRent(Rent rent) throws Exception{
        Map<String,Object> map = rentService.AddRent(rent);
        return map;
    }

    //根据租客id查询租金列表
    @RequestMapping(value = "selectRentListByTenantId",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectRentListByTenantId(Integer tenant_id,Integer rent_type, Integer currIndex, Integer pageSize) throws Exception{
        Map<String,Object> map = rentService.selectRentListByTenantId(tenant_id,rent_type,currIndex,pageSize);
        return map;
    }

    //根据房东id查询租金列表
    @RequestMapping(value = "selectRentListByLandlordId",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectRentListByLandlordId(Integer landlord_id,Integer rent_type,Integer currIndex, Integer pageSize) throws Exception{
        Map<String,Object> map = rentService.selectRentListByLandlordId(landlord_id,rent_type,currIndex,pageSize);
        return map;
    }

    //修改租金信息
    @RequestMapping(value = "updateRent",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateRent(Rent rent) throws Exception{
        Map<String,Object> map = rentService.updateRent(rent);
        return map;
    }

    //缴纳租金
    @RequestMapping(value = "payRent",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> payRent(Integer rent_id) throws Exception{
        Map<String,Object> map = rentService.payRent(rent_id);
        return map;
    }
}
