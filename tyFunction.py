#-*-coding: utf-8 -*-
import time
import patternMatching
import win32api
import win32con
from pymouse import PyMouse
from pykeyboard import PyKeyboard

VK_CODE = {
  'backspace':0x08,
  'tab':0x09,
  'clear':0x0C,
  'enter':0x0D,
  'shift':0x10,
  'ctrl':0x11,
  'alt':0x12,
  'pause':0x13,
  'caps_lock':0x14,
  'esc':0x1B,
  'spacebar':0x20,
  'page_up':0x21,
  'page_down':0x22,
  'end':0x23,
  'home':0x24,
  'left_arrow':0x25,
  'up_arrow':0x26,
  'right_arrow':0x27,
  'down_arrow':0x28,
  'select':0x29,
  'print':0x2A,
  'execute':0x2B,
  'print_screen':0x2C,
  'ins':0x2D,
  'del':0x2E,
  'help':0x2F,
  '0':0x30,
  '1':0x31,
  '2':0x32,
  '3':0x33,
  '4':0x34,
  '5':0x35,
  '6':0x36,
  '7':0x37,
  '8':0x38,
  '9':0x39,
  'a':0x41,
  'b':0x42,
  'c':0x43,
  'd':0x44,
  'e':0x45,
  'f':0x46,
  'g':0x47,
  'h':0x48,
  'i':0x49,
  'j':0x4A,
  'k':0x4B,
  'l':0x4C,
  'm':0x4D,
  'n':0x4E,
  'o':0x4F,
  'p':0x50,
  'q':0x51,
  'r':0x52,
  's':0x53,
  't':0x54,
  'u':0x55,
  'v':0x56,
  'w':0x57,
  'x':0x58,
  'y':0x59,
  'z':0x5A,
  'numpad_0':0x60,
  'numpad_1':0x61,
  'numpad_2':0x62,
  'numpad_3':0x63,
  'numpad_4':0x64,
  'numpad_5':0x65,
  'numpad_6':0x66,
  'numpad_7':0x67,
  'numpad_8':0x68,
  'numpad_9':0x69,
  'multiply_key':0x6A,
  'add_key':0x6B,
  'separator_key':0x6C,
  'subtract_key':0x6D,
  'decimal_key':0x6E,
  'divide_key':0x6F,
  'F1':0x70,
  'F2':0x71,
  'F3':0x72,
  'F4':0x73,
  'F5':0x74,
  'F6':0x75,
  'F7':0x76,
  'F8':0x77,
  'F9':0x78,
  'F10':0x79,
  'F11':0x7A,
  'F12':0x7B,
  'F13':0x7C,
  'F14':0x7D,
  'F15':0x7E,
  'F16':0x7F,
  'F17':0x80,
  'F18':0x81,
  'F19':0x82,
  'F20':0x83,
  'F21':0x84,
  'F22':0x85,
  'F23':0x86,
  'F24':0x87,
  'num_lock':0x90,
  'scroll_lock':0x91,
  'left_shift':0xA0,
  'right_shift ':0xA1,
  'left_control':0xA2,
  'right_control':0xA3,
  'left_menu':0xA4,
  'right_menu':0xA5,
  'browser_back':0xA6,
  'browser_forward':0xA7,
  'browser_refresh':0xA8,
  'browser_stop':0xA9,
  'browser_search':0xAA,
  'browser_favorites':0xAB,
  'browser_start_and_home':0xAC,
  'volume_mute':0xAD,
  'volume_Down':0xAE,
  'volume_up':0xAF,
  'next_track':0xB0,
  'previous_track':0xB1,
  'stop_media':0xB2,
  'play/pause_media':0xB3,
  'start_mail':0xB4,
  'select_media':0xB5,
  'start_application_1':0xB6,
  'start_application_2':0xB7,
  'attn_key':0xF6,
  'crsel_key':0xF7,
  'exsel_key':0xF8,
  'play_key':0xFA,
  'zoom_key':0xFB,
  'clear_key':0xFE,
  '+':0xBB,
  ',':0xBC,
  '-':0xBD,
  '.':0xBE,
  '/':0xBF,
  '`':0xC0,
  ';':0xBA,
  '[':0xDB,
  '\\':0xDC,
  ']':0xDD,
  "'":0xDE,
  '`':0xC0}

def wait(s):#方便控制程序中的所有时间暂停，需要修改可以一次性修改所有
    if s=='short':
        time.sleep(0.2)
    elif s=='common':
        time.sleep(0.5)
    elif s=='middle':
        time.sleep(1)
    elif s=='long':
        time.sleep(2)
def click():
    win32api.mouse_event(win32con.MOUSEEVENTF_LEFTDOWN, 0, 0, 0, 0)
    wait('short')
    win32api.mouse_event(win32con.MOUSEEVENTF_LEFTUP, 0, 0, 0, 0)

