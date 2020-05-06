package com.rentalhousing.service.impl;

import com.rentalhousing.mapper.ObstacleMapper;
import com.rentalhousing.po.Obstacle;
import com.rentalhousing.po.Tenant;
import com.rentalhousing.service.ObstacleService;
import com.rentalhousing.utils.ResUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: 赵博林
 * @Date:2020/4/14 1:42
 * @Description:
 * @Param：
 * @return ：
 */
@Service("ObstacleService")
public class ObstacleServiceImpl implements ObstacleService {

    @Autowired
    private ObstacleMapper obstacleMapper;

    //根据id查询报障
    @Override
        public Map<String, Object> selectObstacleById(Integer obstacle_id) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(obstacle_id) || Objects.equals("", obstacle_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                Obstacle obstacle = obstacleMapper.selectObstacleById(obstacle_id);
                map.put("obstacle",obstacle);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //新建报障
    @Override
    public Map<String, Object> AddObstacle(Obstacle obstacle) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(obstacle.getTenant_id()) || Objects.equals("", obstacle.getTenant_id())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else if (StringUtils.isEmpty(obstacle.getHousingresources_id()) || Objects.equals("", obstacle.getHousingresources_id())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String nowdayTime = dateFormat.format(new Date());
                Date nowDate = dateFormat.parse(nowdayTime);
                obstacle.setObstacle_time(nowDate);

                obstacleMapper.AddObstacle(obstacle);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //根据租客id查询报障列表
        @Override
        public Map<String, Object> selectObstacleListByTenantId(Integer tenant_id) throws Exception {
            Map<String,Object> map = new HashMap<>();
            List<Obstacle> obstacleList = new ArrayList<Obstacle>();

            if (StringUtils.isEmpty(tenant_id) || Objects.equals("",tenant_id)) {
                return ResUtil.error(map,"001","传入参数不能为空!");
            }
            else{
                try {
                    obstacleList = obstacleMapper.selectObstacleListByTenantId(tenant_id);
                    map.put("obstacleList",obstacleList);
                } catch (Exception e) {
                    e.printStackTrace();
                    return ResUtil.error(map,"005","异常,请联系管理员！");
                }
            }
            return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //根据房东id查询报障列表
    @Override
    public Map<String, Object> selectObstacleListByLandlordId(Integer landlord_id) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<Obstacle> obstacleList = new ArrayList<Obstacle>();

        if (StringUtils.isEmpty(landlord_id) || Objects.equals("",landlord_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                obstacleList = obstacleMapper.selectObstacleListByLandlordId(landlord_id);
                map.put("obstacleList",obstacleList);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //修改报障信息
    @Override
    public Map<String, Object> updateObstacle(Obstacle obstacle) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(obstacle.getObstacle_id()) || Objects.equals("",obstacle.getObstacle_id())) {
            return ResUtil.error(map,"001","传入id不能为空!");
        }
        else{
            try {
                if (StringUtils.isEmpty(obstacle.getObstacle_state()) || Objects.equals("",obstacle.getObstacle_state())){
                }
                else{
                    if(2 == obstacle.getObstacle_state()){
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String nowdayTime = dateFormat.format(new Date());
                        Date nowDate = dateFormat.parse(nowdayTime);
                        obstacle.setObstacle_completiontime(nowDate);
                    }
                }
                obstacleMapper.updateObstacle(obstacle);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }
}