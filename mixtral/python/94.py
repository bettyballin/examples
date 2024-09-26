import os
from PyInstaller.utils.hooks import collect_data_files

datas = []

# Add the cffi backend data files
backend_path = 'cffi/_backend'
for root, dirs, files in os.walk(os.path.join('site-packages', backend_path)):
    for file in files:
        datas.append((root + '/' + file, root))

# Add the ctypes data files
ctypes_path = 'Lib/ctypes/'
for root, dirs, files in os.walk(os.path.join('site-packages', ctypes_path)):
    for file in files:
        datas.append((root + '/' + file, root))

# Add the _cffi_backend data files
datas += collect_data_files("_cffi_backend")

block_cipher = None