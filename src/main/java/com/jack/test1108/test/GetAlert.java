package com.jack.test1108.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class GetAlert {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) {
        String json = "{“alertid”:”00000001”,”appcode”:”F-ACS”,”ip”:”192.168.1.1”,”alertdetail”:”交易出现异常”,”cause”:”接口访问异常”,”solution”:”重启应用服务器”,”zone”:”A园区”,”status”:”0”}";
        Alert alert = json2Obj(json, Alert.class);
        System.out.println(alert);
    }
    public Alert getAlert(String alert){
        //解析上游报警数据
        return json2Obj(alert, Alert.class);
    }

    public void process (String alert){
        //解析上游报警数据
        Alert entity = getAlert(alert);
        //查询维护部门
        List<Dept> deptList = getDeptList(entity.getAppCode());
        //补充Alert的维护部门字段
        //插入数据库Alert表，需要先delete再insert防止报警重复

    }

    private List<Dept> getDeptList(String appCode) {
        return null;
    }

    public static <T> T json2Obj(String jsonStr, Class<T> clazz) {
        if (StringUtils.isEmpty(jsonStr) || clazz == null) {
            return null;
        }

        try {
            return clazz.equals(String.class) ? (T) jsonStr : OBJECT_MAPPER.readValue(jsonStr, clazz);
        } catch (Exception e) {
            return null;
        }
    }
}
