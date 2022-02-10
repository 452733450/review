package com.jack.review.test.easyExcel;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/07/15/15:01
 */
public class exportMap {
    /*private void exportMap(HttpServletResponse response, Map<String, List<ShareRecordExportDTO>> map) throws IOException {
        ResponseUtil.setMultipartHeader(response,ShareRecordExportDTO.FILE_NAME);

        ZipOutputStream zipOutputStream = new ZipOutputStream(response.getOutputStream());
        if (CollectionUtils.isEmpty(map.keySet())) {
            throw new ServiceException("当前没有数据，无法下载！");
        }
        try {
            for (Map.Entry<String, List<ShareRecordExportDTO>> entry : map.entrySet()) {
                ExcelWriter excelWriter = EasyExcel.write().excelType(ExcelTypeEnum.XLS)
                        .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                        .registerWriteHandler(HorizontalCellStyleStrategyFactory.exportStyleStrategy())
                        .registerConverter(new DateConverter())
                        .useDefaultStyle(false)
                        .build();
                WriteSheet sheet = EasyExcel.writerSheet(ShareRecordExportDTO.FILE_NAME).build();
                //构建excel表头信息
                WriteTable writeTable0 = EasyExcel.writerTable(0).head(ShareRecordExportDTO.class).needHead(Boolean.TRUE).build();
                //将表头和数据写入表格
                excelWriter.write(entry.getValue(), sheet, writeTable0);

                //创建压缩文件
                ZipEntry zipEntry = new ZipEntry(entry.getKey() + "-" + ShareRecordExportDTO.FILE_NAME + "-" + DateUtils.format(new Date(), DateUtils.DATE_FORMAT_14)  + ExcelTypeEnum.XLS.getValue());
                zipOutputStream.putNextEntry(zipEntry);
                Workbook workbook = excelWriter.writeContext().writeWorkbookHolder().getWorkbook();
                //将excel对象以流的形式写入压缩流
                workbook.write(zipOutputStream);
            }
            zipOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("份额信息导出失败：{}", e.getMessage());
            throw new ServiceException("份额导出异常");
        } finally {
            //关闭数据流，注意关闭的顺序
            zipOutputStream.close();
            response.getOutputStream().close();
        }
    }*/
}
