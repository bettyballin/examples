
with zipfile.ZipFile(path, 'w') as my_zip3:
    for folderName, subfolders, filenames in os.walk(directoryname):
        for filename in filenames:
