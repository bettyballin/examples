import zipfile

zfile = zipfile.ZipFile('password_archive.zip')

with open('/usr/share/dict/words', 'r') as words:
    for word in words:
        try:
            password = word.strip()
            zfile.extractall(pwd=bytes(password, "utf-8"))
            print("Password found:", password)
            break
        except RuntimeError as e:
            if str(e).startswith('Bad password for file'):
                continue