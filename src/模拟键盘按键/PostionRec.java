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
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

/**
 *
 * @author Administrator
 */
public class PostionRec {

    String screenPicName = "screenPic.png";
    Language lang = Language.java;
    String pythonFile = "D:\\Users\\NetbeansProjects\\模拟键盘按键\\patternMatching.py";

    public enum Language {
        python, java
    }

    public PostionRec(Language language) {
        if (language == Language.java) {
            PostionRecJava();//java本地实现图片识别
        } else if (language == Language.python) {
            PostionRecPython();//调用python实现图片识别
            lang = Language.python;
        }
    }
    
    private void PostionRecPython(){
        
    }

    private void PostionRecJava() {
        //因为opencv需要加载.dll文件，该文件需要添加到java库文件搜索路径中，否则opencv使用会报链接错误
        //下一句得到系统的java库文件路径
        /**
         * String libpath = System.getProperty("java.library.path"); String
         * currentPath = System.getProperty("user.dir");//得到当前项目所在目录，即.\模拟键盘按键
         * String dllPath=currentPath+"\\opencv_java330";
         * System.loadLibrary(dllPath);
         *
         */
        //以上动态库加载方式会报：java.lang.UnsatisfiedLinkError: Directory separator should not appear in library name: D:\Users\NetbeansProjects\模拟键盘按键\opencv_java330
        //从网上搜索得到以下方法
//        String currentPath = System.getProperty("user.dir");//得到当前项目所在目录，即.\模拟键盘按键
//        String LIBFILENAME=currentPath+"\\opencv_java330.dll";
//        
//        try {
//            // 获取到java.library.path  及系统变量中Path中的内容  
//            String libpath = System.getProperty("java.library.path");
//            if (libpath == null || libpath.length() == 0) {
//                throw new RuntimeException("java.library.path is null");
//            }
//            //javaBinPath   jdk的bin目录D:\Program Files\Java\jdk1.6.0_11\bin  
//            String javaBinPath = null;
//            StringTokenizer st = new StringTokenizer(libpath,
//                    System.getProperty("path.separator"));
//            if (st.hasMoreElements()) {
//                javaBinPath = st.nextToken();
//            } else {
//                throw new RuntimeException("can not split library path:"
//                        + libpath);
//            }
//            // 把dll文件写入到java.library.path中该dll放在ConvertWord2HM相同目录下，这个可以是你的类名              
//            InputStream inputStream = PostionRec.class.getResourceAsStream(
//                    LIBFILENAME);
//            final File dllFile = new File(LIBFILENAME);
//            if (!dllFile.exists()) {
//                FileOutputStream outputStream = new FileOutputStream(dllFile);
//                byte[] array = new byte[1024];
//                int bytesRead = -1;
//                while ((bytesRead = inputStream.read(array)) != -1) {
//                    outputStream.write(array, 0, bytesRead);
//                }
//                outputStream.flush();
//                outputStream.close();
//            }
//            // 动态加载dll  
//            System.load(dllFile.getPath());
//            // 在虚拟机关闭的时候删除dll  
//            dllFile.deleteOnExit();
//        } catch (Throwable e) {
//            throw new RuntimeException("load Convert.dll error!", e);
//        }
    }

    private void postionRecPython() {

    }

