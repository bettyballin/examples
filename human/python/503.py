import base64

def customEncode(ciphertextB64):
    cipherbytes = base64.b64decode(ciphertextB64)
    ciphertext = cipherbytes.decode('utf8')
    undefCodepoints = [0x81, 0x8d, 0x8f, 0x90, 0x9d]
    result = []
    for char in ciphertext:
        if ord(char) in undefCodepoints:
            data = bytes([ord(char)])           
        else:
            data = char.encode('cp1252')  
        result.append(data)
    return b''.join(result)

# Test the function
ciphertextB64 = "SGVsbG8gd29ybGQ="  # Replace with your base64 encoded string
encoded_bytes = customEncode(ciphertextB64)
print(encoded_bytes)