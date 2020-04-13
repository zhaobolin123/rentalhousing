package com.rentalhousing.mapper;

import com.rentalhousing.pojo.Landlord;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: 赵博林
 * @Date:2020/4/14 1:38
 * @Description:
 * @Param：
 * @return ：
 */
@Mapper
public interface LandlordMapper {

    //根据id查询房东
    Landlord selectById (Integer landlord_id);
}
