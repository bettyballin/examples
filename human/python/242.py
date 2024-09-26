import hashlib

text = "PARAMETER123"
sha1hash = hashlib.sha1(text.encode("UTF-8")).digest()
encrypted_text = sha1hash.hex()

print(encrypted_text)