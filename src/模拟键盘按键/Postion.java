/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 模拟键盘按键;

/**
 *
 * @author Administrator
 */
public class Postion {

    private int x1=0;//点1x坐标
    private int x2=0;//点2x坐标
    private int y1=0;//点1y坐标
    private int y2=0;
    private int xcenter=0;//位置中心点坐标
    private int ycenter=0;
    private boolean exists=false;//用来标记查找的子图片是否存在，False表示没有完全匹配的
    private double confidence=0;//表示匹配度，1代表完全匹配，最小为0.5，如果需要改变最小值，需要在python代码中改

    public Postion(int x1, int y1, int x2, int y2, boolean exists, double confidence) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.exists = exists;
        this.confidence = confidence;
    }

    public Postion() {

    }

    public void print() {
        System.out.println("point1:" + x1 + "," + y1 + "    point2:" + x2 + "," + y2);
        System.out.println("是否存在:" + exists + " 结果可信度:" + confidence);
    }

    /**
     * @return the x1
     */
    public int getX1() {
        return x1;
    }

    /**
     * @param x1 the x1 to set
     */
    public void setX1(int x1) {
        this.x1 = x1;
    }

    /**
     * @return the x2
     */
    public int getX2() {
        return x2;
    }

    /**
     * @param x2 the x2 to set
     */
    public void setX2(int x2) {
        this.x2 = x2;
    }

    /**
     * @return the y1
     */
    public int getY1() {
        return y1;
    }

    /**
     * @param y1 the y1 to set
     */
    public void setY1(int y1) {
        this.y1 = y1;
    }

    /**
     * @return the y2
     */
    public int getY2() {
        return y2;
    }

    /**
     * @param y2 the y2 to set
     */
    public void setY2(int y2) {
        this.y2 = y2;
    }

    /**
     * @return the xcenter
     */
    public int getXcenter() {
        return xcenter;
    }

    /**
     * @param xcenter the xcenter to set
     */
    public void setXcenter(int xcenter) {
        this.xcenter = xcenter;
    }

    /**
     * @return the ycenter
     */
    public int getYcenter() {
        return ycenter;
    }

    /**
     * @param ycenter the ycenter to set
     */
    public void setYcenter(int ycenter) {
        this.ycenter = ycenter;
    }

    /**
     * @return the exists
     */
    public boolean isExists() {
        return exists;
    }

    /**
     * @param exists the exists to set
     */
    public void setExists(boolean exists) {
        this.exists = exists;
    }

    /**
     * @return the confidence
     */
    public double getConfidence() {
        return confidence;
    }

    /**
     * @param confidence the confidence to set
     */
    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }
}
