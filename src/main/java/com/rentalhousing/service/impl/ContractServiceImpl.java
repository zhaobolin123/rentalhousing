package com.rentalhousing.service.impl;

import com.rentalhousing.mapper.ContractMapper;
import com.rentalhousing.mapper.HousingresourcesMapper;
import com.rentalhousing.mapper.LandlordMapper;
import com.rentalhousing.mapper.TenantMapper;
import com.rentalhousing.po.Contract;
import com.rentalhousing.po.Housingresources;
import com.rentalhousing.po.Landlord;
import com.rentalhousing.po.Tenant;
import com.rentalhousing.service.ContractService;
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
@Service("ContractService")
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractMapper contractMapper;
    @Autowired
    private TenantMapper tenantMapper;
    @Autowired
    private LandlordMapper landlordMapper;
    @Autowired
    private HousingresourcesMapper housingresourcesMapper;

    //根据id查询合同
    @Override
        public Map<String, Object> selectContractById(Integer contract_id) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(contract_id) || Objects.equals("", contract_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                Contract contract = contractMapper.selectContractById(contract_id);
                map.put("contract",contract);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //新建合同
    @Override
    public Map<String, Object> AddContract(Contract contract) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(contract.getTenant_id()) || Objects.equals("", contract.getTenant_id())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else if (StringUtils.isEmpty(contract.getHousingresources_id()) || Objects.equals("", contract.getHousingresources_id())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else if (StringUtils.isEmpty(contract.getLandlord_id()) || Objects.equals("", contract.getLandlord_id())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                contractMapper.AddContract(contract);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //根据房东id查询合同列表
    @Override
    public Map<String, Object> selectContractListByLandlordId(Integer landlord_id,Integer currIndex, Integer pageSize) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<Contract> contractList = new ArrayList<Contract>();
        Map<String,Object> applyMap = new HashMap<>();
        ArrayList contractInfoList = new ArrayList<>();
        applyMap.put("currIndex",(currIndex-1)*pageSize);
        applyMap.put("pageSize",pageSize);
        applyMap.put("landlord_id",landlord_id);

        if (StringUtils.isEmpty(landlord_id) || Objects.equals("",landlord_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                contractList = contractMapper.selectContractListByLandlordId(applyMap);
                Integer count = contractMapper.selectContractListByLandlordIdCount(applyMap);
                if(contractList != null) {
                    for (Contract contract : contractList) {
                        Map<String,Object> contractInfoMap = new HashMap<>();
                        contractInfoMap.clear();
                        contractInfoMap.put("contract", contract);
                        Tenant tenant = tenantMapper.selectTenantById(contract.getTenant_id());
                        contractInfoMap.put("tenant", tenant);
                        Housingresources housingresources = housingresourcesMapper.selectHousingresourcesById(contract.getHousingresources_id());
                        contractInfoMap.put("housingresources", housingresources);
                        Landlord landlord = landlordMapper.selectById(contract.getLandlord_id());
                        contractInfoMap.put("landlord", landlord);
                        contractInfoList.add(contractInfoMap);
                    }
                }
                map.put("count",count);
                map.put("contractInfoList",contractInfoList);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //修改合同信息
    @Override
    public Map<String, Object> updateContract(Contract contract) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(contract.getContract_id()) || Objects.equals("",contract.getContract_id())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                contractMapper.updateContract(contract);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //删除合同
    @Override
    public Map<String, Object> deleteContract(Integer contract_id) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(contract_id) || Objects.equals("", contract_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                contractMapper.deleteContract(contract_id);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }
}
