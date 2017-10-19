/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 模拟键盘按键;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.abs;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Administrator
 */
public class 完成按钮区域 {

    public Rectangle rectangle;

    public 完成按钮区域(Point p1, Point p2) {
        int x = p1.x;
        int y = p1.y;
        int width = p2.x - p1.x;
        int height = p2.y - p1.y;
        rectangle = new Rectangle(x, y, width, height);
    }

    public boolean isImage(String fileName) {
        boolean result = false;
        try {
            Robot robot = new Robot();
            BufferedImage image = robot.createScreenCapture(rectangle);

            saveImage(new File("任务一.jpg"), image);
            File file = new File("任务一.jpg");
            BufferedImage bi = ImageIO.read(file);
            BufferedImage biStandard = ImageIO.read(new File(fileName));
            int width = bi.getWidth();
            int height = bi.getHeight();
            int[][] rgb = new int[width][height];
            int[][] rgbStandard = new int[width][height];
            int err = 0;
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    rgb[i][j] = bi.getRGB(i, j);
                    rgbStandard[i][j] = biStandard.getRGB(i, j);
                    if (abs(rgb[i][j] - rgbStandard[i][j]) > 838.860) {
                        err++;
                    }
                }
            }
            if (err / width / height < 0.1) {
                result = true;
            }

        } catch (Exception ex) {
            Logger.getLogger(完成按钮区域.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public void saveImage(File file, BufferedImage image) {

        try {
            //写入文件
            ImageIO.write(image, "jpg", file);
        } catch (IOException ex) {
            Logger.getLogger(鼠标键盘操作.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
