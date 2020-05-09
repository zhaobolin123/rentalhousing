package com.rentalhousing.service;


import com.rentalhousing.dto.HousingresourcesDto;
import com.rentalhousing.po.Housingresources;

import java.util.Map;

/**
* Author: 赵博林
* @Date 2020/3/16 19:48
* @Description:
* @Param:
* @return :
*/
public interface HousingresourcesService {
    //根据房源id查询房源
    Map<String,Object> selectHousingresourcesById(Integer housingresources_id) throws Exception;

    //根据条件查询房源列表
    Map<String,Object> selectHousingresourcesList(HousingresourcesDto dto) throws Exception;

    //根据房东id查询房源列表
    Map<String,Object> selectHousingresourcesByLandlordId(Integer landlord_id,String housingresources_name,Integer currIndex, Integer pageSize)throws Exception;

    //添加房源
    Map<String,Object> addHousingresources(Housingresources housingresources) throws Exception;

    //修改房源信息
    Map<String, Object> updateHousingresourcesinfo(Housingresources housingresources) throws  Exception;

    //删除房源
    Map<String,Object> delectHousingresources(Integer housingresources_id) throws Exception;
}
