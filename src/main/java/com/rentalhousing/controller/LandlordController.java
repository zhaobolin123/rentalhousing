package com.rentalhousing.controller;

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
}
