import os
import hashlib
import base64

def obs_filename(text):
    hashed = hashlib.sha256()
    hashed.update(bytes(text, 'utf-8'))

    # Base64 encode the SHA256 digest
    encoded = base64.b32encode(hashed.digest())

    return str(encoded).replace('=', '')

def deobs_filename(obfuscated):
    decoded = base64.b32decode((str(obfuscated) + '==='))

    # Hash the original filename
    hashed = hashlib.sha256()
    hashed.update(decoded)

    return str(hashed.hexdigest())

# Test the functions
text = "Hello, World!"
obfuscated = obs_filename(text)
print("Obfuscated:", obfuscated)

deobfuscated = deobs_filename(obfuscated)
print("Deobfuscated:", deobfuscated)