/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 模拟键盘按键;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.color.ColorSpace;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class 鼠标键盘操作 {

    private Coor[] coor = new Coor[100];
    private 任务一区域 task1;
    private File task1File = new File("任务一.jpg");
    private String text;
    private 完成按钮区域 ok, esc, escOnly, f采集;
    private Postion pos;
    private PostionRec pr;

    public 鼠标键盘操作() throws Exception {
        initCoor();
        // TODO Auto-generated method stub 
        //test();
        pr = new PostionRec(PostionRec.Language.python);
        tianyuRiChang();

        JOptionPane.showMessageDialog(null, "任务完成");
    }

    private void diaoYuDaoGongZuo(Robot robot) throws Exception {
        keyPressWithCtrl(robot, KeyEvent.VK_C);//打开声望面板
        robot.delay(2000);
        robot.mouseMove(coor[2].x, coor[2].y);//移动到声望
        robot.delay(1000);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击声望
        robot.delay(2000);
        robot.mouseMove(coor[11].x, coor[11].y);//移动到 收起苏澜声望
        robot.delay(500);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击 收起苏澜声望
        robot.delay(500);
        robot.mouseMove(coor[14].x, coor[14].y);//移动到 展开盈灵声望
        robot.delay(500);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击 展开盈灵声望
        robot.delay(1000);
        robot.mouseMove(coor[15].x, coor[15].y);//移动到 玉木
        robot.delay(500);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击 玉木
        robot.delay(1000);
        robot.mouseMove(coor[3].x, coor[3].y);//移动到 点击查看声望玩法
        robot.delay(1000);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击 点击查看声望玩法
        robot.delay(1000);
        robot.mouseMove(coor[16].x, coor[16].y);//移动到工作面板区域
        robot.delay(500);
        pressMouse(robot, InputEvent.BUTTON1_DOWN_MASK, 500);
        pressMouse(robot, InputEvent.BUTTON1_DOWN_MASK, 500);
        robot.delay(1000);

        robot.mouseMove(coor[17].x, coor[17].y);//移动到 钓鱼岛工作板
        robot.delay(1000);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击 钓鱼岛工作板
        robot.delay(2000);
        robot.mouseMove(coor[8].x, coor[8].y);//关闭声望面板
        robot.delay(500);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);
    }

    private void taoYaoYaoGongZuo(Robot robot) throws Exception {
        keyPressWithCtrl(robot, KeyEvent.VK_C);//打开声望面板
        robot.delay(2000);
        robot.mouseMove(coor[2].x, coor[2].y);//移动到声望
        robot.delay(1000);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击声望
        robot.delay(2000);
        robot.mouseMove(coor[18].x, coor[18].y);//移动到 桃夭夭
        robot.delay(500);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击 桃夭夭
        robot.delay(1000);
        robot.mouseMove(coor[3].x, coor[3].y);//移动到 点击查看声望玩法
        robot.delay(1000);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击 点击查看声望玩法
        robot.delay(1000);
        robot.mouseMove(coor[19].x, coor[19].y);//移动到工作面板区域
        robot.delay(500);
        pressMouse(robot, InputEvent.BUTTON1_DOWN_MASK, 500);
        robot.delay(1000);
        robot.mouseMove(coor[8].x, coor[8].y);//关闭声望面板
        robot.delay(500);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);
    }

    private void pingHaiZhenGongZuoChuShiHua(Robot robot) {
        keyPressWithCtrl(robot, KeyEvent.VK_C);//打开声望面板
        robot.delay(1000);
        robot.mouseMove(coor[2].x, coor[2].y);//移动到声望
        robot.delay(1000);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击声望
        robot.delay(1000);
        robot.mouseMove(coor[11].x, coor[11].y);//移动到 收起苏澜声望
        robot.delay(500);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击 收起苏澜声望
        robot.delay(500);
        robot.mouseMove(coor[20].x, coor[20].y);//移动到 展开莹川郡声望列表
        pressMouse(robot, InputEvent.BUTTON1_DOWN_MASK, 500);
        robot.mouseMove(coor[21].x, coor[21].y);//移动到平海镇
        robot.delay(500);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击 平海镇
        robot.delay(1000);
        robot.mouseMove(coor[3].x, coor[3].y);//移动到 点击查看声望玩法
        robot.delay(1000);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击 点击查看声望玩法
        robot.delay(1000);
        robot.mouseMove(coor[19].x, coor[19].y);//移动到 平海镇布告栏
        robot.delay(500);
        pressMouse(robot, InputEvent.BUTTON1_DOWN_MASK, 500);
        robot.delay(1000);
        robot.mouseMove(coor[8].x, coor[8].y);//关闭声望面板
        robot.delay(500);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);
    }

    private void pingHaiZhenGongZuo(Robot robot) {
        keyPress(robot, KeyEvent.VK_F);
        robot.mouseMove(coor[22].x, coor[22].y);
        pressMouse(robot, InputEvent.BUTTON1_DOWN_MASK, 500);
        robot.mouseMove(coor[23].x, coor[23].y);
        pressMouse(robot, InputEvent.BUTTON1_DOWN_MASK, 500);
        robot.mouseMove(coor[24].x, coor[24].y);//关闭声望面板
        pressMouse(robot, InputEvent.BUTTON1_DOWN_MASK, 500);
    }

    private void tianyuRiChang() throws Exception {
        Robot robot = new Robot();
        initCoor();

        keyPress(robot, KeyEvent.VK_WINDOWS);
        robot.delay(2000);
        //获得天谕图标

        pos = pr.getPos("TianYuTuBiao.png");
        robot.mouseMove(pos.getXcenter(), pos.getYcenter());
        robot.delay(500);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);
        pos = pr.getPos("TianYuChuangKouTitle.png");
        robot.delay(500);
        robot.mouseMove(pos.getXcenter(), pos.getYcenter());
        robot.delay(500);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);
        robot.delay(1000);

        int 苏澜城任务次数 = 0;
        try {
            if (苏澜城任务次数 > 0) {
                苏澜任务初始化(robot);
            }
            for (int i = 0; i < 苏澜城任务次数; i++) {
                System.out.println("苏澜城任务第:" + (i + 1) + "/" + 苏澜城任务次数);
                苏澜任务(robot);
            }
        } catch (Exception e) {
            System.out.println("苏澜任务自动完成失败！");
        }

        //再次确认游戏界面位于顶层激活状态
        pos = pr.getPos("TianYuChuangKouTitle.png");
        robot.delay(500);
        robot.mouseMove(pos.getXcenter(), pos.getYcenter());
        robot.delay(500);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);

        try {
            玉木村任务初始化(robot);
            acceptTask(robot);//玉木村任务特殊性，需要加这句，主要他的接受任务和完成任务分不开
            for (int i = 0; i < 3; i++) {
                玉木村任务(robot);
            }
        } catch (Exception e) {
            System.out.println("玉木村任务自动完成失败！");
        }

        //由于汐族任务有些无法自动寻路，目前不能完美完成
