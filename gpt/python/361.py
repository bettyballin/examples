
import subprocess

devices = ['device1', 'device2', 'device3']  # Replace with your actual device names

for device in devices:
    subprocess.Popen([r'C:\Users\Name\Documents\CRT\SecureCRT.EXE', '/S', '\\DEVICES\\' + device])

