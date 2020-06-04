package com.rentalhousing.mapper;

import com.rentalhousing.po.Contract;
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
public interface ContractMapper {

    //根据id查询合同
    Contract selectContractById(Integer contract_id);

    //新建合同
    void AddContract(Contract contract);

    //根据房东id查询合同列表
    List<Contract> selectContractListByLandlordId(Map<String, Object> applyMap);

    //根据房东id查询合同列表总数
    Integer selectContractListByLandlordIdCount(Map<String, Object> applyMap);

    //修改合同信息
    void updateContract(Contract contract);

    //删除合同
    void deleteContract(Integer contract_id);

}
