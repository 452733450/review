package com.jack.normal;

import com.alibaba.fastjson.JSONObject;

/**
 * @Description:
 * @Author: Jack You
 * @Date: 2023/04/07/16:08
 */
public class Test20230407 {
    public static void main(String[] args) {
        String documentJsonObject = "{\"customerIsManager\":0,\"documentName\":\"基金合同\",\"originImgsPath\":\"https://vipdevtest.oss-cn-beijing.aliyuncs.com/63759043/productdocument/2023-04-07/63879402/\",\"originOldImgsPath\":\"https://vipdevtest.oss-cn-beijing.aliyuncs.com/63759043/productdocument/2023-04-07/63879131/\",\"originUrlPdf\":\"https://vipdevtest.oss-cn-beijing.aliyuncs.com/63759043/productdocument/2023-04-07/63879129_871102d610be4156b3b100226b52b57b.pdf\",\"pdfPageNums\":\"7\",\"signInfo\":[{\"height\":\"80\",\"investerType\":\"\",\"isFinishSeal\":0,\"pageNum\":\"1\",\"positionLeft\":70,\"positionTop\":478,\"signContent\":\"管理人公章\",\"signType\":\"1\",\"width\":\"80\"},{\"height\":\"80\",\"investerType\":\"1\",\"isFinishSeal\":0,\"pageNum\":\"1\",\"positionLeft\":406,\"positionTop\":485,\"signContent\":\"自然人投资者章\",\"signType\":\"3\",\"width\":\"80\"},{\"signType\":\"15\",\"positionTop\":842,\"positionLeft\":515,\"investerType\":\"1\",\"width\":80,\"height\":80,\"signContent\":\"经办人章\",\"pageNum\":1}],\"signUrlPdf\":\"https://vipdevtest.oss-cn-beijing.aliyuncs.com/63759043/templatefile/2023-04-07/63879114_b3af13882cbe41f8a325769f68c61c47.pdf\"}";
        DocumentJsonObject documentObject = JSONObject.parseObject(documentJsonObject, DocumentJsonObject.class);
        System.out.println(documentJsonObject);
    }
}