def key_input(str=''):
  for c in str:
    win32api.keybd_event(VK_CODE[c],0,0,0)
    win32api.keybd_event(VK_CODE[c],0,win32con.KEYEVENTF_KEYUP,0)
    time.sleep(0.01)

m=PyMouse()
k=PyKeyboard()

def middle(point1,point2):
    return int((point1[0]+point2[0])/2), int((point1[1]+point2[1])/2)

def exists(chiPic):#判断当前屏幕是否存在子图chiPic
    point1,point2,flag=patternMatching.getPos(None, chiPic)
    return flag

def OpenTianYu():

    #暂停三秒
    wait('long')

    #点击menu键
    k.tap_key(k.windows_l_key)
    wait('common')

    #点击任务栏天谕图标
    clickPic='TianYuTuBiao.png'
    point1, point2, flag, chance=patternMatching.getPos(None,clickPic)
    print(flag)
    x,y=middle(point1, point2)
    m.click(x,y)


    #可以在此添加判断是否打开天谕，根据“TianYuChuangKouTitle.png是否在当前截屏能找到判断”
    wait('short')
    clickPic='TianYuChuangKouTitle.png'
    #import pdb
    #pdb.set_trace()
    point1, point2,flag,chance = patternMatching.getPos(None, clickPic)
    print(flag)
    x, y = middle(point1, point2)
    m.click(x, y)
    wait('long')

def OpenJueSeJieMian():
    wait('short')
    clickPic='JueSeJieMianTuBiao.png'
    point1,point2,flag,chance=patternMatching.getPos(None,clickPic)
    print(flag)
    x,y=middle(point1,point2)
    m.move(x,y)
    #m.click(x,y)
    click()
    #for i in range(5):
     #   wait('common')
     #   if not exists('RenWuShuXingJieMian.png'):
     #       print('not exists!')
     #       m.click(x,y)
     #   else:
     #       break

def OpenShengWang():
    clickPic='ShengWangTuBiao.png'
    clickIcon(clickPic)

def ZheDieMenPaiShengWang():
    clickPic='MenPaiShengWangZheDie.png'
    clickIcon(clickPic)

def ZhanKaiSuLanJunShengWang():
    clickPic='SuLanJunShengWangZhanKai.png'
    clickIcon(clickPic)

def SelectSuLanChengShengWang():
    clickPic='SuLanChengShengWang.png'
    clickIcon(clickPic)

def ClickShengWangWanFa():
    wait('common')
    clickPic='DianJiChaKanShengWangWanFa.png'
    clickIcon(clickPic)

def ClickSLJiuGuan():
    clickPic='JiuGuanYingLaiSongWang.png'
    clickIcon(clickPic)
    closeShengWangMianBan()



def clickIcon(icon):
    wait('common')
    try:
        point1, point2, flag, chance = patternMatching.getPos(None, icon)
        print(flag)
        x, y = middle(point1, point2)
        wait('common')
        m.move(x - 1, y + 1)
        wait('common')
        click()
    except:
        return

def selectXianGuShengWang():
    clickIcon('XianGuShengWang.png')

def ClickShanYuXianGu():
    clickIcon('ShanYuXianGu.png')

def closeShengWangMianBan():
    clickPic='closeShengWangMianBan.png'
    clickIcon(clickPic)

def AcceptTask():#和当前NPC完成所有对话，知道无法对话为止
    wait('common')
    acceptPic = 'Accept.png'
    continuePic='continue.png'
    while True:
        if patternMatching.whichOne(acceptPic, continuePic) == acceptPic:
            point1, point2, flag, chance = patternMatching.getPos(None, acceptPic)
            print(flag)
            x, y = middle(point1, point2)
            m.move(x - 1, y + 1)
            wait('common')
            click()
            wait('common')
            kPic='key_F.png'
            point1, point2, flag, chance = patternMatching.getPos(None, kPic)
            print(flag)
            x, y = middle(point1, point2)
            wait('common')
            m.move(x - 1, y + 1)
            wait('common')
            click()
        else:
            point1, point2, flag, chance = patternMatching.getPos(None, continuePic)
            print(flag)
            x, y = middle(point1, point2)
            wait('common')
            m.move(x - 1, y + 1)
            wait('common')
            click()
        if patternMatching.whichOne('Escape.png','RightUpIcons.png')=='RightUpIcons.png':
            break

def WaitRenWu():
    wait('common')
    #如果存在接受任务的图标，则表示人已经到了NPC面前
    #如果存在comparePic的图标，则表示任务还没跑到
    #因为判断图标是否存在，不一定准确，此处可判断哪个存在的概率大，就认为哪个存在
    clickPic='Escape.png'
    comparePic='RightUpIcons.png'
    while True:
        wait('common')
        if patternMatching.whichOne(clickPic,comparePic)==clickPic:
            break

def GoToFirstTask():
    wait('common')
    k.press_keys([k.control_l_key,'f'])
    WaitRenWu()