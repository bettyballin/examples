import subprocess
import hashlib

def get_file_info(file_path):
    ls_output = subprocess.check_output(['ls', '-l', file_path]).decode('utf-8')
    md5sum_output = subprocess.check_output(['md5sum', file_path]).decode('utf-8')
    return ls_output, md5sum_output

def calculate_md5sum(file_path):
    md5 = hashlib.md5()
    with open(file_path, 'rb') as f:
        md5.update(f.read())
    return md5.hexdigest()

file_path = '/bin/bash'
ls_output, md5sum_output = get_file_info(file_path)
calculated_md5sum = calculate_md5sum(file_path)

print(ls_output.strip())
print(md5sum_output.strip())
print(f'Calculated MD5 sum: {calculated_md5sum}')