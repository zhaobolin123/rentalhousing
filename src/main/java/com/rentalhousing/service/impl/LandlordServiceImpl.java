package com.rentalhousing.service.impl;

import com.rentalhousing.mapper.LandlordMapper;
import com.rentalhousing.po.Landlord;
import com.rentalhousing.service.LandlordService;
import com.rentalhousing.utils.ResUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    //注册
    @Override
    public Map<String, Object> registLandlord(Landlord landlord) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(landlord.getLandlord_phone()) || Objects.equals("", landlord.getLandlord_phone())) {
            return ResUtil.error(map,"001","手机号不能为空!");
        }
        else if (StringUtils.isEmpty(landlord.getLandlord_mail()) || Objects.equals("", landlord.getLandlord_mail())) {
            return ResUtil.error(map,"001","邮箱不能为空!");
        }
        else if (StringUtils.isEmpty(landlord.getLandlord_password()) || Objects.equals("", landlord.getLandlord_password())) {
            return ResUtil.error(map,"001","密码不能为空!");
        }
        else{
            try {
                if (0!=landlordMapper.isRegist(landlord.getLandlord_phone())){
                    return ResUtil.error(map,"002","手机号已被注册！");
                }
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String nowdayTime = dateFormat.format(new Date());
                Date nowDate = dateFormat.parse(nowdayTime);
                landlord.setLandlord_time(nowDate);

                landlordMapper.registLandlord(landlord);
            } catch (Exception e) {
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //登录
    @Override
    public Map<String, Object> loginLandlord(Landlord landlord) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(landlord.getLandlord_phone()) || Objects.equals("",landlord.getLandlord_phone())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else if (StringUtils.isEmpty(landlord.getLandlord_password()) || Objects.equals("",landlord.getLandlord_password())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                if(null== landlordMapper.loginLandlord(landlord)){
                    return ResUtil.error(map,"003","账号或密码错误！");
                }
                else{
                    Landlord landlord1 = landlordMapper.loginLandlord(landlord);
                    map.put("Landlord",landlord1);
                }
            } catch (Exception e) {
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //修改房东信息
    @Override
    @Transactional
    public Map<String, Object> updateLandlord(Landlord landlord) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(landlord.getLandlord_id()) || Objects.equals("",landlord.getLandlord_id())) {
            return ResUtil.error(map,"001","传入id不能为空!");
        }
        else{
            try {
                landlordMapper.updateLandlord(landlord);
                Landlord landlord1 = landlordMapper.selectById(landlord.getLandlord_id());
                map.put("Landlord",landlord1);
            } catch (Exception e) {
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }
}
