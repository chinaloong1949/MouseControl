#-*-coding: utf-8 -*-
from PIL import ImageGrab
import patternMatching
import time
import tyFunction as ty

#clickPic='ShengWangTuBiao.png'
#point1,point2,flag=patternMatching.getPos('screenPic.png',clickPic)
ty.OpenTianYu()
ty.OpenJueSeJieMian()
ty.OpenShengWang()
ty.ZheDieMenPaiShengWang()
ty.ZhanKaiSuLanJunShengWang()

ty.selectXianGuShengWang()
ty.ClickShengWangWanFa()
ty.ClickShanYuXianGu()
ty.WaitRenWu()
ty.AcceptTask()
ty.closeShengWangMianBan()

while True:
    #p1,p2,flag,chance=patternMatching.getPos(None,'SLJiuGuaning.png')
    flag=True
    if flag==True:
        try:
            ty.GoToFirstTask()
            ty.AcceptTask()
        except:
            print("")
    else:
        break

#ty.SelectSuLanChengShengWang()
#ty.ClickShengWangWanFa()
#ty.ClickSLJiuGuan()
#ty.WaitRenWu()
#ty.AcceptTask()
#ty.closeShengWangMianBan()
#while True:
#   p1,p2,flag,chance=patternMatching.getPos(None,'SLJiuGuaning.png')
#    if flag==True:
#        try:
#            ty.GoToFirstTask()
#            ty.AcceptTask()
#        except:
#            print("")
#    else:
#        break



