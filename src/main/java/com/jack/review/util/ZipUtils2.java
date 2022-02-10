package com.jack.review.util;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/07/23/9:54
 */
public class ZipUtils2 {
    /*public void zipMultipleFiles(Map<String, List<File>> files, HttpServletResponse response) {
        String downloadFilename = new SimpleDateFormat().format(new Date());
        ZipOutputStream zos = null;
        InputStream in = null;
        List<String> fileNameList = new ArrayList<>();
        try {
            response.setContentType("application/octet-stream");// 指明response的返回对象是文件流
            response.setHeader("Content-Disposition", "attachment;filename=" + downloadFilename);// 设置在下载框默认显示的文件名
            downloadFilename = URLEncoder.encode(downloadFilename, "UTF-8");
            zos = new ZipOutputStream(response.getOutputStream());
            for (Map.Entry<String, List<File>> entry : files.entrySet()) {
                System.out.println(entry.getKey());
                if (EmptyUtil.isNotEmpty(entry.getValue())) {
                    for (File file : entry.getValue()) {
                        zos.putNextEntry(new ZipEntry(
                                entry.getKey() + File.separator + file.getName()));
                        in = new FileInputStream(FileUtil.getFilePath(file.getFileName()));
                        byte[] buffer = new byte[1024];
                        int r = 0;
                        while ((r = in.read(buffer)) != -1) {
                            zos.write(buffer, 0, r);
                        }
                        in.close();
                    }
                    zos.flush();
                }
            }
        } catch (Exception e) {
            logger.error("zipFiles error!!", e);
        } finally {
            if (EmptyUtil.isNotEmpty(zos)) {
                try {
                    zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    zos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (EmptyUtil.isNotEmpty(in)) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/
}
