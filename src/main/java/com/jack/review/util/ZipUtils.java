package com.jack.review.util;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/07/23/9:49
 */
public class ZipUtils {

    public static void test(HttpServletResponse response) {

        // 假装是一个单据集合
        List<String> imgUrls = new ArrayList<>();
        imgUrls.add("http://img1.imgtn.bdimg.com/it/u=2171717409,2602158110&fm=26&gp=0.jpg");
        imgUrls.add("http://images.ofweek.com/Upload/News/2016-5/Finn/53/20160503055505730.jpg");
        imgUrls.add("http://y1.ifengimg.com/a/2016_04/4855d9fcb2ccade.jpg");

        try {
            //zip包的名称
            String downloadFilename = "图片.zip";
            downloadFilename = URLEncoder.encode(downloadFilename, "UTF-8");
            // 指明response的返回对象是文件流
            response.setContentType("application/octet-stream");
            // 设置在下载框默认显示的文件名
            response.setHeader("Content-Disposition", "attachment;filename=" + downloadFilename);
            ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
            imgUrls.forEach(i -> {
                InputStream fis = null;
                try {
                    // 跨平台建文件夹和文件名字
                    // File.separator  根据操作系统来判断用什么文件分隔符
                    // 这里只建立了一个文件夹，如果想分类的话，在后面加上想要的文件夹名称即可
                    ZipEntry zipEntry = new ZipEntry("img_download" + File.separator + imgUrls.indexOf(i) + ".jpg");
                    // 放到压缩包里
                    zos.putNextEntry(zipEntry);
                    // 获得图片流
                    fis = getInputStreamByGet(i);
                    if (null != fis) {
                        byte[] buffer = new byte[1024];
                        int r = 0;
                        // 从输入流读取一定数量的字节，存到缓存区中
                        while ((r = fis.read(buffer)) != -1) {
                            zos.write(buffer, 0, r);
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            zos.flush();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 通过get请求得到读取器响应数据的数据流
     *
     * @param url
     * @return
     */
    private static InputStream getInputStreamByGet(String url) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return conn.getInputStream();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
