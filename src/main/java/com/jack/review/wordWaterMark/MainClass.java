package com.jack.review.wordWaterMark;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/01/05/10:43
 */
public class MainClass {

    public static void main(String[] args) {
        // C:\Users\ypp\Desktop\file\运营\1月
        /*response.setContentType("application/json");
        response.setHeader("Content-disposition", "attachment; filename*=utf-8''" + URLEncoder.encode("导出.doc", "UTF-8"));
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            //编号
            map.put("productFullName", "宁泉致远");
            map.put("tableName",  "宁泉致远10号产品要素表");
            map.put("custodian", "管理人");
            map.put("investment", "托管人");
            // 托管人
            *//*Long trusteeshipCode = productDetail.getInvestment();
            if (trusteeshipCode != null) {
                TrusteeshipCompany trusteeshipCompany = trusteeshipCompanyService.getByTrusteeshipCode(trusteeshipCode);
                if (trusteeshipCompany != null) {
                    map.put("investment", trusteeshipCompany.getTrusteeshipName());
                }
            }*//*
            map.put("securitiesBroker", "证券经纪商");
            map.put("futuresDealer", "期货经纪商");

            // 是否分级
            map.put("fundLevel", "是");

            // 投资经理

            map.put("saleUserIds", "投资经理");

            // 认购起点
            map.put("personalBuyCondition", "认购起点");
            // 产品期限
            map.put("productDeadlineDescription", "产品期限");
            // 认购和申购
            map.put("subscribeDescription", "认购和申购");
            // 封闭期
            map.put("closurePeriodDescription", "封闭期");
            // 投资范围
            map.put("investRange", "投资范围");
            // 投资限制
            map.put("investmentRestriction", "投资限制");
            // 分红
            map.put("dividendDescription", "分红");
            // 认/申购费

            map.put("subscriptionfee", "认/申购费");
            // 管理费
            map.put("fixedFee", "管理费");
            // 托管费、运营服务费

            map.put("trusteeFee", "托管费、运营服务费");
            // 赎回费
            map.put("redeemfee", "赎回费");
            // 业绩报酬
            map.put("meritPay", "业绩报酬");

            //Configuration 用于读取ftl文件
            Configuration configuration = new Configuration(new Version("2.3.0"));
            configuration.setDefaultEncoding("utf-8");

            *//**
             * 以下是两种指定ftl文件所在目录路径的方式，注意这两种方式都是
             * 指定ftl文件所在目录的路径，而不是ftl文件的路径
             *//*
            //指定路径的第一种方式（根据某个类的相对路径指定）
            configuration.setClassForTemplateLoading(this.getClass(), "/excel/");
            *//*InputStream templateInputStream = this.getClass().getResourceAsStream("/excel/认申赎确认信息导入模板.xlsx");*//*

            //指定路径的第二种方式，我的路径是C：/a.ftl
            *//*configuration.setDirectoryForTemplateLoading(new File("C:/Users/ypp/Desktop/file/运营/1月/"));*//*

            //输出文档路径及名称
            *//*File outFile = new File("C:/Users/ypp/Desktop/file/运营/1月/导出.doc");*//*

            //以utf-8的编码读取ftl文件
            Template template = configuration.getTemplate("产品要素表.ftl", "utf-8");
            *//*Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), StandardCharsets.UTF_8), 10240);*//*

            StringWriter swriter = new StringWriter();
            //生成文件
            template.process(map, swriter);
            ByteArrayInputStream in =  new ByteArrayInputStream(swriter.toString().getBytes(StandardCharsets.UTF_8));
            WordWatermarkUtil.getLicense();
            Document document = new Document(in);
            WordWatermarkUtil.WaterMarkMore(document,"我的水印");

            document.save(response.getOutputStream(), SaveFormat.PDF);

            *//*document.save("C:\\Users\\ypp\\Desktop\\file\\运营\\1月\\水印.doc");*//*
            *//*Writer out = new BufferedWriter(new OutputStreamWriter(response.getOutputStream(), StandardCharsets.UTF_8), 10240);
            template.process(map, out);*//*
            *//*out.flush();
            out.close();*//*
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

}
