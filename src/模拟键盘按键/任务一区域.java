/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 模拟键盘按键;

import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author Administrator
 */
public class 任务一区域 {

    public Rectangle rectangle;

    public 任务一区域(Point p1, Point p2) {
        int x = p1.x;
        int y = p1.y;
        int width = p2.x - p1.x;
        int height = p2.y - p1.y;
        rectangle = new Rectangle(x, y, width, height);
    }
}