    private void screenCapture() {
        try {
            Robot robot = new Robot();
            Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle screenSize = new Rectangle(screenDim);
            BufferedImage image = robot.createScreenCapture(screenSize);

            //保存屏幕截图
            File screenFile = new File(screenPicName);

            //判断文件是否存在，不存在就创建文件
            if (!screenFile.exists()) {
                screenFile.delete();
            }
            ImageIO.write(image, "png", screenFile);

        } catch (AWTException ex) {
            Logger.getLogger(PostionRec.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PostionRec.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String whichOne(String pic1, String pic2) {
        String pic = null;
        if (lang == Language.java) {

        } else if (lang == Language.python) {
            try {
                //python代码会自己截图判断，不需要在此处加截取屏幕的操作
//            PythonInterpreter interpreter=new PythonInterpreter();
//            PyFunction func=(PyFunction) interpreter.get("getPos", PyFunction.class);
//            PyObject pyobj=func.__call__(new PyString("TianYuTuBiao.png"));
//            System.out.println("answer="+pyobj.toString());
//上面使用jython的代码不支持python3,所以使用以下代码
//以下代码缺点：不能获得python函数返回值，只能通过截获输出流完成，很多时候不方便
                String[] args = {"python", pythonFile, pic1, pic2};
                Process process = Runtime.getRuntime().exec(args);
                BufferedInputStream in = new BufferedInputStream(process.getInputStream());
                BufferedInputStream err = new BufferedInputStream(process.getErrorStream());
                BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
                BufferedReader errBr = new BufferedReader(new InputStreamReader(err));
                String lineStr;
                while ((lineStr = inBr.readLine()) != null) {
                    System.out.println(lineStr);
                    pic = lineStr;
                }
                inBr.close();
                errBr.close();
                in.close();
                err.close();
            } catch (IOException ex) {
                Logger.getLogger(PostionRec.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pic;
    }

    public Postion getPos(String fileName) {
        Postion pos = new Postion();
        if (lang == Language.java) {
            screenCapture();
            Mat img = Imgcodecs.imread(fileName);
            Mat screen = Imgcodecs.imread(screenPicName);
            return new Postion();
        } else if (lang == Language.python) {
            try {
                //python代码会自己截图判断，不需要在此处加截取屏幕的操作
//            PythonInterpreter interpreter=new PythonInterpreter();
//            PyFunction func=(PyFunction) interpreter.get("getPos", PyFunction.class);
//            PyObject pyobj=func.__call__(new PyString("TianYuTuBiao.png"));
//            System.out.println("answer="+pyobj.toString());
//上面使用jython的代码不支持python3,所以使用以下代码
//以下代码缺点：不能获得python函数返回值，只能通过截获输出流完成，很多时候不方便
                String[] args = {"python", pythonFile, fileName};
                Process process = Runtime.getRuntime().exec(args);
                BufferedInputStream in = new BufferedInputStream(process.getInputStream());
                BufferedInputStream err = new BufferedInputStream(process.getErrorStream());
                BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
                BufferedReader errBr = new BufferedReader(new InputStreamReader(err));
                String lineStr;
                while ((lineStr = inBr.readLine()) != null) {
                    System.out.println(lineStr);
                    String str[];
                    str = lineStr.split(",");
                    if (str.length==4){
                        return new Postion(-1,-1,-1,-1,false,-1);
                    }
                    for (int i = 0; i < str.length; i++) {
                        str[i] = str[i].trim();
                    }
                    str[0] = str[0].substring(2); //去掉前面两个括号
                    str[1] = str[1].substring(0, str[1].length() - 1);
                    str[2] = str[2].substring(1);
                    str[3] = str[3].substring(0, str[3].length() - 1);
                    str[5] = str[5].substring(0, str[5].length() - 1);

                    pos.setX1(Integer.parseInt(str[0]));
                    pos.setY1(Integer.parseInt(str[1]));
                    pos.setX2(Integer.parseInt(str[2]));
                    pos.setY2(Integer.parseInt(str[3]));
                    pos.setExists(Boolean.parseBoolean(str[4]));
                    pos.setConfidence(Double.parseDouble(str[5]));
                    pos.setXcenter((pos.getX1() + pos.getX2()) / 2);
                    pos.setYcenter((pos.getY1() + pos.getY2()) / 2);
                }
                inBr.close();
                errBr.close();
                in.close();
                err.close();
            } catch (IOException ex) {
                Logger.getLogger(PostionRec.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //pos.print();
        return pos;
    }
}
