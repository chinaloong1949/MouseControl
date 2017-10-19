/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 模拟键盘按键;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author Administrator
 */
public class ThresholdBinaryFilter {

    //读取一张图片的RGB值
    public void getImagePixel(String image) throws Exception {
        int[][][] rgb;
        int[] inPixels;
        int[][] rgbs;
        File file = new File(image);
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int width = bi.getWidth();
        int height = bi.getHeight();
        rgb = new int[width][height][3];
        rgbs = new int[width][height];
        inPixels = new int[width * height];
        int minx = bi.getMinX();
        int miny = bi.getMinY();

        System.out.println("width=" + width + ",height=" + height + ".");
        System.out.println("minx=" + minx + ",miny=" + miny + ".");
        for (int i = minx; i < width; i++) {
            for (int j = miny; j < height; j++) {
                int pixel = bi.getRGB(i, j);//下面三行代码讲一个数字转换为RGB数字
                rgb[i][j][0] = (pixel & 0xff0000) >> 16;
                rgb[i][j][1] = (pixel & 0xff00) >> 8;
                rgb[i][j][2] = (pixel & 0xff);
                inPixels[i * width + j] = pixel;
//                System.out.println("i=" + i + ",j=" + j + ":(" + rgb[0] + ","
//                        + rgb[1] + "," + rgb[2] + ")");
            }
        }
        int means = getThreshold(inPixels, height, width);
        for (int i = minx; i < width; i++) {
            for (int j = miny; j < height; j++) {
                if ((rgb[i][j][0] + rgb[i][j][1] + rgb[i][j][2]) / 3 > means) {
                    rgb[i][j][0] = rgb[i][j][1] = rgb[i][j][2] = 255;//white;
                } else {
                    rgb[i][j][0] = rgb[i][j][1] = rgb[i][j][2] = 0;//black
                }
            }
        }
        for (int i = minx; i < width; i++) {
            for (int j = miny; j < height; j++) {
                rgbs[i][j] = ((rgb[i][j][0] * 256) + rgb[i][j][1]) * 256
                        + rgb[i][j][2];//((r*256+g)*256+b
                if (rgbs[i][j] > 8388608) {
                    rgbs[i][j] = rgbs[i][j] - 16777216;
                }
                bi.setRGB(i, j, rgbs[i][j]);
            }
        }
        ImageIO.write(bi, "jpg", file);
    }

    private int getThreshold(int[] inPixels, int height, int width) {
        int inithreshold = 127;
        int finalthreshold = 0;
        int temp[] = new int[inPixels.length];
        for (int index = 0; index < inPixels.length; index++) {
            temp[index] = (inPixels[index] >> 16) & 0xff;
        }
        List<Integer> sub1 = new ArrayList<Integer>();
        List<Integer> sub2 = new ArrayList<Integer>();
        int means1 = 0, means2 = 0;
        while (finalthreshold != inithreshold) {
            finalthreshold = inithreshold;
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] < inithreshold) {
                    sub1.add(temp[i]);

                } else {
                    sub2.add(temp[i]);
                }
            }
            means1 = getMeans(sub1);
            means2 = getMeans(sub2);
            sub1.clear();
            sub2.clear();
            inithreshold = (means1 + means2) / 2;
        }
        return finalthreshold;
    }

    private int getMeans(List<Integer> data) {
        int result = 0;
        int size = data.size();
        for (Integer i : data) {
            result += i;
        }
        return (result / size);
    }

    //返回屏幕色彩值
    public int getScreenPixel(int x, int y) throws AWTException {
        Robot rb = null;
        rb = new Robot();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension di = tk.getScreenSize();
        Rectangle rec = new Rectangle(0, 0, di.width, di.height);
        BufferedImage bi = rb.createScreenCapture(rec);
        int pixelColor = bi.getRGB(x, y);
        if (pixelColor > - 8388608) {
            return pixelColor;
        } else {
            return 16777216 + pixelColor;
        }
    }
}
