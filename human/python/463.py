Here is the executable Python code:


import hashlib
import os

username = b"LoginUser"
password = b"LoginPass"
nonce = b"1234567890"

def sha256(s):
    return hashlib.sha256(s).digest()

def sha1(s):
    return hashlib.sha1(s).digest()

def sha256_hex(s):
    return hashlib.sha256(s).hexdigest()

def sha1_hex(s):
    return hashlib.sha1(s).hexdigest()

step1 = sha256(username) 
step2 = sha1(password) 
step3 = sha256(step1 + step2) 

print(f"""
SHA256(username={username.decode('utf-8')})                            =    {step1.hex()}
SHA1(password={password.decode('utf-8')})                              =    {step2.hex()}
SHA256((username + password)={username.decode('utf-8')+password.decode('utf-8')})      =    {step3.hex()}
""")