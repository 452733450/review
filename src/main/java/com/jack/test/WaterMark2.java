package com.jack.test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public class WaterMark2 {

    public static void main(String[] args) {
        try {
            // 1. 加载原始图片
            String imageUrl = "https://rydsoss.oss-cn-hangzhou.aliyuncs.com/oms/2024-01-08/1744190064596054016_99b1555c56154cc7a49d6a4053409b46.png";
            BufferedImage originalImage = loadImageFromURL(imageUrl);

            // 2. 加载水印图片
            String watermarkUrl = "https://rydsoss.oss-cn-hangzhou.aliyuncs.com/oms/2024-01-08/1744224359352070144_ec4ae0a93721465cbb07b1c06a8b1fd3.png";
            BufferedImage watermarkImage = loadImageFromURL(watermarkUrl);

            // 3. 在原始图片上添加水印
            BufferedImage watermarkedImage = addWatermark(originalImage, watermarkImage);

            // 将BufferedImage转换为字节数组
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            // 使用ImageIO写入JPEG格式
            try {
                Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("JPEG");
                ImageWriter writer = writers.next();

                ImageOutputStream ios = ImageIO.createImageOutputStream(os);
                writer.setOutput(ios);
                writer.write(watermarkedImage);

                ios.close();
                writer.dispose();
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] content = os.toByteArray();

            // 获取带有水印的图片的字节流
            byte[] imageBytes = getImageBytes(watermarkedImage);

            // 4. 保存结果图片
            String outputImagePath = "Users/youpanpan/Downloads/watermark/output.jpg";
            saveImage(watermarkedImage, outputImagePath);

            System.out.println("Watermark added successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage loadImageFromURL(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        return ImageIO.read(url);
    }

    private static BufferedImage addWatermark(BufferedImage originalImage, BufferedImage watermarkImage) {
        int originalWidth = originalImage.getWidth();
        int originalHeight = originalImage.getHeight();

        BufferedImage watermarkedImage = new BufferedImage(originalWidth, originalHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) watermarkedImage.getGraphics();

        // 将原始图片绘制到目标图片
        g2d.drawImage(originalImage, 0, 0, null);

        // 设置水印的透明度
        float alpha = 0.5f;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

        // 计算水印位置
        int watermarkX = (originalWidth - watermarkImage.getWidth()) / 2;
        int watermarkY = (originalHeight - watermarkImage.getHeight()) / 2;

        // 绘制水印图片
        g2d.drawImage(watermarkImage, watermarkX, watermarkY, null);

        g2d.dispose();
        return watermarkedImage;
    }

    private static void saveImage(BufferedImage image, String outputPath) throws IOException {
        File outputImageFile = new File(outputPath);
        ImageIO.write(image, "jpg", outputImageFile);
    }

    private static byte[] getImageBytes(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos);
        return baos.toByteArray();
    }
}

