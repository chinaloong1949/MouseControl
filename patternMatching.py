#-*-coding: utf-8 -*-
import cv2
import os
import time
import sys
import numpy as np

import aircv as ac

def draw_rectangle(img, point1, point2 , color, line_width):
    cv2.rectangle(img, point1, point2, color, line_width)
    cv2.imshow('objDetect', img)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

from PIL import ImageGrab
def getPos(srcFile, childFile):
    #print("")
    #print(childFile)
    fn = srcFile
    fn1 = childFile
    if fn==None:

        fn='screenPic.png'
        srcFile='screenPic.png'
        if os._exists(fn):
            os.remove(fn)
        ImageGrab.grab().save(fn, 'png')  # 截图并保存

    #tempImg.save(fn1,'png')
    #parPic=cv2.imread(fn)

    myimg1 = cv2.imread(fn1)    #获取小图的宽和高
    width = myimg1.shape[1]
    height = myimg1.shape[0]

    imsrc = ac.imread(fn)
    imobj = ac.imread(fn1)

    flag = False
    pos = ac.find_template(imsrc, imobj, 0.5)#如果这种方法匹配成功，说明子图片确实存在

    import pdb
    #pdb.set_trace()
    if pos == None:
        pos = [] # ac.find_all(imsrc, imobj, 0)#如果这种方法找到说明可能子图片和大图片匹配不是很好，存在缩放，旋转等操作
        #print(pos)
        if pos==[]:#两种方法都没有找到说明子图片确实不存在
            return None, None, False,0
        point1=(int(pos[0][0]-width/2),int(pos[0][1]-height/2))
        point2=(int(pos[0][0]+width/2),int(pos[0][1]+height/2))
        chance=0
        #draw_rectangle(imsrc, point1, point2, (255, 0, 0), 2)

    else:
        flag=True
        #print(pos)
        point1 = (pos['rectangle'][0][0],pos['rectangle'][0][1])
        point2 = (pos['rectangle'][3][0],pos['rectangle'][3][1])
        chance= pos['confidence']
        #draw_rectangle(imsrc, point1,point2,(255,0,0),2)
    return point1,point2,flag,chance #返回子图片位置所在的矩形框左上角和右下角坐标
#myimg=showpiclocation(parPic,chiPic)

def whichOne(pic1,pic2):
    fn = 'screenPic.png'
    os.remove(fn)
    ImageGrab.grab().save(fn, 'png')  # 截图并保存
    p1_1,p2_1,f_1,chance_1=getPos(fn, pic1)
    time.sleep(1)
    p1_2,p2_2,f_2,chance_2=getPos(fn, pic2)
    if f_1==f_2:
        if f_1==True:
            if chance_1>chance_2:
                return pic1

            else:
                return pic2
        else:
            print('both pictures are not exist！')
    else:
        if f_1==True:
            return pic1
        else:
            return pic2

def getRed(pic1):
    img=cv2.imread(pic1)
    redImg=img[:,:,2]
    return redImg

def getGreen(pic1):
    img=cv2.imread(pic1)
    greenImg=img[:,:,1]
    return greenImg

def getBlue(pic1):
    img=cv2.imread(pic1)
    blueImg=img[:,:,0]
    return blueImg

def getPicAtPostion(x1,y1,x2,y2):
    box=(x1,y1,x2,y2)
    img=ImageGrab.grab(box)

    return img



if __name__ == '__main__':
    #getPos(None, **args)
    #print("Python图形匹配!"+sys.argv[0])
    if len(sys.argv)==2:
        childPic=sys.argv[1]
        pos=getPos(None, childPic)#获得图片在当前屏幕中的位置
        print(pos)
    if len(sys.argv)==3:
        pic1=sys.argv[1]
        pic2=sys.argv[2]
        pic=whichOne(pic1,pic2)
        print(pic)
    if len(sys.argv)==4:
        command=sys.argv[3]
        if command=="getpostion":#获得给定位置的图片
            print("")
    img=getPicAtPostion(000,10,1600,1000)
    img.save("localRegion.png")
    cv2r=getGreen("localRegion.png")

    cv2.imshow('imageGreen',cv2r)
    cv2.imshow('imageBlue',getBlue("localRegion.png"))
    cv2.imshow('imageRed',getRed("localRegion.png"))
    cv2.waitKey()








