package com.rentalhousing.controller;

import com.rentalhousing.dto.HousingresourcesDto;
import com.rentalhousing.po.Housingresources;
import com.rentalhousing.service.HousingresourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
* Author: 赵博林
* @Date 2020/3/12 20:07
* @Description:
* @Param:
* @return :
*/
@Controller
public class HousingresourcesController {
    @Autowired
    private HousingresourcesService housingresourcesService;

    //根据房源id查询房源
    @RequestMapping(value = "selectHousingresourcesById",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectHousingresourcesById(Integer housingresources_id) throws Exception{
        Map<String,Object> map = housingresourcesService.selectHousingresourcesById(housingresources_id);
        return map;
    }

    //根据条件查询房源列表
    @RequestMapping(value = "selectHousingresourcesList",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectHousingresourcesList(HousingresourcesDto dto) throws Exception{
        Map<String,Object> map = housingresourcesService.selectHousingresourcesList(dto);
        return map;
    }

    //根据房东id查询房源列表
    @RequestMapping(value = "selectHousingresourcesByLandlordId",method = RequestMethod.POST)
    @ResponseBody
        public Map<String,Object> selectHousingresourcesByLandlordId(Integer landlord_id,String housingresources_name,Integer currIndex, Integer pageSize) throws Exception{
        Map<String,Object> map = housingresourcesService.selectHousingresourcesByLandlordId(landlord_id,housingresources_name,currIndex,pageSize);
        return map;
    }

    //根据租客id查询房源列表
    @RequestMapping(value = "selectHousingresourcesByTenantId",method = RequestMethod.POST)
    @ResponseBody
        public Map<String,Object> selectHousingresourcesByTenantId(Integer tenant_id) throws Exception{
        Map<String,Object> map = housingresourcesService.selectHousingresourcesByTenantId(tenant_id);
        return map;
    }

    //添加房源
    @RequestMapping(value = "addHousingresources",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addHousingresources(Housingresources housingresources) throws Exception{
        Map<String,Object> map = housingresourcesService.addHousingresources(housingresources);
        return map;
    }

    //修改房源信息
    @RequestMapping(value = "updateHousingresourcesinfo",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateHousingresourcesinfo(Housingresources housingresources) throws Exception{
        Map<String,Object> map = housingresourcesService.updateHousingresourcesinfo(housingresources);
        return map;
    }

    //删除房源
    @RequestMapping(value = "delectHousingresources",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> delectHousingresources(Integer housingresources_id) throws Exception{
        Map<String,Object> map = housingresourcesService.delectHousingresources(housingresources_id);
        return map;
    }
}
