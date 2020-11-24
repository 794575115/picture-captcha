package com.example.picturecaptcha;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Random;

/**
 * @author Shiimin
 * @date 2020/11/24
 */
public class GraphicHelper {
    /**
     * 以字符串形式返回生成的验证码，同时输出一个图片
     *
     * @param width   图片的宽度
     * @param height  图片的高度
     * @param imgType 图片的类型
     * @param output  图片的输出流(图片将输出到这个流中)
     * @return 返回所生成的验证码(字符串)
     */
    public static String create(final int width, final int height, final String imgType, OutputStream output) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphic = image.getGraphics();

        graphic.setColor(Color.getColor("F8F8F8"));
        graphic.fillRect(0, 0, width, height);

        Color[] colors = new Color[]{Color.BLUE, Color.GRAY, Color.GREEN, Color.RED, Color.BLACK, Color.ORANGE,
                Color.CYAN};
        // 在 "画板"上生成干扰线条 ( 50 是线条个数)
        for (int i = 0; i < 50; i++) {
            graphic.setColor(colors[random.nextInt(colors.length)]);
            final int x = random.nextInt(width);
            final int y = random.nextInt(height);
            final int w = random.nextInt(20);
            final int h = random.nextInt(20);
            final int signA = random.nextBoolean() ? 1 : -1;
            final int signB = random.nextBoolean() ? 1 : -1;
            graphic.drawLine(x, y, x + w * signA, y + h * signB);
        }
        // 在 "画板"上绘制字母
        graphic.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        for (int i = 0; i < 6; i++) {
//            final int temp = random.nextInt(26) + 97;
//            String s = String.valueOf((char) temp);
            String num = "0123456789";
            char[] chars = num.toCharArray();
            String s = "";
            int temp = 0;
            int aa = random.nextInt(3);
            switch (aa) {
                case 0:
                    temp = random.nextInt(26) + 97;
                    s = String.valueOf((char) temp);
                    break;
                case 1:
                    temp = random.nextInt(26) + 65;
                    s = String.valueOf((char) temp);
                    break;
                default:
                    temp = random.nextInt(10);
                    s = String.valueOf(chars[temp]);
                    break;
            }

            sb.append(s);
            graphic.setColor(colors[random.nextInt(colors.length)]);
            graphic.drawString(s, random.nextInt((width / 12)) + i * (width / 6), height - (height / 3));
        }
        graphic.dispose();
        try {
            ImageIO.write(image, imgType, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(6));
    }
}
