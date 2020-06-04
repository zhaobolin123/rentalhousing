package com.rentalhousing.controller;

import com.rentalhousing.po.Obstacle;
import com.rentalhousing.po.Tenant;
import com.rentalhousing.service.ObstacleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author: 赵博林
 * @Date:2020/4/14 1:50
 * @Description:
 * @Param：
 * @return ：
 */
@Controller
public class ObstacleController {
    @Autowired
    private ObstacleService obstacleService;

    //根据id查询报障
    @RequestMapping(value = "selectObstacleById",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectObstacleById(Integer obstacle_id) throws Exception{
    Map<String,Object> map = obstacleService.selectObstacleById(obstacle_id);
    return map;
    }

    //新建报障
    @RequestMapping(value = "AddObstacle",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> AddObstacle(Obstacle obstacle) throws Exception{
        Map<String,Object> map = obstacleService.AddObstacle(obstacle);
        return map;
    }

    //根据租客id查询报障列表
    @RequestMapping(value = "selectObstacleListByTenantId",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectObstacleListByTenantId(Integer tenant_id,Integer currIndex, Integer pageSize) throws Exception{
        Map<String,Object> map = obstacleService.selectObstacleListByTenantId(tenant_id,currIndex,pageSize);
        return map;
    }

    //根据房东id查询报障列表
    @RequestMapping(value = "selectObstacleListByLandlordId",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectObstacleListByLandlordId(Integer landlord_id,Integer obstacle_state,Integer currIndex, Integer pageSize) throws Exception{
        Map<String,Object> map = obstacleService.selectObstacleListByLandlordId(landlord_id,obstacle_state,currIndex,pageSize);
        return map;
    }

    //修改报障信息
    @RequestMapping(value = "updateObstacle",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateObstacle(Obstacle obstacle) throws Exception{
        Map<String,Object> map = obstacleService.updateObstacle(obstacle);
        return map;
    }

    //删除报障
    @RequestMapping(value = "deleteObstacle",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> deleteObstacle(Integer obstacle_id) throws Exception{
        Map<String,Object> map = obstacleService.deleteObstacle(obstacle_id);
        return map;
    }
}
