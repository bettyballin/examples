from base64 import b64encode, b64decode
from Crypto.Cipher import DES3
from Crypto.Hash import MD5

def md5_hash(value: str) -> bytes:
    return MD5.new(data=value.encode()).digest()

def encrypt(string_to_encrypt: str) -> str:
    des = DES3.new(md5_hash("L6#Fq2$xLx"), mode=DES3.MODE_ECB)
    encrypted_data = des.encrypt(string_to_encrypt.encode())
    return b64encode(encrypted_data).decode()

def decrypt(encrypted_string: str) -> str:
    try:
        decrypted_data = DES3.new(md5_hash("L6#Fq2$xLx"), mode=DES3.MODE_ECB)
        decoded_encrypted_string = b64decode(encrypted_string.encode())
        return decrypted_data.decrypt(decoded_encrypted_string).decode()
    except Exception as e:
        print(f"Error: {e}")
        return None

# Example usage
encrypted = encrypt("Hello, World!")
print(f"Encrypted: {encrypted}")

decrypted = decrypt(encrypted)
print(f"Decrypted: {decrypted}")