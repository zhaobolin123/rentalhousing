package com.rentalhousing.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: liuwei
 * Date: 2019-07-05
 */
public class ResUtil {
    public static String CODE = "code"; //状态标识
    public static String ERROR = "error";
    public static String SUCCESS = "success";
    public static String AbnormalParam = "参数异常";
    public static String MSG = "msg";//描述信息
    public static String PARAM = "param";

    public static Map<String, Object> error() {
        Map<String, Object> map = new HashMap<>();
        map.put(CODE, ERROR);
        return map;
    }

    /**
     * @Athor lengdl
     * @param map  返回参数
     * @param code 返回code码
     * @param msg  返回参数所带的提示信息
     * @return
     */
    public static Map<String, Object> error(Map<String, Object> map,String code,String msg){

        map.put(CODE, code);

        map.put(MSG,msg);

        return map;
    }


    /**
     * @Athor lengdl
     * @param map  返回参数
     * @param code 返回code码
     * @return
     */
    public static Map<String, Object> error(Map<String, Object> map,String code){

        map.put(CODE, code);


        return map;
    }

    /**
     * @Athor lengdl
     * @param code 返回code码
     * @param msg  返回参数所带的提示信息
     * @return
     */
    public static Map<String, Object> error(String param,String code,String msg){

        Map<String,Object> map = new HashMap<>();

        map.put(PARAM,param);

        map.put(CODE, code);

        map.put(MSG,msg);

        return map;
    }

    /**
     * @create by: yuantao
     * @description:  结果返回
     * @create time:下午 3:48 2019/8/2 0002
     * @Param:  code 000 成功 001 判空失败 002 发生异常 003 第三方接口访问报错 004 解析JSON失败 005  reason 返回提示
     * @return:
     */
    public static Map<String,Object> error(String code,String msg) {

        Map<String,Object> map=new HashMap<>();

        map.put("code",code);

        map.put(MSG,msg);

        return map;
    }
}
