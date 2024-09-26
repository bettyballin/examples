import glob
import os

def encrypt_file(file_path):
    # Your encryption logic here
    pass

directory_path = '.'  # replace with your directory path
for file in glob.glob('**/*', recursive=True):
    file_path = os.path.join(directory_path, file)
    encrypt_file(file_path)