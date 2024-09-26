import os
import shutil

def sanitize_input(userinput):
    return userinput.strip('/')

base_dir = '/my/defined/path'
userinput  = '../../'

# Sanitize input and join with the absolute path to prevent traversal attacks
abs_base_dir = os.path.abspath(base_dir)
joined_path = os.path.join(abs_base_dir, sanitize_input(userinput))

if not (os.path.commonprefix([abs_base_dir, joined_path]) == abs_base_dir):
    raise ValueError("Invalid user input")

# Now it's safe to use shutil.rmtree on the sanitized path
shutil.rmtree(joined_path)