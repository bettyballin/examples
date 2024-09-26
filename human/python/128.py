import zipfile

zfile = zipfile.ZipFile("file.zip")

with open("/usr/share/dict/words", "r") as words:
    for word in words.readlines():
        try:
            password = word.strip("\n")
            zfile.extractall(pwd=password.lower().encode())
            print("Password found: "+ password)
            exit(0)
        except Exception as e:
            pass