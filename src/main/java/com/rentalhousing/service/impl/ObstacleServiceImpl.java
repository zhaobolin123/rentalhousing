package com.rentalhousing.service.impl;

import com.rentalhousing.mapper.HousingresourcesMapper;
import com.rentalhousing.mapper.LandlordMapper;
import com.rentalhousing.mapper.ObstacleMapper;
import com.rentalhousing.mapper.TenantMapper;
import com.rentalhousing.po.Housingresources;
import com.rentalhousing.po.Landlord;
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
    @Autowired
    private HousingresourcesMapper housingresourcesMapper;
    @Autowired
    private LandlordMapper landlordMapper;
    @Autowired
    private TenantMapper tenantMapper;

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
                long nowDate = System.currentTimeMillis();
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
        public Map<String, Object> selectObstacleListByTenantId(Integer tenant_id,Integer currIndex, Integer pageSize) throws Exception {
            Map<String,Object> map = new HashMap<>();
            List<Obstacle> obstacleList = new ArrayList<Obstacle>();
            Map<String,Object> applyMap = new HashMap<>();
            ArrayList obstacleInfoList = new ArrayList<>();
            applyMap.put("tenant_id",tenant_id);
            applyMap.put("currIndex",(currIndex-1)*pageSize);
            applyMap.put("pageSize",pageSize);

            if (StringUtils.isEmpty(tenant_id) || Objects.equals("",tenant_id)) {
                return ResUtil.error(map,"001","传入参数不能为空!");
            }
            else{
                try {
                    obstacleList = obstacleMapper.selectObstacleListByTenantId(applyMap);
                    Integer count = obstacleMapper.selectObstacleListByTenantIdCount(applyMap);
                    if(obstacleList != null) {
                        for (Obstacle obstacle : obstacleList) {
                            Map<String,Object> obstacleInfoMap = new HashMap<>();
                            obstacleInfoMap.clear();
                            obstacleInfoMap.put("obstacle", obstacle);
                            Tenant tenant = tenantMapper.selectTenantById(tenant_id);
                            obstacleInfoMap.put("tenant", tenant);
                            Housingresources housingresources = housingresourcesMapper.selectHousingresourcesById(obstacle.getHousingresources_id());
                            obstacleInfoMap.put("housingresources", housingresources);
                            Landlord landlord = landlordMapper.selectById(housingresources.getLandlord_id());
                            obstacleInfoMap.put("landlord", landlord);
                            obstacleInfoList.add(obstacleInfoMap);
                        }
                    }
                    map.put("count",count);
                    map.put("obstacleInfoList",obstacleInfoList);
                } catch (Exception e) {
                    e.printStackTrace();
                    return ResUtil.error(map,"005","异常,请联系管理员！");
                }
            }
            return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //根据房东id查询报障列表
    @Override
    public Map<String, Object> selectObstacleListByLandlordId(Integer landlord_id,Integer obstacle_state,Integer currIndex, Integer pageSize) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<Obstacle> obstacleList = new ArrayList<Obstacle>();
        Map<String,Object> applyMap = new HashMap<>();
        ArrayList obstacleInfoList = new ArrayList<>();
        applyMap.put("landlord_id",landlord_id);
        applyMap.put("obstacle_state",obstacle_state);
        applyMap.put("currIndex",(currIndex-1)*pageSize);
        applyMap.put("pageSize",pageSize);

        if (StringUtils.isEmpty(landlord_id) || Objects.equals("",landlord_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else if(StringUtils.isEmpty(obstacle_state) || Objects.equals("",obstacle_state)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                obstacleList = obstacleMapper.selectObstacleListByLandlordId(applyMap);
                Integer count = obstacleMapper.selectObstacleListByLandlordIdCount(applyMap);
                if(obstacleList != null) {
                    for (Obstacle obstacle : obstacleList) {
                        Map<String,Object> obstacleInfoMap = new HashMap<>();
                        obstacleInfoMap.clear();
                        obstacleInfoMap.put("obstacle", obstacle);
                        Tenant tenant = tenantMapper.selectTenantById(obstacle.getTenant_id());
                        obstacleInfoMap.put("tenant", tenant);
                        Housingresources housingresources = housingresourcesMapper.selectHousingresourcesById(obstacle.getHousingresources_id());
                        obstacleInfoMap.put("housingresources", housingresources);
                        Landlord landlord = landlordMapper.selectById(landlord_id);
                        obstacleInfoMap.put("landlord", landlord);
                        obstacleInfoList.add(obstacleInfoMap);
                    }
                }
                map.put("count",count);
                map.put("obstacleInfoList",obstacleInfoList);
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
                        long nowDate = System.currentTimeMillis();
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
