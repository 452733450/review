package com.jack.normal;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @Description:
 * @Author: Jack You
 * @Date: 2023/02/20/11:05
 */
public class CustomizeFilter extends SimpleBeanPropertyFilter {

    public final Integer business;

    public CustomizeFilter(Integer business) {
        this.business = business;
    }

    @Override
    public void serializeAsField(Object pojo, JsonGenerator jgen,
                                 SerializerProvider provider, PropertyWriter writer)
            throws Exception {
        if (include(writer, pojo, business)) {
            writer.serializeAsField(pojo, jgen, provider);
        } else if (!jgen.canOmitFields()) { // since 2.3
            writer.serializeAsOmittedField(pojo, jgen, provider);
        }
    }

    protected boolean include(PropertyWriter writer, Object pojo, Integer business) throws Exception {
        /*Integer business = null;
        if (writer.getFullName().getSimpleName().equals("businessType")) {
            Field field = ReflectionUtils.findField(pojo.getClass(), "businessType");
            assert field != null;
            field.setAccessible(true);
            business = Integer.parseInt(Objects.requireNonNull(field).get(pojo).toString());
        }*/

        /*if(!trusteeFieldsSettingMapKeys.contains(fieldName)) {
            // 托管不支持的字段设置为展示
            Field field = ReflectionUtils.findField(pojo.getClass(), writer.getFullName().getSimpleName());
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(fieldTypeValue);
            assert field != null;
            field.setAccessible(true);
            Map memberValuesMap = (Map) field.get(invocationHandler);
            memberValuesMap.put("isSupport", 1);
            return false;
        }*/

        BusinessType businessTypeValue = writer.getAnnotation(BusinessType.class);
        if (Objects.equals(business, BusinessEnum.SUBSCRIBE.getCodeValue()) || Objects.equals(business, BusinessEnum.SUBSCRIBE_TO.getCodeValue())) {
            // 认购、申购移除赎回里的字段
            if (Objects.equals(businessTypeValue.businessType(), 3)) {
                return false;
            }
        } else {
            // 赎回移除里认购、申购的字段
            if (Objects.equals(businessTypeValue.businessType(), 1)) {
                return false;
            }
        }

        return super.include(writer);
    }

    private void test(){
        // 移除不在支持字段配置里的字段
        /*for (TrusteeOrderRsp trusteeOrderRsp : trusteeOrders) {
            Map<String, Object> trusteeOrderFieldsMap = JSON.parseObject(JSON.toJSONString(trusteeOrderRsp), TreeMap.class);
            trusteeOrderFieldsMap.entrySet().removeIf(entry -> !trusteeFieldsSettingMapKeys.contains(entry.getKey()));
            trusteeOrderFieldsMap.put(OrderFieldEnum.operatorName.getFieldName(), trusteeOrderRsp.getOperatorName());
            trusteeOrderFieldsMap.put(OrderFieldEnum.trusteeOrderId.getFieldName(), trusteeOrderRsp.getTrusteeOrderId());
            if (Objects.equals(trusteeOrderRsp.getOrderState(), YesOrNoEnum.YES.getCodeValue())) {
                trusteeOrderFieldsMap.put(OrderFieldEnum.pushState.getFieldName(), trusteeOrderRsp.getPushState());
                trusteeOrderFieldsMap.put(OrderFieldEnum.returnState.getFieldName(), trusteeOrderRsp.getReturnState());
            }
            TrusteeOrderRsp trusteeOrderEntity = JSON.parseObject(JSON.toJSONString(trusteeOrderFieldsMap), TrusteeOrderRsp.class);
            tmpList.add(trusteeOrderEntity);
        }*/
    }
}