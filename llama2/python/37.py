import os
import shutil

def validate_path(path):
    return os.path.exists(path) and os.path.isdir(path)

userinput = '../../'
path = os.path.join('/my/self/defined/path', userinput)
path = os.path.abspath(path)

if validate_path(path):
    shutil.rmtree(path)
else:
    print("Invalid path")