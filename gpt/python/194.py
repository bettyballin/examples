
import base64

def ord_py(char):
    return ord(char)

def chr_py(ascii_num):
    return chr(ascii_num)

def encrypt(sData, sKey):
    sResult = ""
    for i in range(len(sData)):
        sChar = sData[i]
        sKeyChar = sKey[i % len(sKey) - 1]
        # The encryption process is the reverse of decryption, so we add instead of subtract
        sChar = ord_py(sChar) + ord_py(sKeyChar)
        sChar = chr_py(sChar)
        sResult += sChar
    # Convert the result to base64 encoding
    return base64.b64encode(sResult.encode('utf-8')).decode('utf-8')

# Example usage:
plaintext = "Your message here"
key = "w
