import os

src = "https://ssl.server.tlb/path/to/file"
target = "/path/to/saved_file"

os.system("wget -O " + target + " --no-check-certificate " + src)