package com.rentalhousing.service.impl;

import com.rentalhousing.mapper.LandlordMapper;
import com.rentalhousing.pojo.Landlord;
import com.rentalhousing.service.LandlordService;
import com.rentalhousing.utils.ResUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: 赵博林
 * @Date:2020/4/14 1:42
 * @Description:
 * @Param：
 * @return ：
 */
@Service("LandlordService")
public class LandlordServiceImpl implements LandlordService {

    @Autowired
    private LandlordMapper landlordMapper;

    //根据id查询房东
    @Override
    public Map<String, Object> selectById(Integer landlord_id) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(landlord_id) || Objects.equals("", landlord_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                Landlord landlord = landlordMapper.selectById(landlord_id);
                map.put("landlord",landlord);
            } catch (Exception e) {
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }
}
