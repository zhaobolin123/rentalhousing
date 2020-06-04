package com.rentalhousing.mapper;

import com.rentalhousing.po.Apply;
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
public interface ApplyMapper {

    //根据id查询申请
    Apply selectApplyById(Integer apply_id);

    //新建申请
    void AddApply(Apply apply);

    //根据租客id查询申请列表
    List<Apply> selectApplyListByTenantId(Map<String,Object> applyMap);

    //根据房东id查询申请列表
    List<Apply> selectApplyListByLandlordId(Map<String,Object> applyMap);

    //根据租客id查询申请列表总数
    Integer selectApplyListByTenantIdCount(Map<String,Object> applyMap);

    //根据房东id查询申请列表总数
    Integer selectApplyListByLandlordIdCount(Map<String,Object> applyMap);

    //修改申请信息
    void updateApply(Apply apply);

    //删除申请
    void deleteApply(Integer apply_id);

}
