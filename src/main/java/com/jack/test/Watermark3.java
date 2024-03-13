package com.jack.test;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Watermark3 {
    public static void addImageWaterMark(BufferedImage targetImg, BufferedImage waterImg, String outPath) {
        try {
            int width = targetImg.getWidth(); //图片宽
            int height = targetImg.getHeight(); //图片高
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
            Graphics2D g = bufferedImage.createGraphics();
            g.drawImage(targetImg, 0, 0, width, height, null);
            // 水印内容放置在右下角
            int x = width - waterImg.getWidth();
            int y = height - waterImg.getHeight();
            g.drawImage(waterImg, x, y, waterImg.getWidth(), waterImg.getHeight(), null);
            FileOutputStream outImgStream = new FileOutputStream(outPath);
            ImageIO.write(bufferedImage, "jpg", outImgStream);
            outImgStream.flush();
            outImgStream.close();
            g.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addImgWaterMark(BufferedImage targetImg, BufferedImage waterImg, String outPath) {
        try {
            Thumbnails.of(targetImg)
                    .size(targetImg.getWidth(), targetImg.getHeight()) // 大小
                    .watermark(Positions.BOTTOM_RIGHT, waterImg, 1f)  // 0.5f表示透明度，最大值为1
                    .outputQuality(1)   // 图片质量，最大值为1
                    .toFile(new File(outPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void compress(BufferedImage targetImg, String destPath, float quality) {
        try {
            Thumbnails.of(targetImg)
                    .scale(1f)
                    .outputQuality(quality)
                    .toFile(destPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
//        BufferedImage image = ImageIO.read(new URL("https://rydsoss.oss-cn-hangzhou.aliyuncs.com/oms/2024-01-08/1744190064596054016_99b1555c56154cc7a49d6a4053409b46.png"));
        BufferedImage image = ImageIO.read(new URL("https://rydsoss.oss-cn-hangzhou.aliyuncs.com/oms/2024-01-08/1744190064596054016_99b1555c56154cc7a49d6a4053409b46.png"));

        BufferedImage waterImage = ImageIO.read(new URL("https://rydsoss.oss-cn-hangzhou.aliyuncs.com/oms/2024-01-08/1744241456450859008_fb280aac90824d0a91cff43c5225b837.png"));
//        addImageWaterMark(image, waterImage, "/Users/youpanpan/Downloads/watermark/1.jpg");
        // thumbnailator实现
//        addImgWaterMark(image, waterImage, "/Users/youpanpan/Downloads/watermark/2.jpg");

        compress(image,  "/Users/youpanpan/Downloads/watermark/6.jpg", 0.5f);
    }
}
