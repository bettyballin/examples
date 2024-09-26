import base64

def base64url_to_bytes(s):
    s = s.replace('-', '+').replace('_', '/')
    padding = '=' * (4 - len(s) % 4)
    return base64.b64decode(s + padding)

x_value = base64url_to_bytes("ARriqkpHlC1Ia1Tk86EM_bqH_9a88Oh2zMYF3fUUGJw")
y_value = base64url_to_bytes("wTYd3CEiwTk1n-lFPdpZ51P4Z0EzlVNXLvJMY-k55pQ")

# padding with leading 0x00 values
x_32 = (32 - len(x_value)) * b'\0' + x_value
y_32 = (32 - len(y_value)) * b'\0' + y_value

compressed = (b'\02' if y_32[31] % 2 == 0 else b'\03') + x_32
uncompressed = b'\04' + x_32 + y_32

print(compressed.hex())    
print(uncompressed.hex())