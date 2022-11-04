package com.jack.asset;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

/*import sun.misc.BASE64Encoder;*/


public class ImgToBase64 {


    public static void main(String[] args) throws Exception {
        String url = "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1422027133,3544289992&fm=26&gp=0.jpg";
        String a = getBase64ByUrl(url);
        System.out.println(a);
    }

    /**
     * 根据图片链接转为base64数据
     *
     * @param imageUrl
     * @return
     * @throws Exception
     */
    public static String getBase64ByUrl(String imageUrl) throws Exception {
        // new一个URL对象
        URL url = new URL(imageUrl);
        // 打开链接
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // 设置请求方式为"GET"
        conn.setRequestMethod("GET");
        // 超时响应时间为5秒
        conn.setConnectTimeout(5 * 1000);
        // 通过输入流获取图片数据
        InputStream inStream = conn.getInputStream();
        // 得到图片的二进制数据，以二进制封装得到数据，具有通用性
        byte[] data = readInputStream(inStream);
        /*BASE64Encoder encode = new BASE64Encoder();
        return encode.encode(data);*/

        Base64.Encoder encode = Base64.getUrlEncoder();
        return encode.encodeToString(data);
    }

    private static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        // 创建一个Buffer字符串
        byte[] buffer = new byte[1024];
        // 每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len = 0;
        // 使用一个输入流从buffer里把数据读取出来
        while ((len = inStream.read(buffer)) != -1) {
            // 用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            outStream.write(buffer, 0, len);
        }
        // 关闭输入流
        inStream.close();
        // 把outStream里的数据写入内存
        return outStream.toByteArray();
    }

}
