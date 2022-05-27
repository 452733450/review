//package com.jack.review.wordWaterMark;
//
//
//import com.aspose.words.*;
//import com.aspose.words.Shape;
//
//import java.awt.*;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Objects;
//
//public class WordWatermarkUtil {
//
//    public static void main(String[] args) {
//        try {
//            getLicense();
//            Document document = new Document("C:\\Users\\ypp\\Desktop\\file\\运营\\1月\\导出.doc");
//            WordWatermarkUtil.WaterMarkMore(document,"我的水印");
//            //文件输出路径
//            document.save("C:\\Users\\ypp\\Desktop\\file\\运营\\1月\\水印.doc");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 为word文档添加水印
//     * @param doc word文档模型
//     * @param watermarkText 需要添加的水印字段
//     * @throws Exception
//     */
//    public static void insertWatermarkText(Document doc, String watermarkText) throws Exception {
//        Shape watermark = new Shape(doc, ShapeType.TEXT_PLAIN_TEXT);
//        //水印内容
//        watermark.getTextPath().setText(watermarkText);
//        //水印字体
//        watermark.getTextPath().setFontFamily("宋体");
//        //水印宽度
//        watermark.setWidth(100);
//        //水印高度
//        watermark.setHeight(20);
//        //旋转水印
//        watermark.setRotation(-40);
//        //水印颜色 浅灰色
//        watermark.getFill().setColor(Color.lightGray);
//        watermark.setStrokeColor(Color.lightGray);
//        //设置相对水平位置
//        watermark.setRelativeHorizontalPosition(RelativeHorizontalPosition.PAGE);
//        //设置相对垂直位置
//        watermark.setRelativeVerticalPosition(RelativeVerticalPosition.PAGE);
//        //设置包装类型
//        watermark.setWrapType(WrapType.NONE);
//        //设置垂直对齐
//        watermark.setVerticalAlignment(VerticalAlignment.CENTER);
//        //设置文本水平对齐方式
//        watermark.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        Paragraph watermarkPara = new Paragraph(doc);
//        watermarkPara.appendChild(watermark);
//        for (Section sect : doc.getSections())
//        {
//            insertWatermarkIntoHeader(watermarkPara, sect, HeaderFooterType.HEADER_PRIMARY);
//            insertWatermarkIntoHeader(watermarkPara, sect, HeaderFooterType.HEADER_FIRST);
//            insertWatermarkIntoHeader(watermarkPara, sect, HeaderFooterType.HEADER_EVEN);
//        }
//        System.out.println("Watermark Set");
//    }
//    /**
//     * 在页眉中插入水印
//     * @param watermarkPara
//     * @param sect
//     * @param headerType
//     * @throws Exception
//     */
//    private static void insertWatermarkIntoHeader(Paragraph watermarkPara, Section sect, int headerType) throws Exception {
//        HeaderFooter header = sect.getHeadersFooters().getByHeaderFooterType(headerType);
//        if (header == null)
//        {
//            header = new HeaderFooter(sect.getDocument(), headerType);
//            sect.getHeadersFooters().add(header);
//        }
//        header.appendChild(watermarkPara.deepClone(true));
//    }
//
//    /**
//     * 设置水印属性
//     * @param doc
//     * @param wmText
//     * @param left
//     * @param top
//     * @return
//     * @throws Exception
//     */
//    public static Shape ShapeMore(Document doc, String wmText, double left, double top)throws Exception {
//        Shape waterShape = new Shape(doc, ShapeType.TEXT_PLAIN_TEXT);
//        //水印内容
//        waterShape.getTextPath().setText(wmText);
//        //水印字体
//        waterShape.getTextPath().setFontFamily("宋体");
//        //水印宽度
//        waterShape.setWidth(40);
//        //水印高度
//        waterShape.setHeight(13);
//        //旋转水印
//        waterShape.setRotation(-40);
//        //水印颜色 浅灰色
//        /*waterShape.getFill().setColor(Color.lightGray);
//        waterShape.setStrokeColor(Color.lightGray);*/
//        waterShape.setStrokeColor(new Color(210,210,210));
//        //将水印放置在页面中心
//        waterShape.setLeft(left);
//        waterShape.setTop(top);
//        //设置包装类型
//        waterShape.setWrapType(WrapType.NONE);
//        return waterShape;
//    }
//
//    /**
//     * 插入多个水印
//     * @param mdoc
//     * @param wmText
//     * @throws Exception
//     */
//    public static void WaterMarkMore(Document mdoc, String wmText)throws Exception {
//        Paragraph watermarkPara = new Paragraph(mdoc);
//        for (int j = 0; j < 500; j = j + 100)
//        {
//            for (int i = 0; i < 700; i = i + 85)
//            {
//                Shape waterShape = ShapeMore(mdoc, wmText, j, i);
//                watermarkPara.appendChild(waterShape);
//            }
//        }
//        for (Section sect : mdoc.getSections())
//        {
//            insertWatermarkIntoHeader(watermarkPara, sect, HeaderFooterType.HEADER_PRIMARY);
//            insertWatermarkIntoHeader(watermarkPara, sect, HeaderFooterType.HEADER_FIRST);
//            insertWatermarkIntoHeader(watermarkPara, sect, HeaderFooterType.HEADER_EVEN);
//        }
//    }
//
//    public static synchronized boolean getLicense() {
//        boolean result = false;
//        InputStream is = null;
//        try {
//            is = PdfUtil.class.getClassLoader().getResourceAsStream("license.xml");
//            License aposeLic = new License();
//            aposeLic.setLicense(is);
//            result = true;
//        } catch (Exception e) {
//            /*log.error("工具类aspose.words获取license失败");*/
//        } finally {
//            /*if (Objects.nonNull(is)) {
//                try {
//                    is.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }*/
//        }
//        return result;
//    }
//}
