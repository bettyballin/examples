import sys
import os
from cryptography.fernet import Fernet
import json

key = Fernet.generate_key()
f = Fernet(key)

with open("storage.json", "a+") as file:
    if os.stat("storage.json").st_size == 0:
        file.write("{}")
    file.seek(0)
    storage = json.load(file)


def write(data):
    with open("storage.json", "w") as file:
        json.dump({k: v.hex() for k, v in data.items()}, file)


def encrypt(pw):
    token = f.encrypt(bytes(pw, "utf-8"))
    return token


def decrypt(token_hex_str):
    try:
        decrypted_token_bytes = f.decrypt(bytes.fromhex(token_hex_str))
        print("decrypted:", decrypted_token_bytes.decode())
    except Exception as e:
        print(f"Error decrypting token ({token_hex_str}): {str(e)}")


if len(sys.argv) == 1:
    to_encrypt = input("A key to encrypt: ")
    storage[to_encrypt] = f.encrypt(bytes(to_encrypt, "utf-8")).hex()
    print("encrypted:", storage[to_encrypt])
    write(storage)

elif len(sys.argv) == 2:
    to_decrypt = sys.argv[1]
    decrypt(storage.get(to_decrypt))