//        汐族任务初始化(robot);
//        汐族任务(robot);
//        汐族任务(robot);
//        汐族任务(robot);
//        汐族任务(robot);
//        汐族任务(robot);
        //伞村任务初始化(robot);
//        伞村任务(robot);
//        伞村任务(robot);
//        伞村任务(robot);
//        伞村任务(robot);
//        伞村任务(robot);
    }

    private void 玉木村任务初始化(Robot robot) {
        System.out.println("玉木村任务初始化开始");
        keyPressWithCtrl(robot, KeyEvent.VK_C);//打开声望面板
        robot.delay(200);

        pos = pr.getPos("ShengWangTuBiao.png");
        robot.mouseMove(pos.getXcenter(), pos.getYcenter());//移动到声望
        robot.delay(200);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击声望
        robot.delay(200);

        pos = pr.getPos("MenPaiShengWangZheDie.png");//折叠门派声望
        robot.mouseMove(pos.getXcenter(), pos.getYcenter());
        robot.delay(200);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);
        robot.delay(200);

        pos = pr.getPos("YuMuJunShengWangZhanKai.png");//展开玉木郡声望
        robot.mouseMove(pos.getXcenter(), pos.getYcenter());
        robot.delay(200);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 200);
        robot.delay(200);

        pos = pr.getPos("YuMuCunShengWang.png");//选择玉木村声望
        robot.mouseMove(pos.getXcenter(), pos.getYcenter());
        robot.delay(200);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 200);
        robot.delay(200);

        pos = pr.getPos("DianJiChaKanShengWangWanFa.png");//点击查看声望玩法
        robot.mouseMove(pos.getXcenter(), pos.getYcenter());
        robot.delay(200);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 200);
        robot.delay(200);

        pos = pr.getPos("YaoCaiCaiJiYaoCao.png");//移动到药材采集药草
        robot.mouseMove(pos.getXcenter(), pos.getYcenter());
        robot.delay(200);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 200);

        //关闭声望面板
        keyPress(robot, KeyEvent.VK_ESCAPE);

        waitRenWu(robot);

        pos = pr.getPos("closeShengWangMianBan.png");//如果声望面板存在，就关闭声望面板
        if (pos.getConfidence() != -1) {
            robot.mouseMove(pos.getXcenter(), pos.getYcenter());
            robot.delay(200);
            pressMouse(robot, InputEvent.BUTTON1_MASK, 200);
            robot.delay(200);
        }
    }

    private void 玉木村任务(Robot robot) {
        System.out.println("正在去采草");
        gotoFirstNeedDoneTask(robot);
        System.out.println("找程继先交任务");
        gotoFirstFinishedTask(robot);
        acceptTask(robot);
        System.out.println("替程继先给别人送草药");
        gotoFirstFinishedTask(robot);
        acceptTask(robot);
        System.out.println("最后回程继先处");
        gotoFirstFinishedTask(robot);//玉木村任务不会弹出，交和接任务是一起的
        System.out.println("交文物，完成一环");
        acceptTask(robot);
    }

    private void 伞村任务(Robot robot) {
        keyPress(robot, KeyEvent.VK_F);//接受任务
        robot.delay(1000);
        robot.mouseMove(coor[5].x, coor[5].y);//移动到完成
        robot.delay(1000);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击完成
        robot.delay(1000);
        System.out.println("已接受任务");
        //至此，任务接受完成
        robot.mouseMove(coor[6].x, coor[6].y);//移动到 第一个任务寻路
        robot.delay(1000);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击 第一个任务寻路
        robot.delay(30000);
        keyPress(robot, KeyEvent.VK_ESCAPE);
        robot.delay(1000);
        robot.mouseMove(930, 420);//防止不是寻找小伙伴任务是按ESC键之后出来的系统设置，点击返回游戏
        robot.delay(500);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);
        robot.delay(1000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(8000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(8000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(8000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(8000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(8000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(8000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(8000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(8000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(8000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(8000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(8000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(8000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(8000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(8000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(8000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(8000);
        for (int i = 0; i < 700; i++) {
            keyPress(robot, KeyEvent.VK_V);//打怪任务
            robot.delay(200);
        }
        System.out.println("任务完成，回NPC交任务");
        robot.mouseMove(coor[6].x, coor[6].y);//移动到 第一个任务寻路
        robot.delay(1000);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击 第一个任务寻路
        robot.delay(30000);

        robot.delay(1000);
        robot.mouseMove(coor[5].x, coor[5].y);//移动到完成
        robot.delay(1000);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击完成
        robot.delay(1000);
        robot.mouseMove(coor[5].x, coor[5].y);//移动到完成
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击完成
        robot.delay(1000);
        robot.mouseMove(coor[5].x, coor[5].y);//移动到完成
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击完成
        robot.delay(1000);
        System.out.println("伞村任务完成一轮");
    }

    private void 汐族任务初始化(Robot robot) {
        keyPressWithCtrl(robot, KeyEvent.VK_C);//打开声望面板
        robot.delay(2000);
        robot.mouseMove(coor[2].x, coor[2].y);//移动到声望
        robot.delay(1000);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击声望
        robot.delay(2000);
        robot.mouseMove(coor[7].x, coor[7].y);//移动到汐族
        robot.delay(1000);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击 汐族
        robot.delay(1000);
        robot.mouseMove(coor[3].x, coor[3].y);//移动到 点击查看声望玩法
        robot.delay(1000);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击 点击查看声望玩法
        robot.delay(1000);
        robot.mouseMove(coor[9].x, coor[9].y);//移动到 汐愿汐语缠绵 即汐族声望任务NPC
        robot.delay(1000);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击寻路汐族声望任务NPC
        robot.delay(2000);
        robot.mouseMove(coor[8].x, coor[8].y);//关闭声望面板
        robot.delay(1000);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);
        robot.delay(60000);
    }

    private void 汐族任务(Robot robot) {
        keyPress(robot, KeyEvent.VK_F);//接受任务
        robot.delay(1000);
        robot.mouseMove(coor[5].x, coor[5].y);//移动到完成
        robot.delay(1000);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击完成
        robot.delay(1000);
        robot.mouseMove(coor[5].x, coor[5].y);//移动到完成
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击完成
        robot.delay(1000);
        robot.mouseMove(coor[5].x, coor[5].y);//移动到完成
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击完成
        robot.delay(1000);
        //至此，任务接受完成
        robot.mouseMove(coor[6].x, coor[6].y);//移动到 第一个任务寻路
        robot.delay(1000);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击 第一个任务寻路
        robot.delay(30000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(10000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(10000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(10000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(10000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(10000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(10000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(10000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(10000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(10000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(10000);
        keyPress(robot, KeyEvent.VK_F);
        robot.delay(10000);

        robot.delay(1000);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击 第一个任务寻路
        robot.delay(30000);

        robot.delay(1000);
        robot.mouseMove(coor[5].x, coor[5].y);//移动到完成
        robot.delay(1000);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击完成
        robot.delay(1000);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击完成
        robot.delay(1000);
        robot.mouseMove(coor[5].x, coor[5].y);//移动到完成
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击完成
        robot.delay(1000);
        robot.mouseMove(coor[5].x, coor[5].y);//移动到完成
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击完成
        robot.delay(1000);
        robot.mouseMove(coor[5].x, coor[5].y);//移动到完成
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击完成
    }

    private void 苏澜任务初始化(Robot robot) {
        System.out.println("苏澜任务初始化开始");
        keyPressWithCtrl(robot, KeyEvent.VK_C);//打开声望面板
        robot.delay(200);

        pos = pr.getPos("ShengWangTuBiao.png");
        robot.mouseMove(pos.getXcenter(), pos.getYcenter());//移动到声望
        robot.delay(200);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);//点击声望
        robot.delay(200);

        pos = pr.getPos("MenPaiShengWangZheDie.png");//折叠门派声望
        robot.mouseMove(pos.getXcenter(), pos.getYcenter());
        robot.delay(200);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 500);
        robot.delay(200);

        pos = pr.getPos("SuLanJunShengWangZhanKai.png");//展开苏澜郡声望
        robot.mouseMove(pos.getXcenter(), pos.getYcenter());
        robot.delay(200);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 200);
        robot.delay(200);

        pos = pr.getPos("SuLanChengShengWang.png");//选择苏澜城声望
        robot.mouseMove(pos.getXcenter(), pos.getYcenter());
        robot.delay(200);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 200);
        robot.delay(200);

        pos = pr.getPos("DianJiChaKanShengWangWanFa.png");//点击查看声望玩法
        robot.mouseMove(pos.getXcenter(), pos.getYcenter());
        robot.delay(200);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 200);
        robot.delay(200);

        pos = pr.getPos("JiuGuanYingLaiSongWang.png");//移动到酒馆迎来送往
        robot.mouseMove(pos.getXcenter(), pos.getYcenter());
        robot.delay(200);
        pressMouse(robot, InputEvent.BUTTON1_MASK, 200);

        //关闭声望面板
        keyPress(robot, KeyEvent.VK_ESCAPE);

        if (!waitRenWu(robot)) {
            苏澜任务初始化(robot);
        }

        pos = pr.getPos("closeShengWangMianBan.png");//如果声望面板存在，就关闭声望面板
        if (pos.getConfidence() != -1) {
            robot.mouseMove(pos.getXcenter(), pos.getYcenter());
            robot.delay(200);
            pressMouse(robot, InputEvent.BUTTON1_MASK, 200);
            robot.delay(200);
        }
    }

    private void acceptTask(Robot robot) {
        System.out.println("正在接受任务...");
        boolean f = true;
        keyPress(robot, KeyEvent.VK_F);
        while (f) {
            if (pr.whichOne("RightUpIcons.png", "Escape.png").equals("RightUpIcons.png")) {
                System.out.println("接受任务完成！");
                break;
            } else if (pr.whichOne("Escape.png", "XuanZeRenWu1.png").equals("XuanZeRenWu1.png")) {
                keyPress(robot, KeyEvent.VK_1);
            } else {
                keyPress(robot, KeyEvent.VK_F);
                robot.delay(500);
                keyPress(robot, KeyEvent.VK_SPACE);
            }
        }
    }

    private void finishTask(Robot robot) {
        System.out.println("正在交任务...");
        boolean f = true;
        keyPress(robot, KeyEvent.VK_F);
        while (f) {
            if (pr.whichOne("RightUpIcons.png", "Escape.png").equals("RightUpIcons.png")) {
                break;
            } else if (pr.whichOne("Accept.png", "XuanZeRenWu1.png").equals("XuanZeRenWu1.png")) {
                keyPress(robot, KeyEvent.VK_1);
            } else {
                keyPress(robot, KeyEvent.VK_F);
                robot.delay(500);
                keyPress(robot, KeyEvent.VK_SPACE);
            }
        }
        robot.delay(2000);
    }

    private boolean waitRenWu(Robot robot) {
        boolean f = true;
        int i = 0;
        System.out.println("去接任务的路上...");
        while (f) {
            i++;
            if (pr.whichOne("Escape.png", "RightUpIcons.png").equals("Escape.png")) {
                System.out.println("quit1");
                if (pr.whichOne("Escape.png", "LoadingMap.png").equals("Escape.png")) {
                    System.out.println("quit2");
                    if (pr.whichOne("Escape.png", "LoadingMap1.png").equals("Escape.png")) {
                        keyPress(robot, KeyEvent.VK_ESCAPE);
                        System.out.println("quit3");
                        robot.delay(1000);
                        f = false;
                        break;
                    }
                }
            }
            if (i > 20) {//长时间不退出循环，可能是卡住了，返回寻路失败
                if ((pr.whichOne("RightUpIcons.png", "LoadingMap.png").equals("RightUpIcons.png"))
                        && (pr.whichOne("RightUpIcons.png", "LoadingMap1.png").equals("RightUpIcons.png"))) {//表示不再读图界面
                    //判断当前任务是否运动
                    return false;
                }
            }

        }

        System.out.println("已经移动到NPC面前");
        robot.delay(1000);

        return true;
    }

    private void 苏澜任务(Robot robot) {
        acceptTask(robot);//接受白展堂任务
        System.out.println("正在替白展堂送食物...");
        gotoFirstFinishedTask(robot);
        finishTask(robot);
        acceptTask(robot);
        System.out.println("正在回酒馆的路上...");
        gotoFirstFinishedTask(robot);
        finishTask(robot);
    }

    private void gotoFirstFinishedTask(Robot robot) {
        System.out.println("开始第一个任务");
        keyPressWithCtrl(robot, KeyEvent.VK_F);
        keyPressWithCtrl(robot, KeyEvent.VK_F);
        waitRenWu(robot);
    }

    private void gotoFirstNeedDoneTask(Robot robot) {
        System.out.println("开始第一个任务");
        boolean f = true;
        while (f) {
            for (int i = 0; i < 2; i++) {
                keyPressWithCtrl(robot, KeyEvent.VK_F);
                robot.delay(1000);
            }

//            if (存在怪物打断){
//                打怪();怪物攻击不一定打断操作
//            keyPress(robot, KeyEvent.VK_1);
//            keyPress(robot, KeyEvent.VK_V);
//            keyPress(robot, KeyEvent.VK_V);
//            keyPress(robot, KeyEvent.VK_V);
//            }
            if (pr.whichOne("WangYouCao.png", "WanChengChengJiXian.png").equals("WanChengChengJiXian.png")) {
                f = false;
            }
        }
        System.out.println("First task done!");
    }

    // shift+ 按键 
    public static void keyPressWithShift(Robot r, int key) {
        r.keyPress(KeyEvent.VK_SHIFT);
        r.keyPress(key);
        r.keyRelease(key);
        r.keyRelease(KeyEvent.VK_SHIFT);
        r.delay(100);
    }

    // ctrl+ 按键 
    public static void keyPressWithCtrl(Robot r, int key) {
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(key);
        r.keyRelease(key);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.delay(100);
    }

    // alt+ 按键 
    public static void keyPressWithAlt(Robot r, int key) {
        r.keyPress(KeyEvent.VK_ALT);
        r.keyPress(key);
        r.keyRelease(key);
        r.keyRelease(KeyEvent.VK_ALT);
        r.delay(100);
    }
    //打印出字符串 

    public static void keyPressString(Robot r, String str) {
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();//获取剪切板 
        Transferable tText = new StringSelection(str);
        clip.setContents(tText, null); //设置剪切板内容 
        keyPressWithCtrl(r, KeyEvent.VK_V);//粘贴 

        r.delay(100);
    }

    //单个 按键 
    public static void keyPress(Robot r, int key) {
        r.keyPress(key);
        r.delay(100);
        r.keyRelease(key);
        r.delay(100);
    }

    private static void pressMouse(Robot r, int m, int delay) {

        r.mousePress(m);
        r.delay(delay);
        r.mouseRelease(m);
        r.delay(delay);
    } //键盘输入

    private String rectText(Rectangle rect) {
        try {
            Robot robot = new Robot();
            BufferedImage image = robot.createScreenCapture(rect);

            saveImage(task1File, image);
            robot.delay(1000);
            文字识别 textRec = new 文字识别();
            String text = textRec.recognizeText(task1File, "chi_sim");
            return text;

        } catch (Exception ex) {
            Logger.getLogger(鼠标键盘操作.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String rectTextByGrey(Rectangle rect, int tab) {
        try {
            Robot robot = new Robot();
            BufferedImage image = robot.createScreenCapture(rect);
            if (tab == 0) {
                new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null).filter(image, image);
            }
            saveImage(task1File, image);
            if (tab == 1) {
                ThresholdBinaryFilter tf = new ThresholdBinaryFilter();
                tf.getImagePixel(task1File.getAbsolutePath());
            }
            robot.delay(1000);
            文字识别 textRec = new 文字识别();
            String text = textRec.recognizeText(task1File, "chi_sim");
            return text;

        } catch (Exception ex) {
            Logger.getLogger(鼠标键盘操作.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void saveImage(File file, BufferedImage image) {

        try {
            //写入文件
            ImageIO.write(image, "jpg", file);

        } catch (IOException ex) {
            Logger.getLogger(鼠标键盘操作.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initCoor() {

        coor[0] = new Coor(642, 1020);
        coor[1] = new Coor(300, 200);
        int 声望面板X = 9;
        int 声望面板Y = 31;
        int 声望X = 声望面板X + 266;
        int 声望Y = 声望面板Y + 51;
        coor[2] = new Coor(声望X, 声望Y);//声望
        coor[3] = new Coor(声望X + 875 - 456, 声望Y + 452 - 291);//点击查看声望玩法
        coor[4] = new Coor(声望X + 1074 - 456, 声望Y + 714 - 291);//酒馆迎来送往
        coor[5] = new Coor(1446, 973);//(space)完成
        coor[6] = new Coor(1445, 427);//第一个任务寻路
        coor[7] = new Coor(300, 452);//汐族
        coor[8] = new Coor(声望X + 970 - 456, 声望Y + 263 - 291);//关闭声望面板
        coor[9] = new Coor(1081, 595);//汐愿汐语缠绵
        coor[10] = new Coor(302, 520);//仙姑
        coor[11] = new Coor(声望面板X + 50, 声望面板Y + 94);//收起苏澜郡声望列表
        coor[12] = new Coor(声望面板X + 50, 声望面板Y + 152);//展开玉木郡声望列表
        coor[13] = new Coor(声望面板X + 117, 声望面板Y + 336);//玉木村

        coor[14] = new Coor(声望面板X + 50, 声望面板Y + 182);//展开盈灵镇声望列表
        coor[15] = new Coor(声望面板X + 117, 声望面板Y + 235);//元理
        coor[16] = new Coor(声望面板X + 1135, 声望面板Y + 301);//下移工作面板
        coor[17] = new Coor(声望面板X + 887, 声望面板Y + 297);//钓鱼岛工作

        coor[18] = new Coor(声望面板X + 120, 声望面板Y + 345);//桃夭夭
        coor[19] = new Coor(声望面板X + 882, 声望面板Y + 240);//桃花林工作板

        coor[20] = new Coor(声望面板X + 50, 声望面板Y + 126);//展开莹川郡声望列表
        coor[21] = new Coor(声望面板X + 116, 声望面板Y + 181);//平海镇
        coor[22] = new Coor(745, 578);//工作面板第一个任务
        coor[23] = new Coor(816, 729);//工作任务接受按钮
        coor[24] = new Coor(1106, 321);//工作面板关闭按钮
        coor[25] = new Coor(1436, 377);//任务追踪区域工作标签页
        coor[26] = new Coor(1482, 444);//安息香
        coor[27] = new Coor(1578, 444);//小码头
        coor[28] = new Coor(1573, 458);//食物补给
        coor[29] = new Coor(1428, 443);//黎婶

        task1 = new 任务一区域(new Point(1367, 398), new Point(1632, 457));
        ok = new 完成按钮区域(new Point(1404, 966), new Point(1494, 980));
        esc = new 完成按钮区域(new Point(1410, 995), new Point(1488, 1015));
        escOnly = new 完成按钮区域(new Point(1410, 993), new Point(1490, 1015));
        f采集 = new 完成按钮区域(new Point(1015, 563), new Point(1050, 598));
    }

}
