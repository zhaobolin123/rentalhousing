package com.rentalhousing.controller;

import com.rentalhousing.po.Landlord;
import com.rentalhousing.service.LandlordService;
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
public class LandlordController {
    @Autowired
    private LandlordService landlordService;

    //根据id查询房东
    @RequestMapping(value = "selectById",method = RequestMethod.POST)
    @ResponseBody
        public Map<String,Object> selectById(Integer landlord_id) throws Exception{
        Map<String,Object> map = landlordService.selectById(landlord_id);
        return map;
    }

    //注册房东
    @RequestMapping(value = "registLandlord",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> registLandlord(Landlord landlord) throws Exception{
        Map<String,Object> map = landlordService.registLandlord(landlord);
        return map;
    }

    //房东登录
    @RequestMapping(value = "loginLandlord",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> loginLandlord(Landlord landlord) throws Exception{
        Map<String,Object> map = landlordService.loginLandlord(landlord);
        return map;
    }

    //修改房东信息
    @RequestMapping(value = "updateLandlord",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateLandlord(Landlord landlord) throws Exception{
        Map<String,Object> map = landlordService.updateLandlord(landlord);
        return map;
    }
}
