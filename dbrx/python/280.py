import base64

iv_base64 = "XXXX"
key_base64 = "XXXX"

# Decode from Base 64 to bytes
iv_bytes = base64.b64decode(iv_base64.replace("X", "A"))
key_bytes = base64.b64decode(key_base64.replace("X", "A"))

print(len(iv_bytes)) 
print(len(key_bytes))