import base64
from pathlib import Path

from cryptography.fernet import Fernet, InvalidToken

key = Fernet.generate_key()
f = Fernet(key)
encrypted = f.encrypt(b'Hello world')

p1, p2 = Path('file1'), Path('file2')
p1.write_bytes(encrypted)
p2.write_bytes(base64.urlsafe_b64encode(b'\x80not encrypted'))

for example in (p1, p2):
    try:
        data = example.read_bytes()
        decrypted = f.decrypt(data)
        print(f"Decrypted data from {example}: {decrypted}")
    except InvalidToken:
        encrypted_data = f.encrypt(data)
        example.write_bytes(encrypted_data)
        print(f"Encrypted data and wrote to {example}")