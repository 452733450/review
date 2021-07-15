package com.jack.review.util;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import com.alibaba.excel.util.DateUtils;

public class ResponseUtil {

    public static void setMultipartHeader(HttpServletResponse response, String fileName)    {
        /*try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;filename*=UTF-8''" + URLEncoder.encode(fileName, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new ServiceException("文件名编码异常");
        }*/


        //文件名编码设置，防止中文乱码
        /*try {
            fileName = URLEncoder.encode(fileName,"UTF-8")*//*.replaceAll("\\+", "%20")*//*;
        } catch (Exception e){
            //抛出异常
            System.out.println(e.getMessage());
        }
        //设置文件类型，编码和文件名
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-disposition", "attachment;filename="+fileName);
        response.setContentType("application/octet-stream");*/


        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");

        String exportFileName = null;
        try {
            exportFileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + exportFileName + "-" + DateUtils.format(new Date(), DateUtils.DATE_FORMAT_14) + ".zip");
    }
}
