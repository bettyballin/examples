import os

my = os.path.abspath('/my/self/defined/path')
new = os.path.abspath('/my/self/defined/path/subdir')
if len(new) < len(my) or not new.startswith(my):
   print('bzzzt')