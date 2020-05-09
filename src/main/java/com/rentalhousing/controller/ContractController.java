package com.rentalhousing.controller;

import com.rentalhousing.po.Contract;
import com.rentalhousing.service.ContractService;
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
public class ContractController {
    @Autowired
    private ContractService contractService;

    //根据id查询合同
    @RequestMapping(value = "selectContractById",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectContractById(Integer contract_id) throws Exception{
    Map<String,Object> map = contractService.selectContractById(contract_id);
    return map;
    }

    //新建合同
    @RequestMapping(value = "AddContract",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> AddContract(Contract contract) throws Exception{
        Map<String,Object> map = contractService.AddContract(contract);
        return map;
    }

    //根据房东id查询合同列表
    @RequestMapping(value = "selectContractListByLandlordId",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectContractListByLandlordId(Integer landlord_id, Integer currIndex, Integer pageSize) throws Exception{
        Map<String,Object> map = contractService.selectContractListByLandlordId(landlord_id,currIndex,pageSize);
        return map;
    }

    //修改合同信息
    @RequestMapping(value = "updateContract",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateContract(Contract contract) throws Exception{
        Map<String,Object> map = contractService.updateContract(contract);
        return map;
    }
}
