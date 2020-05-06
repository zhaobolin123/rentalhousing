package com.rentalhousing.mapper;

import com.rentalhousing.po.Obstacle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: 赵博林
 * @Date:2020/4/14 1:38
 * @Description:
 * @Param：
 * @return ：
 */
@Mapper
public interface ObstacleMapper {

    //根据id查询报障
    Obstacle selectObstacleById(Integer obstacle_id);

    //新建报障
    void AddObstacle(Obstacle obstacle);

    //根据租客id查询报障列表
    List<Obstacle> selectObstacleListByTenantId(Integer tenant_id);

    //根据房东id查询报障列表
    List<Obstacle> selectObstacleListByLandlordId(Integer landlord_id);

    //修改报障信息
    void updateObstacle(Obstacle obstacle);

}
