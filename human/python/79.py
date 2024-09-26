import struct

def decrypt_block(block):
    return struct.pack('>H', (4142 - int(block, 10)) % 65536)

def decrypt(pwd):
    blocks = [pwd[i:i+5] for i in range(0, len(pwd), 5)] 
    return ''.join(map(decrypt_block, blocks)).decode('utf-16-be')

# Test the function
pwd = "123456789012345"
print(decrypt(pwd))