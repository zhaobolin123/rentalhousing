package com.rentalhousing.service;

import com.rentalhousing.po.Contract;

import java.util.Map;

/**
 * @Author: 赵博林
 * @Date:2020/4/14 1:42
 * @Description:
 * @Param：
 * @return ：
 */
public interface ContractService {

    //根据id查询合同
    Map<String,Object> selectContractById(Integer contract_id) throws Exception;

    //新建合同
    Map<String,Object> AddContract(Contract contract) throws Exception;

    //根据房东id查询合同列表
    Map<String,Object> selectContractListByLandlordId(Integer landlord_id, Integer currIndex, Integer pageSize) throws Exception;

    //修改合同信息
    Map<String,Object> updateContract(Contract contract) throws Exception;

    //删除合同
    Map<String,Object> deleteContract(Integer contract_id) throws Exception;
}
