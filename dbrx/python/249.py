import shlex
import subprocess

devices = ['device1', 'device2', 'device3']  # replace with your actual device list

for p in devices:
    subprocess.Popen(shlex.split(r'C:\\Users\\Name\\Documents\\CRT\\SecureCRT.EXE /S ' + p))