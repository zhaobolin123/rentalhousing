package com.rentalhousing.service.impl;

import com.rentalhousing.mapper.ApplyMapper;
import com.rentalhousing.po.Apply;
import com.rentalhousing.service.ApplyService;
import com.rentalhousing.utils.ResUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
@Service("ApplyService")
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    private ApplyMapper applyMapper;

    //根据id查询申请
    @Override
        public Map<String, Object> selectApplyById(Integer apply_id) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(apply_id) || Objects.equals("", apply_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                Apply apply = applyMapper.selectApplyById(apply_id);
                map.put("apply",apply);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //新建申请
    @Override
    public Map<String, Object> AddApply(Apply apply) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(apply.getTenant_id()) || Objects.equals("", apply.getTenant_id())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else if (StringUtils.isEmpty(apply.getHousingresources_id()) || Objects.equals("", apply.getHousingresources_id())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String nowdayTime = dateFormat.format(new Date());
                Date nowDate = dateFormat.parse(nowdayTime);
                apply.setApply_time(nowDate);

                applyMapper.AddApply(apply);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //根据租客id查询申请列表
        @Override
        public Map<String, Object> selectApplyListByTenantId(Integer tenant_id,Integer apply_type,Integer apply_state,Integer currIndex, Integer pageSize) throws Exception {
            Map<String,Object> map = new HashMap<>();
            List<Apply> applyList = new ArrayList<Apply>();
            Map<String,Object> applyMap = new HashMap<>();
            applyMap.put("tenant_id",tenant_id);
            applyMap.put("apply_type",apply_type);
            applyMap.put("apply_state",apply_state);
            applyMap.put("currIndex",(currIndex-1)*pageSize);
            applyMap.put("pageSize",pageSize);

            if (StringUtils.isEmpty(tenant_id) || Objects.equals("",tenant_id)) {
                return ResUtil.error(map,"001","传入参数不能为空!");
            }
            else{
                try {
                    applyList = applyMapper.selectApplyListByTenantId(applyMap);
                    Integer count = applyMapper.selectApplyListByTenantIdCount(applyMap);
                    map.put("count",count);
                    map.put("applyList",applyList);
                } catch (Exception e) {
                    e.printStackTrace();
                    return ResUtil.error(map,"005","异常,请联系管理员！");
                }
            }
            return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //根据房东id查询申请列表
    @Override
    public Map<String, Object> selectApplyListByLandlordId(Integer landlord_id,Integer apply_type,Integer apply_state,Integer currIndex, Integer pageSize) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<Apply> applyList = new ArrayList<Apply>();
        Map<String,Object> applyMap = new HashMap<>();
        applyMap.put("landlord_id",landlord_id);
        applyMap.put("apply_type",apply_type);
        applyMap.put("apply_state",apply_state);
        applyMap.put("currIndex",(currIndex-1)*pageSize);
        applyMap.put("pageSize",pageSize);

        if (StringUtils.isEmpty(landlord_id) || Objects.equals("",landlord_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                applyList = applyMapper.selectApplyListByLandlordId(applyMap);
                Integer count = applyMapper.selectApplyListByLandlordIdCount(applyMap);
                map.put("count",count);
                map.put("applyList",applyList);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //修改申请信息
    @Override
    public Map<String, Object> updateApply(Apply apply) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(apply.getApply_id()) || Objects.equals("",apply.getApply_id())) {
            return ResUtil.error(map,"001","传入id不能为空!");
        }
        else{
            try {
                applyMapper.updateApply(apply);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }
}
