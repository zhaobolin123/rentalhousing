package com.rentalhousing.service;

import com.rentalhousing.po.Obstacle;
import com.rentalhousing.po.Tenant;

import java.util.List;
import java.util.Map;

/**
 * @Author: 赵博林
 * @Date:2020/4/14 1:42
 * @Description:
 * @Param：
 * @return ：
 */
public interface ObstacleService {

    //根据id查询报障
    Map<String,Object> selectObstacleById(Integer obstacle_id) throws Exception;

    //新建报障
    Map<String,Object> AddObstacle(Obstacle obstacle) throws Exception;

    //根据租客id查询报障列表
    Map<String,Object> selectObstacleListByTenantId(Integer tenant_id) throws Exception;

    //根据房东id查询报障列表
    Map<String,Object> selectObstacleListByLandlordId(Integer landlord_id) throws Exception;

    //修改报障信息
    Map<String,Object> updateObstacle(Obstacle obstacle) throws Exception;
}
