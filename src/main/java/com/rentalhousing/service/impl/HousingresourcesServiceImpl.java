package com.rentalhousing.service.impl;

import com.rentalhousing.dto.HousingresourcesDto;
import com.rentalhousing.mapper.HousingresourcesMapper;
import com.rentalhousing.mapper.LandlordMapper;
import com.rentalhousing.po.Housingresources;
import com.rentalhousing.po.Landlord;
import com.rentalhousing.service.HousingresourcesService;
import com.rentalhousing.utils.ResUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
* Author: 赵博林
* @Date 2020/3/12 19:55
* @Description: 
* @Param: 
* @return : 
*/
@Service("HousingresourcesService")
public class HousingresourcesServiceImpl implements HousingresourcesService {

    @Autowired
    private HousingresourcesMapper housingresourcesMapper;

    @Autowired
    private LandlordMapper landlordMapper;

    //根据房源id查询房源
    @Override
    public Map<String, Object> selectHousingresourcesById(Integer housingresources_id) throws Exception {
        Map<String,Object> map = new HashMap<>();
        Housingresources housingresources;

        if (StringUtils.isEmpty(housingresources_id) || Objects.equals("", housingresources_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                housingresources = housingresourcesMapper.selectHousingresourcesById(housingresources_id);
                Landlord landlord = landlordMapper.selectById(housingresources.getLandlord_id());
                map.put("housingresources",housingresources);
                map.put("landlord",landlord);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //根据条件查询房源列表
    @Override
    public Map<String, Object> selectHousingresourcesList(HousingresourcesDto dto) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<Housingresources> housingresourceslist;

        if (StringUtils.isEmpty(dto.getCurrIndex()) || Objects.equals("", dto.getCurrIndex())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else if(StringUtils.isEmpty(dto.getPageSize()) || Objects.equals("", dto.getPageSize())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                dto.setCurrIndex((dto.getCurrIndex()-1)*dto.getPageSize());
                housingresourceslist = housingresourcesMapper.selectHousingresourcesList(dto);
                Integer count = housingresourcesMapper.selectHousingresourcesListCount(dto);
                map.put("count",count);
                map.put("housingresourceslist",housingresourceslist);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //根据房东查询房源列表
    @Override
    public Map<String, Object> selectHousingresourcesByLandlordId(Integer landlord_id,String housingresources_name,Integer currIndex, Integer pageSize) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<Housingresources> housingresourceslist;
        Map<String,Object> HousingresourcesMap = new HashMap<>();
        HousingresourcesMap.put("landlord_id",landlord_id);
        HousingresourcesMap.put("housingresources_name",housingresources_name);
        HousingresourcesMap.put("currIndex",(currIndex-1)*pageSize);
        HousingresourcesMap.put("pageSize",pageSize);

        if (StringUtils.isEmpty(landlord_id) || Objects.equals("", landlord_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                housingresourceslist = housingresourcesMapper.selectHousingresourcesByLandlordId(HousingresourcesMap);
                Integer count = housingresourcesMapper.selectHousingresourcesByLandlordIdCount(HousingresourcesMap);
                map.put("count",count);
                map.put("housingresourceslist",housingresourceslist);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //根据租客id查询房源列表
    @Override
    public Map<String, Object> selectHousingresourcesByTenantId(Integer tenant_id) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<Housingresources> housingresourceslist;

        if (StringUtils.isEmpty(tenant_id) || Objects.equals("", tenant_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                housingresourceslist = housingresourcesMapper.selectHousingresourcesByTenantId(tenant_id);
                map.put("housingresourceslist",housingresourceslist);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }


    //添加房源
    @Override
    public Map<String, Object> addHousingresources(Housingresources housingresources) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(housingresources.getLandlord_id()) || Objects.equals("", housingresources.getLandlord_id())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                housingresourcesMapper.addHousingresources(housingresources);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //修改房源信息
    @Override
    public Map<String, Object> updateHousingresourcesinfo(Housingresources housingresources) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(housingresources.getHousingresources_id()) || Objects.equals("", housingresources.getHousingresources_id())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                housingresourcesMapper.updateHousingresourcesinfo(housingresources);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //删除房源
    @Override
    public Map<String, Object> delectHousingresources(Integer housingresources_id) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(housingresources_id) || Objects.equals("", housingresources_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                housingresourcesMapper.delectHousingresources(housingresources_id);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }
}
