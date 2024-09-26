import os
LOCALHOST = "127.0.0.1"
def is_connected():
    return os.system("ping -c 1 " + LOCALHOST) == 0

print(is_connected())