import win32api
import win32con
import time
import random

x = 100  # replace with desired x-coordinate
y = 100  # replace with desired y-coordinate

win32api.SetCursorPos((x, y))
time.sleep(random.uniform(0, 100.) / 1e3) 
win32api.mouse_event(win32con.MOUSEEVENTF_LEFTDOWN, 0, 0, 0, 0)

# Perform the action here

time.sleep(random.uniform(10, 200.) / 1e3) 
win32api.mouse_event(win32con.MOUSEEVENTF_LEFTUP, 0, 0, 0, 0)