package com.rentalhousing.mapper;

import com.rentalhousing.po.Obstacle;
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
public interface ObstacleMapper {

    //根据id查询报障
    Obstacle selectObstacleById(Integer obstacle_id);

    //新建报障
    void AddObstacle(Obstacle obstacle);

    //根据租客id查询报障列表
    List<Obstacle> selectObstacleListByTenantId(Map<String,Object> applyMap);

    //根据房东id查询报障列表
    List<Obstacle> selectObstacleListByLandlordId(Map<String,Object> applyMap);

    //根据租客id查询报障列表总数
    Integer selectObstacleListByTenantIdCount(Map<String,Object> applyMap);

    //根据房东id查询报障列表总数
    Integer selectObstacleListByLandlordIdCount(Map<String,Object> applyMap);

    //修改报障信息
    void updateObstacle(Obstacle obstacle);

    //删除报障
    void deleteObstacle(Integer rent_id);
}
