package com.rentalhousing.mapper;

import com.rentalhousing.po.Lease;
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
public interface LeaseMapper {

    //根据id查询租赁
    Lease selectLeaseById(Integer lease_id);

    //新建租赁
    void AddLease(Lease lease);

    //根据房东id查询租赁列表
    List<Lease> selectLeaseListByLandlordId(Map<String,Object> applyMap);

    //根据租客id查询租赁列表
    List<Lease> selectLeaseListByTenantId(Integer tenant_id);

    //根据房东id查询租赁列表总数
    Integer selectLeaseListByLandlordIdCount(Map<String,Object> applyMap);

    //根据租客id查询租赁列表总数
    Integer selectLeaseListByTenantIdCount(Integer tenant_id);

    //修改租赁信息
    void updateLease(Integer lease_id);

}
