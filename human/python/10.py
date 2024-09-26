import os
import base64

def secure_rand(len=8):
    token=os.urandom(len)
    return base64.b64encode(token)

if __name__ == "__main__":
    print(secure_rand())