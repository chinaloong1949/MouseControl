#!/usr/bin/env python
# encoding: utf-8

import numpy as np
import pdb
import cv2
def get_EuclideanDistance(x,y):
    myx=np.array(x)
    myy=np.array(y)
    return np.sqrt(np.sum((myx-myy)*(myx-myy)))

fn="meinv.jpg"

if __name__ == '__main__':

    print ('loading %s ...' % fn)
    print('working'),
    myimg1 = cv2.imread(fn)
    #pdb.set_trace()
    cv2.imshow('w',myimg1)
    cv2.waitKey(0)
    w=myimg1.shape[1]
    h=myimg1.shape[0]
    sz1=w
    sz0=h

    #创建空白图像
    myimg2=np.zeros((sz0,sz1,3), np.uint8)
    #对比生成线条
    black=np.array([0,0,0])
    white=np.array([255,255,255])
    centercolor=np.array([125,125,125])
    yuzhi=20
    for y in range(0,sz0-1):
        for x in range(0,sz1-1):
            mydown=myimg1[y+1,x,:]
            myright=myimg1[y,x+1,:]

            myhere=myimg1[y,x,:]
            lmyhere=myhere
            lmyright=myright
            lmydown=mydown
            if get_EuclideanDistance(lmyhere,lmydown)>yuzhi and \
                get_EuclideanDistance(lmyhere,lmyright)>yuzhi:
                myimg2[y,x,:]=black
            elif get_EuclideanDistance(lmyhere, lmydown)<=yuzhi and \
                get_EuclideanDistance(lmyhere,lmyright)<=yuzhi:
                myimg2[y,x,:]=white
            else:
                myimg2[y,x,:]=centercolor
            #print('.')
    cv2.namedWindow('img2')
    cv2.imshow('img2',myimg2)
    cv2.waitKey()
    cv2.destroyAllWindows()


