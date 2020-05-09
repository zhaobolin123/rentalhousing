package com.rentalhousing.controller;

import com.rentalhousing.po.Apply;
import com.rentalhousing.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 赵博林
 * @Date:2020/4/14 1:50
 * @Description:
 * @Param：
 * @return ：
 */
@Controller
public class ApplyController {
    @Autowired
    private ApplyService applyService;

    //根据id查询申请
    @RequestMapping(value = "selectApplyById",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectApplyById(Integer apply_id) throws Exception{
    Map<String,Object> map = applyService.selectApplyById(apply_id);
    return map;
    }

    //新建申请
    @RequestMapping(value = "AddApply",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> AddApply(Apply apply) throws Exception{
        Map<String,Object> map = applyService.AddApply(apply);
        return map;
    }

    //根据租客id查询申请列表
    @RequestMapping(value = "selectApplyListByTenantId",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectApplyListByTenantId(Integer tenant_id,Integer currIndex, Integer pageSize) throws Exception{
        Map<String,Object> map = applyService.selectApplyListByTenantId(tenant_id,currIndex,pageSize);
        return map;
    }

    //根据申请类型查询申请列表
    @RequestMapping(value = "selectApplyListByType",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectApplyListByType(Integer apply_type,Integer currIndex, Integer pageSize) throws Exception{
        Map<String,Object> map = applyService.selectApplyListByType(apply_type,currIndex,pageSize);
        return map;
    }

    //根据房东id查询申请列表
    @RequestMapping(value = "selectApplyListByLandlordId",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectApplyListByLandlordId(Integer landlord_id,Integer currIndex, Integer pageSize) throws Exception{
        Map<String,Object> map = applyService.selectApplyListByLandlordId(landlord_id,currIndex,pageSize);
        return map;
    }

    //修改申请信息
    @RequestMapping(value = "updateApply",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateApply(Apply apply) throws Exception{
        Map<String,Object> map = applyService.updateApply(apply);
        return map;
    }
}
