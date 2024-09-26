import os
import subprocess

# Create directories
os.mkdir("dist")
os.mkdir("dist/build")

# Run PyInstaller
subprocess.run([
    "pyinstaller",
    "--onefile",
    "--windowed",
    "--workpath=dist/build",
    "--distpath=dist",
    "--icon=gui/icon.ico",
    "--name=The_Greatest_Prog",
    "the_greatest_script.py"
])

# Remove build directory
subprocess.run(["rmdir", "/S", "/Q", "dist/build"])

# Change directory and run the program
os.chdir("dist")
subprocess.run(["The_Greatest_Prog"])

# Pause
input("Press Enter to continue...")