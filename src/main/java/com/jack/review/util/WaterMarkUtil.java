//package com.jack.review.util;
//
//import com.aspose.words.Document;
//import com.aspose.words.SaveFormat;
//import freemarker.template.Configuration;
//import freemarker.template.Template;
//import freemarker.template.Version;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.collections4.CollectionUtils;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.StringWriter;
//import java.net.URLEncoder;
//import java.nio.charset.StandardCharsets;
//import java.util.HashMap;
//import java.util.List;
//import java.util.UUID;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipOutputStream;
//
///**
// * @Description:
// * @Auther: Jack You
// * @Date: 2022/01/07/16:23
// */
//@Slf4j
//public class WaterMarkUtil {
//
//    /**
//     * @param fileName         导出文件名称
//     * @param list             每个产品要素详情list(map),用于填充模板的数据
//     * @param exportFileFormat 导出文件格式（1：word，2：pdf，3：word及pdf）
//     * @param dimensionality   导出维度
//     * @param response         导出维度（1：产品维度， 2：文件类型维度）
//     */
//    public static void zipFileAfterWaterMark(String fileName, List<HashMap<String, Object>> list, Integer exportFileFormat, Integer dimensionality, HttpServletResponse response) {
//        try {
//            response.setContentType("application/octet-stream");
//            response.setHeader("Content-disposition", "attachment; filename*=utf-8''" + URLEncoder.encode(fileName + ".zip", "UTF-8"));
//            ZipOutputStream zipOut = new ZipOutputStream(response.getOutputStream());
//            //如果是文件夹的话
//            String folderName = fileName + "/";
//            zipOut.putNextEntry(new ZipEntry(folderName));
//            zipOut.closeEntry();
//            if (!CollectionUtils.isEmpty(list)) {
//                for (HashMap<String, Object> map : list) {
//                    Configuration configuration = new Configuration(new Version("2.3.0"));
//                    configuration.setDefaultEncoding("utf-8");
//                    configuration.setClassForTemplateLoading(com.meix.eom.utils.WaterMarkUtil.class, "/excel/");
//
//                    // 获取模板文件
//                    Template template = configuration.getTemplate("产品要素表.ftl", "utf-8");
//
//                    // 根据模板填充数据后生成文件
//                    StringWriter swriter = new StringWriter();
//
//                    template.process(map, swriter);
//
//                    ByteArrayInputStream in = new ByteArrayInputStream(swriter.toString().getBytes(StandardCharsets.UTF_8));
//
//                    // 加水印
//                    WordWatermarkUtil.getLicense();
//                    Document document;
//
//                    document = new Document(in);
//                    WordWatermarkUtil.WaterMarkMore(document, "我的水印");
//
//                    ByteArrayOutputStream dstStream = new ByteArrayOutputStream();
//                    /*document.save(dstStream, SaveFormat.PDF);*/
//                    document.save(dstStream, SaveFormat.DOC);
//                    byte[] dataBytes = dstStream.toByteArray();
//                    ByteArrayInputStream byteStream = new ByteArrayInputStream(dataBytes);
//
//                    /*document.save(response.getOutputStream(), SaveFormat.PDF);*/
//
//                    /*document.save("C:\\Users\\ypp\\Desktop\\file\\运营\\1月\\水印.pdf");
//                    File file = new File("C:/Users/ypp/Desktop/file/运营/1月/水印.pdf");
//                    InputStream input = new FileInputStream(file);*/
//
//                    // 输入流
//                    /*String name = folderName + "ypp" + "/" + UUID.randomUUID() + ".pdf";*/
//                    String name = folderName + "ypp" + "/" + UUID.randomUUID() + ".doc";
//                    zipOut.putNextEntry(new ZipEntry(name));
//                    byte[] bytes = new byte[1024];
//                    int len;
//                    while ((len = byteStream.read(bytes)) != -1) {
//                        zipOut.write(bytes, 0, len);
//                    }
//                    in.close();
//                    byteStream.close();
//                    zipOut.closeEntry();
//                }
//            }
//            response.flushBuffer();
//            zipOut.close();
//        } catch (Exception e) {
//            log.error(e.getMessage());
//            e.printStackTrace();
//        }
//    }
//}
