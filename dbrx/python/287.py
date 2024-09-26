import hashlib

def calculate_ikm(key):
    # placeholder for calculate_ikm function
    return key

def calculate_okm(key):
    # placeholder for calculate_okm function
    return key

block_size = 16
key = "my_secret_key"
msg = "Hello, World!"

key_ikm = calculate_ikm(key.encode())
key_okm = calculate_okm(key.encode())

si = hashlib.sha256(key_ikm + msg.encode()).digest()
so = key_okm + si

print(so)