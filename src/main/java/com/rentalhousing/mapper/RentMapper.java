package com.rentalhousing.mapper;

import com.rentalhousing.po.Rent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: 赵博林
 * @Date:2020/4/14 1:38
 * @Description:
 * @Param：
 * @return ：
 */
@Mapper
public interface RentMapper {

    //根据id查询租金
    Rent selectRentById(Integer rent_id);

    //新建租金
    void AddRent(Rent rent);

    //根据租客id查询租金列表
    List<Rent> selectRentListByTenantId(Map<String, Object> rentMap);

    //根据房东id查询租金列表
    List<Rent> selectRentListByLandlordId(Map<String, Object> rentMap);

    //根据租客id查询租金列表总数
    Integer selectRentListByTenantIdCount(Map<String,Object> applyMap);

    //根据房东id查询租金列表总数
    Integer selectRentListByLandlordIdCount(Map<String,Object> applyMap);

    //修改租金信息
    void updateRent(Rent rent);

}
