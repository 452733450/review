package com.jack.review.wordWaterMark;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/01/07/16:23
 */
@Slf4j
@Component
public class WaterMarkUtil {

    public final static String WORD = "word";
    public final static String PDF = "pdf";
    public final static String DOC_SUFFIX = ".doc";
    public final static String PDF_SUFFIX = ".pdf";
    private static int interval = -5;

    @Autowired
    private TemplateEngine templateEngine;

    /**
     * @param fileName         导出文件名称
     * @param list             每个产品要素详情list(map),用于填充模板的数据
     * @param exportFileFormat 导出文件格式（1：word，2：pdf，3：word及pdf）
     * @param dimensionality   导出维度（1：产品维度， 2：文件类型维度）
     * @param response         response
     */
    public void zipFileAfterWaterMark(String fileName, List<HashMap<String, Object>> list, Integer exportFileFormat, Integer dimensionality, String waterMark, HttpServletResponse response) {
        try {
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment; filename*=utf-8''" + URLEncoder.encode(fileName + ".zip", "UTF-8"));
            ZipOutputStream zipOut = new ZipOutputStream(response.getOutputStream());
            //如果是文件夹的话
            String folderName = fileName + "/";
            zipOut.putNextEntry(new ZipEntry(folderName));
            zipOut.closeEntry();
            if (!CollectionUtils.isEmpty(list)) {
                // 获取破解码
                WordWatermarkUtil.getLicense();
                Template template = null;
                if (!ExportFileFormatEnum.PDF.getCodeValue().equals(exportFileFormat)) {
                    template = this.getWordTemplate();
                }

                for (HashMap<String, Object> map : list) {
                    String productFullName = (String) map.get("productFullName");
                    if (ExportFileFormatEnum.WORD.getCodeValue().equals(exportFileFormat)) {
                        assert template != null;
                        Document document = exportWord(template, map, waterMark);
                        // 导出word
                        dimensionality = null;
                        save(folderName, document, SaveFormat.DOC, DOC_SUFFIX, productFullName, dimensionality, zipOut);
                    }
                    if (ExportFileFormatEnum.PDF.getCodeValue().equals(exportFileFormat)) {
                        // 导出pdf
                        dimensionality = null;
                        /*save(folderName, document, SaveFormat.PDF, PDF_SUFFIX, productFullName, dimensionality, zipOut);*/
                        String name = getFileName(dimensionality, folderName, productFullName, PDF_SUFFIX);
                        exportPdf(map, name, zipOut, waterMark);
                    }
                    if (ExportFileFormatEnum.WORD_AND_PDF.getCodeValue().equals(exportFileFormat)) {
                        // 导出word及pdf
                        assert template != null;
                        Document document = exportWord(template, map, waterMark);
                        save(folderName, document, SaveFormat.DOC, DOC_SUFFIX, productFullName, dimensionality, zipOut);
                        /*save(folderName, document, SaveFormat.PDF, PDF_SUFFIX, productFullName, dimensionality, zipOut);*/
                        exportPdf(map, getFileName(dimensionality, folderName, productFullName, PDF_SUFFIX), zipOut, waterMark);
                    }
                    /*in.close();*/
                }
            }
            response.flushBuffer();
            zipOut.close();
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    private static void save(String folderName, Document document, Integer saveFormat, String suffix, String productFullName, Integer dimensionality, ZipOutputStream zipOut) {
        try {
            ByteArrayOutputStream dstStream = new ByteArrayOutputStream();
            // 保存
            document.save(dstStream, saveFormat);

            byte[] dataBytes = dstStream.toByteArray();
            ByteArrayInputStream byteStream = new ByteArrayInputStream(dataBytes);

            // 输入流
            String name = getFileName(dimensionality, folderName, productFullName, suffix);
            addToZip(name, zipOut, byteStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ByteArrayInputStream htmlToPdf(String template, Map<String, Object> map) {
        ITextRenderer renderer = new ITextRenderer();
        ITextFontResolver fontResolver = renderer.getFontResolver();
        ByteArrayInputStream inputStream = null;
        try {
            Context context = new Context();
            context.setVariables(map);
            String htmlcontext = templateEngine.process(template, context);
            //设置字体，否则不支持中文,在html中使用字体，html{ font-family: SimSun;}
            fontResolver.addFont("static/font/simsun.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            renderer.setDocumentFromString(htmlcontext);
            renderer.layout();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            renderer.createPDF(outputStream);
            inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputStream;
    }

    public void waterMark(InputStream inputStream, ByteArrayOutputStream outputStream, String waterMarkName) {
        try {
            PdfReader reader = new PdfReader(inputStream);
            PdfStamper stamper = new PdfStamper(reader, outputStream);
            /*BaseFont base = BaseFont.createFont("SimSun","UTF-8",BaseFont.EMBEDDED);*/
            BaseFont base = BaseFont.createFont("static/font/simsun.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            com.itextpdf.text.Rectangle pageRect = null;
            PdfGState gs = new PdfGState();
            gs.setFillOpacity(0.3f);
            gs.setStrokeOpacity(0.4f);
            int total = reader.getNumberOfPages() + 1;

            JLabel label = new JLabel();
            FontMetrics metrics;
            int textH = 0;
            int textW = 0;
            label.setText(waterMarkName);
            metrics = label.getFontMetrics(label.getFont());
            textH = metrics.getHeight();
            textW = metrics.stringWidth(label.getText());

            PdfContentByte under;
            for (int i = 1; i < total; i++) {
                pageRect = reader.getPageSizeWithRotation(i);
                under = stamper.getOverContent(i);
                under.saveState();
                under.setGState(gs);
                under.beginText();
                under.setFontAndSize(base, 20);
                under.setRGBColorFill(145, 145, 145);

                // 水印文字成30度角倾斜
                //你可以随心所欲的改你自己想要的角度
                for (int height = interval + textH; height < pageRect.getHeight();
                     height = height + textH * 3) {
                    for (int width = interval + textW; width < pageRect.getWidth() + textW;
                         width = width + textW * 2) {
                        under.showTextAligned(Element.ALIGN_LEFT
                                , waterMarkName, width - textW,
                                height - textH, 30);
                    }
                }
                // 添加水印文字
                under.endText();
            }
            stamper.close();
            reader.close();


        } catch (Exception e) {
            // TODO: handle exception
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    private static void addToZip(String name, ZipOutputStream zipOut, ByteArrayInputStream byteStream) throws IOException {
        assert name != null;
        zipOut.putNextEntry(new ZipEntry(name));
        byte[] bytes = new byte[1024];
        int len;
        while ((len = byteStream.read(bytes)) != -1) {
            zipOut.write(bytes, 0, len);
        }
        byteStream.close();
        zipOut.closeEntry();
    }

    private void exportPdf(HashMap<String, Object> map, String name, ZipOutputStream zipOut, String waterMark) throws IOException {
        ByteArrayInputStream in = htmlToPdf("产品要素表2", map);

        if(StringUtils.isNotBlank(waterMark)) {
            ByteArrayOutputStream dstStream = new ByteArrayOutputStream();
            // 加水印
            waterMark(in, dstStream, waterMark);

            byte[] dataBytes = dstStream.toByteArray();
            ByteArrayInputStream byteStream = new ByteArrayInputStream(dataBytes);

            addToZip(name, zipOut, byteStream);
        } else {
            addToZip(name, zipOut, in);
        }
    }


    private Template getWordTemplate() throws IOException {
        /*Configuration configuration = new Configuration(new Version("2.3.0"));*/
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_25);
        configuration.setDefaultEncoding("utf-8");
        configuration.setClassForTemplateLoading(WaterMarkUtil.class, "/ftl/");
        // 获取模板文件
        return configuration.getTemplate("产品要素表.ftl", "utf-8");
    }

    private Document exportWord(Template template, HashMap<String, Object> map, String waterMark) throws Exception {

        // 根据模板填充数据后生成文件
        StringWriter sWriter = new StringWriter();
        template.process(map, sWriter);
        ByteArrayInputStream in = new ByteArrayInputStream(sWriter.toString().getBytes(StandardCharsets.UTF_8));

        // 加水印
        Document document = new Document(in);
        if(StringUtils.isNotBlank(waterMark)) {
            WordWatermarkUtil.WaterMarkMore(document, waterMark);
        }

        in.close();
        return document;
    }

    private static String getFileName(Integer dimensionality, String folderName, String productFullName, String suffix) {
        String name = null;
        if (dimensionality == null) {
            // 单独导出word或pdf
            name = folderName + productFullName + suffix;
        }
        if (DimensionalityEnum.PRODUCT.getCodeValue().equals(dimensionality)) {
            // 按产品维度导出
            name = folderName + productFullName + "/" + productFullName + suffix;
        }
        if (DimensionalityEnum.FILE_TYPE.getCodeValue().equals(dimensionality)) {
            // 按文件类型导出
            if (DOC_SUFFIX.equals(suffix)) {
                name = folderName + WORD + "/" + productFullName + suffix;
            }
            if (PDF_SUFFIX.equals(suffix)) {
                name = folderName + PDF + "/" + productFullName + suffix;
            }
        }
        return name;
    }
}


