package com.rentalhousing.controller;

import com.rentalhousing.po.Lease;
import com.rentalhousing.service.LeaseService;
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
public class LeaseController {
    @Autowired
    private LeaseService leaseService;

    //根据id查询租赁
    @RequestMapping(value = "selectLeaseById",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectLeaseById(Integer lease_id) throws Exception{
    Map<String,Object> map = leaseService.selectLeaseById(lease_id);
    return map;
    }

    //新建租赁
    @RequestMapping(value = "AddLease",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> AddLease(Lease lease) throws Exception{
        Map<String,Object> map = leaseService.AddLease(lease);
        return map;
    }

    //根据房东id查询租赁列表
    @RequestMapping(value = "selectLeaseListByLandlordId",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectLeaseListByLandlordId(Integer landlord_id,String lease_type, Integer currIndex, Integer pageSize) throws Exception{
        Map<String,Object> map = leaseService.selectLeaseListByLandlordId(landlord_id,lease_type,currIndex,pageSize);
        return map;
    }

    //根据租客id查询租赁列表
    @RequestMapping(value = "selectLeaseListByTenantId",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectLeaseListByTenantId(Lease lease) throws Exception{
        Map<String,Object> map = leaseService.selectLeaseListByTenantId(lease);
        return map;
    }

    //修改租赁信息
    @RequestMapping(value = "updateLease",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateLease(Lease lease) throws Exception{
        Map<String,Object> map = leaseService.updateLease(lease);
        return map;
    }

    //删除租赁
    @RequestMapping(value = "deleteLease",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> deleteLease(Integer lease_id) throws Exception{
        Map<String,Object> map = leaseService.deleteLease(lease_id);
        return map;
    }
}
