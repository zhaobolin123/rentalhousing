package com.rentalhousing.mapper;


import com.rentalhousing.dto.HousingresourcesDto;
import com.rentalhousing.po.Housingresources;

import java.util.List;
import java.util.Map;

/**
* Author: 赵博林
* @Date 2020/3/12 19:55
* @Description: 
* @Param: 
* @return : 
*/
public interface HousingresourcesMapper {

    //根据房源id查询房源
    Housingresources selectHousingresourcesById(Integer housingresources_id);

    //根据条件查询房源列表
    List<Housingresources> selectHousingresourcesList(HousingresourcesDto dto);

    //根据条件查询房源列表总数
    Integer selectHousingresourcesListCount(HousingresourcesDto dto);

    //根据房东id查询房源列表
    List<Housingresources> selectHousingresourcesByLandlordId(Map<String,Object> HousingresourcesMap);

    //根据租客id查询房源列表
    List<Housingresources> selectHousingresourcesByTenantId(Integer tenant_id);

    //根据房东id查询房源列表总数
    Integer selectHousingresourcesByLandlordIdCount(Map<String,Object> HousingresourcesMap);

    //添加房源
    void addHousingresources(Housingresources housingresources);

    //修改房源信息
    void updateHousingresourcesinfo(Housingresources housingresources);

    //删除房源
    void delectHousingresources(Integer housingresources_id);
}
