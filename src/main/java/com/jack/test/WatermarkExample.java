package com.jack.test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class WatermarkExample {

    public static void main(String[] args) {
        try {
            // 图片地址
            String imageUrl = "https://rydsoss.oss-cn-hangzhou.aliyuncs.com/oms/2024-01-08/1744190064596054016_99b1555c56154cc7a49d6a4053409b46.png";
            URL url = new URL(imageUrl);

            // 从 URL 读取图片
            BufferedImage originalImage = ImageIO.read(url);

            // 创建一个带有水印的图片
//            BufferedImage watermarkedImage = addWatermark(originalImage, "如鱼得水");

            // 加载水印图片
            BufferedImage watermarkImage = ImageIO.read(new URL("https://rydsoss.oss-cn-hangzhou.aliyuncs.com/oms/2024-01-08/1744224359352070144_ec4ae0a93721465cbb07b1c06a8b1fd3.png"));

            // 创建一个带有水印的图片
            BufferedImage watermarkedImage = addWatermark(originalImage, watermarkImage);

            // 获取带有水印的图片的字节流
//            byte[] imageBytes = getImageBytes(watermarkedImage);

            // 将带有水印的图片保存到新文件
            File outputFile = new File("/Users/youpanpan/Downloads/watermark/output.jpg");
            ImageIO.write(watermarkedImage, "jpg", outputFile);

            System.out.println("Watermark added successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage addWatermark(BufferedImage originalImage, BufferedImage watermarkImage) {
        // 创建一个复制原始图片的 BufferedImage
        BufferedImage newImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = newImage.createGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        // 设置水印透明度
        float alpha = 0.5f;
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

        // 添加水印
        int watermarkX = (originalImage.getWidth() - watermarkImage.getWidth()) / 2;
        int watermarkY = (originalImage.getHeight() - watermarkImage.getHeight()) / 2;
        graphics.drawImage(watermarkImage, watermarkX, watermarkY, null);

        // 释放资源
        graphics.dispose();

        return newImage;
    }

    private static BufferedImage addWatermark(BufferedImage originalImage, String watermarkText) {
        // 创建一个复制原始图片的 BufferedImage
        BufferedImage newImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = newImage.createGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        // 设置水印字体和颜色
        graphics.setFont(new Font("Arial", Font.BOLD, 30));
        graphics.setColor(Color.RED);

        // 添加水印
        graphics.drawString(watermarkText, 20, originalImage.getHeight() - 20);

        // 释放资源
        graphics.dispose();

        return newImage;
    }

    private static byte[] getImageBytes(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos);
        return baos.toByteArray();
    }
}

