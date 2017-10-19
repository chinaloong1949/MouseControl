#-*-coding: utf-8 -*-
import time
import patternMatching
import win32api
import win32con
from pymouse import PyMouse
from pykeyboard import PyKeyboard

k=PyKeyboard()
time.sleep(5)
k.tap_key('f')
time.sleep(1)
while True:
    time.sleep(1)
    k.tap_key('F')
    time.sleep(1)
    k.press_key('F')
    time.sleep(0.2)
    k.release_key('F')
    time.sleep(1)
    k.tap_key('e')
print("over")